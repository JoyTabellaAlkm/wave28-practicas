package com.mercadolibre.be_java_hisp_w28_g10.unit.impl;

import com.mercadolibre.be_java_hisp_w28_g10.DatosMock;
import com.mercadolibre.be_java_hisp_w28_g10.dto.follow.ResponseFollowedPostsDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.post.PostDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.post.ProductDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponsePostNoPromoDTO;
import com.mercadolibre.be_java_hisp_w28_g10.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w28_g10.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w28_g10.model.Post;
import com.mercadolibre.be_java_hisp_w28_g10.model.Product;
import com.mercadolibre.be_java_hisp_w28_g10.repository.IProductRepository;
import com.mercadolibre.be_java_hisp_w28_g10.repository.IUserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.mercadolibre.be_java_hisp_w28_g10.service.impl.ProductServiceImpl;
import com.mercadolibre.be_java_hisp_w28_g10.util.Utilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private Utilities utilities;

    @InjectMocks
    private ProductServiceImpl productService;

    private LocalDate nowDate;
    private LocalDate dateBeforeTwoWeeks;

    @BeforeEach
    void setUp() {
        nowDate = LocalDate.now();
        dateBeforeTwoWeeks = LocalDate.now().minusWeeks(2);
    }

    @Test
    @DisplayName("Should return a response with posts ordered by publication date in ascending order")
    void getLastFollowedPosts_ReturnPosts_OrderedByDateAscending() {

        //ARRANGE
        int userId = 2;
        String order = "date_asc";

        arrangePostTestForUser2(userId);

        //ACT
        ResponseFollowedPostsDTO response = productService.getLastFollowedPosts(userId, order);

        //ASSERT
        assertAll(
                () -> assertNotNull(response),
                () -> {
                    assertTrue(IntStream.range(1, response.getPostDTOList().size())
                            .allMatch(i -> {
                                List<ResponsePostNoPromoDTO> list = response.getPostDTOList();
                                String fechaPostString = list.get(i).getDate();
                                LocalDate fechaPost = LocalDate.parse(fechaPostString);
                                return !fechaPost.isBefore(LocalDate.parse(list.get(i - 1).getDate()));
                            })

                    );
                }
        );
    }

    @Test
    @DisplayName("Should return a response with posts ordered by publication date in descending order")
    void getLastFollowedPosts_ReturnPosts_OrderedByDateDescending() {

        //ARRANGE
        int userId = 2;
        String order = "date_desc";

        arrangePostTestForUser2(userId);

        //ACT
        ResponseFollowedPostsDTO response = productService.getLastFollowedPosts(userId, order);

        //ASSERT
        assertAll(
                () -> assertNotNull(response),
                () -> {
                    assertTrue(IntStream.range(1, response.getPostDTOList().size())
                            .allMatch(i -> {
                                List<ResponsePostNoPromoDTO> list = response.getPostDTOList();
                                String fechaPostString = list.get(i).getDate();
                                LocalDate fechaPost = LocalDate.parse(fechaPostString);
                                return fechaPost.isBefore(LocalDate.parse(list.get(i - 1).getDate()));
                            })

                    );
                }
        );
    }

    @Test
    @DisplayName("Should return a list of posts whose publication date is within the last two weeks")
    void getLastFollowedPosts_ReturnPosts_WithinLastTwoWeeks() {

        //ARRANGE
        int userId = 2;
        String order = "date_asc";

        arrangePostTestForUser2(userId);

        //ACT
        ResponseFollowedPostsDTO response = productService.getLastFollowedPosts(userId, order);

        //ASSERT
        assertAll(
                () -> assertNotNull(response),
                () -> assertEquals(6, response.getPostDTOList().size()),
                () -> {
                    response.getPostDTOList().forEach(x -> {
                        String fechaPostString = x.getDate();
                        LocalDate fechaPost = LocalDate.parse(fechaPostString);
                        assertTrue(!fechaPost.isBefore(dateBeforeTwoWeeks) && !fechaPost.isAfter(nowDate));
                    });
                }
        );
    }

    @Test
    @DisplayName("Should throw NotFoundException when the user ID is invalid")
    void getLastFollowedPosts_Throw_UserNotFoundException() {

        //ARRANGE
        int userId = 0;
        String order = "date_asc";
        when(userRepository.findUserById(userId)).thenReturn(null);

        //ACT & ASSERT
        NotFoundException exception = assertThrows(NotFoundException.class, () -> productService.getLastFollowedPosts(userId, order));
        assertEquals("User not found", exception.getMessage());


    }

    @Test
    @DisplayName("Should throw BadRequestException when the order criteria is invalid")
    void getLastFollowedPosts_ThrowBadRequestException_WhenOrderCriteriaIsInvalid() {

        //ARRANGE
        int userId = 2;
        String order = "date_asc_FALLA";

        arrangePostTestForUser2(userId);

        //ACT & ASSERT
        BadRequestException exception = assertThrows(BadRequestException.class, () -> productService.getLastFollowedPosts(userId, order));
        assertEquals("That's not a valid order criteria: " + order, exception.getMessage());
    }

    @Test
    @DisplayName("Should return a PostDTO of the created Post with promo")
    void addPromoPost_createPost_happyPath() {
        // Arrange
        mockSavePostLogic();

        // Act
        PostDTO obtainedDTO = productService.addPromoPost(DatosMock.POST_DTO_1);

        // Assert
        assertEquals(DatosMock.POST_DTO_1, obtainedDTO);
    }

    @Test
    @DisplayName("Should return a ResponsePostNoPromoDTO of the created Post with no promo")
    void addPost_createPost_happyPath() {
        // Arrange
        mockSavePostLogic();
        when(utilities.convertValue(DatosMock.POST_DTO_1, Post.class)).thenReturn(DatosMock.POST_1);
        when(utilities.convertValue(DatosMock.POST_1.getProduct(), ProductDTO.class)).thenReturn(DatosMock.POST_DTO_1.getProduct());

        // Act
        ResponsePostNoPromoDTO obtainedDTO = productService.addPost(DatosMock.POST_DTO_1);

        // Assert
        assertEquals(DatosMock.RESPONSE_POST_NO_PROMO_DTO , obtainedDTO);
    }

    private void mockSavePostLogic() {
        when(utilities.convertValue(DatosMock.POST_DTO_1.getProduct(), Product.class)).thenReturn(DatosMock.POST_1.getProduct());
        when(productRepository.existsProduct(DatosMock.POST_1.getProduct().getId())).thenReturn(false);
        when(productRepository.addProduct(DatosMock.POST_1.getProduct())).thenReturn(true);
        when(utilities.convertValue(DatosMock.POST_DTO_1, Post.class)).thenReturn(DatosMock.POST_1);
        when(productRepository.addPost(DatosMock.POST_1)).thenReturn(true);
    }

    private void arrangePostTestForUser2(int userId) {
        when(userRepository.findUserById(userId)).thenReturn(DatosMock.USER_2);
        when(userRepository.getFollowRelationsByFollowerId(userId)).thenReturn(DatosMock.FOLLOW_RELATIONS_2);
        when(productRepository.findAllPost()).thenReturn(DatosMock.POST_LIST);
    }

    @Test
    @DisplayName("Should return a list of elements only when the order string is valid")
    void getLastFollowedPosts_ascendingOrderArgumentIsValid_happyPathOrderExists() {
        //ARRANGE
        Integer userId = 2;

        when(productRepository.findAllPost()).thenReturn(DatosMock.POST_LIST);
        when(userRepository.getFollowRelationsByFollowerId(2)).thenReturn(DatosMock.FOLLOW_RELATIONS_2);
        when(userRepository.findUserById(2)).thenReturn(DatosMock.USER_2);
        String order = "date_asc";

        //ACT
        ResponseFollowedPostsDTO result = productService.getLastFollowedPosts(userId, order);

        //ASSERT
        assertNotNull(result, "Result should not be null");
    }
}
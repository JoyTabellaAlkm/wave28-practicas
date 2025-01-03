package com.meli.be_java_hisp_w28_g01.unitTest.service;

import com.meli.be_java_hisp_w28_g01.dto.request.ProductDto;
import com.meli.be_java_hisp_w28_g01.dto.response.FollowedSellersDto;
import com.meli.be_java_hisp_w28_g01.dto.response.PostByUserDto;
import com.meli.be_java_hisp_w28_g01.dto.response.ResponsePostDto;
import com.meli.be_java_hisp_w28_g01.dto.response.SellerDto;
import com.meli.be_java_hisp_w28_g01.model.Post;
import com.meli.be_java_hisp_w28_g01.model.Product;
import com.meli.be_java_hisp_w28_g01.model.Seller;
import com.meli.be_java_hisp_w28_g01.repository.impl.PostRepositoryImpl;
import com.meli.be_java_hisp_w28_g01.service.impl.FollowServiceImpl;
import com.meli.be_java_hisp_w28_g01.service.impl.PostServiceImpl;
import org.assertj.core.api.AbstractLocalDateAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test unitarios para Post Service")
public class PostServiceImplTest {
    @Mock
    private FollowServiceImpl followService;
    @Mock
    private PostRepositoryImpl postRepository;
    @InjectMocks
    private PostServiceImpl postService;

    private List<Post> postList;

    @BeforeEach
    void setUp(){
        postList = new ArrayList<>();
        Seller seller1 = new Seller();
        seller1.setId(1);
        seller1.setName("Pedro");
        Seller seller2 = new Seller();
        seller2.setId(2);
        seller2.setName("Lionel");

        Post post1 = new Post();
        post1.setId(1);
        post1.setSeller(seller1);
        post1.setDate(LocalDate.now().minusDays(3));
        post1.setProduct(new Product(1,"Product A","A","BrandA","Blue","notes"));
        post1.setCategory(2);
        post1.setPrice(80.0);

        Post post2 = new Post();
        post2.setId(2);
        post2.setSeller(seller1);
        post2.setDate(LocalDate.now().minusDays(5));
        post2.setProduct(new Product(2,"Product B","B","BrandB","Red","notes"));
        post2.setCategory(4);
        post2.setPrice(50.0);

        Post post3 = new Post();
        post3.setId(3);
        post3.setSeller(seller2);
        post3.setDate(LocalDate.now().minusDays(20));
        post3.setProduct(new Product(3,"Product C","C","BrandC","Red","notes"));
        post3.setCategory(4);
        post3.setPrice(500.0);

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
    }

//T-0005 -> OK
    @ParameterizedTest
    @ValueSource(strings = {"date_asc", "date_desc"})
    @DisplayName("Valida que la solicitud de lista de post no arroje excepción al enviar parámetro de ordenamiento válido")
    void whenGetPostByUserOrderedByDateIsCalled_shouldAcceptValidOrderingTypes(String order) {
        int userId = 1;
        FollowedSellersDto followedSellersDto = new FollowedSellersDto(1,"Tomas",List.of(new SellerDto(1,"Pedro")));
        when(followService.getFollowedSeller(1)).thenReturn(followedSellersDto);
        when(postRepository.getAll()).thenReturn(postList);

        assertDoesNotThrow(() -> {
            postService.getPostByUserOrderedByDate(userId, order);
        });
    }
//T-0005 -> NO_OK
    @Test
    @DisplayName("Valida que arroje IllegalArgumentException al enviar por parámetro un order inválido al solicitar lista de post")
    void whenGetPostByUserOrderedByDateIsCalledWithInvalidOrder_shouldThrowException() {
        int userId = 3;
        String order = "invalid_order";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            postService.getPostByUserOrderedByDate(userId, order);
        });
        assertEquals("Se ingresó un tipo de ordenamiento incorrecto", thrown.getMessage());
    }
//T-0006 -> OK
    @ParameterizedTest
    @ValueSource(strings = {"date_asc", "date_desc"})
    @DisplayName("Obtengo lista de post ordenada por fecha válida según el tipo de orden enviado por parámetro")
    void whenGetPostByUserOrderedByDateIsCalledWithAscOrder_shouldReturnOrderedList(String order){
        int userId = 1;
        FollowedSellersDto followedSellersDto = new FollowedSellersDto(1,"Tomas",List.of(new SellerDto(1,"Pedro")));
        when(followService.getFollowedSeller(1)).thenReturn(followedSellersDto);
        when(postRepository.getAll()).thenReturn(postList);
        PostByUserDto postByUserDtoFound = postService.getPostByUserOrderedByDate(userId,order);
        Assert.notEmpty(postByUserDtoFound.getPosts(),"La lista de posts se encuentra vacia");
        validatePostDates(postByUserDtoFound,order);
    }

    @Test
    @DisplayName("Obtengo lista de post sin envío de parámetro de ordenamiento, enviando solo userId")
    public void whenGetPostsbyUser_shouldReturnList() {
        List<SellerDto> sellers = List.of(
                new SellerDto(1, "Pedro"),
                new SellerDto(2, "Lionel")
        );
        FollowedSellersDto followedSellers = new FollowedSellersDto(1, "Jose", sellers);

        PostByUserDto expectedPosts = getPostByUserDto();

        when(followService.getFollowedSeller(1)).thenReturn(followedSellers);
        when(postRepository.getAll()).thenReturn(postList);

        PostByUserDto result = postService.getPostsByUser(1);

        assertEquals(expectedPosts, result);
    }

    private PostByUserDto getPostByUserDto() {
        ProductDto product1 = new ProductDto(1,"Product A","A","BrandA","Blue","notes");
        ProductDto product2 = new ProductDto(2,"Product B","B","BrandB","Red","notes");

        List<ResponsePostDto> posts = List.of(
                new ResponsePostDto(1,1, postList.get(0).getDate(), product1, 2, 80.0),
                new ResponsePostDto(1,2, postList.get(1).getDate(), product2, 4, 50.0)
        );

        return new PostByUserDto(1, posts);
    }

    private AbstractLocalDateAssert validatePostDates(PostByUserDto postByUserDto,String order){
        if (order.equals("date_asc")) {
            return assertThat(postByUserDto.getPosts().get(0).getDate()).isBefore(postByUserDto.getPosts().get(1).getDate());
        }else{
            return assertThat(postByUserDto.getPosts().get(0).getDate()).isAfter(postByUserDto.getPosts().get(1).getDate());
        }
    }

}

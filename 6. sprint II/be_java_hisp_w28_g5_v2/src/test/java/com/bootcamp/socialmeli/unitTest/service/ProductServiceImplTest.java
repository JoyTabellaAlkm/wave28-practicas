package com.bootcamp.socialmeli.unitTest.service;

import com.bootcamp.socialmeli.dto.response.GetFollowedProductsDto;
import com.bootcamp.socialmeli.dto.response.PostResponseDto;
import com.bootcamp.socialmeli.exception.NotFoundException;
import com.bootcamp.socialmeli.exception.OrderInvalidException;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.UserRepository;
import com.bootcamp.socialmeli.service.impl.ProductServiceImpl;
import com.bootcamp.socialmeli.util.mapper.PostMapper;
import com.bootcamp.socialmeli.utils.PostFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    ProductServiceImpl productService;

    private User user;
    private Product product1;
    private Post post1;
    private Post post2;
    private Post post3;
    private User followedUser;

    final private Long userId = 1L;
    final private String ORD_DATE_ASC = "date_asc";
    final private String ORD_DATE_DESC = "date_desc";

    @BeforeEach
    public void setUp(){
        user = new User(userId, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        product1 = new Product(1L, "Product 1", "Type 1", "Brand A", "Red", "Notes about product 1");

        post1 = new Post(1L, LocalDate.now().minusDays(1), product1, 1, 100.0, false, 0.0);
        post2 = new Post(2L, LocalDate.now().minusDays(15), product1, 1, 100.0, false, 0.0);
        post3 = new Post(3L, LocalDate.now().minusDays(10), product1, 1, 100.0, false, 0.0);

        followedUser = new User(2L, "Jane Doe", new ArrayList<>(), new ArrayList<>(), List.of(post1, post2, post3));
    }

    @Test
    @DisplayName("T-0006: se ordena descendentemente por nombre correctamente")
    void getFollowedProductsOrderByDateDesc() {
        // Arrange
        user.getFollowed().add(followedUser);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        // Act
        GetFollowedProductsDto result = productService.followedProducts(userId, Optional.of(ORD_DATE_DESC));

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());

        List<PostResponseDto> posts = result.getPosts();
        assertEquals(2, posts.size());
        assertEquals(post1.getId(), posts.get(0).getId());
        assertEquals(post3.getId(), posts.get(1).getId());

        Mockito.verify(userRepository).findById(userId);
    }

    @Test
    @DisplayName("T-0006: se ordena ascendentemente por nombre correctamente")
    void getFollowedProductsOrderByDateAsc() {
        // Arrange
        user.getFollowed().add(followedUser);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        // Act
        GetFollowedProductsDto result = productService.followedProducts(userId, Optional.of(ORD_DATE_ASC));

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());

        List<PostResponseDto> posts = result.getPosts();
        assertEquals(2, posts.size());
        assertEquals(post3.getId(), posts.get(0).getId());
        assertEquals(post1.getId(), posts.get(1).getId());
    }

    @Test
    @DisplayName("T-0005: el tipo de ordenamiento ascendente existe")
    void getFollowedProductsOrderByDateAscExists() {
        user.getFollowed().add(followedUser);
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        GetFollowedProductsDto result = productService.followedProducts(userId, Optional.of(ORD_DATE_ASC));

        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertNotNull(result.getPosts());
    }

    @Test
    @DisplayName("T-0005: el tipo de ordenamiento descendente existe")
    void getFollowedProductsOrderByDateDescExists() {
        user.getFollowed().add(followedUser);
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        GetFollowedProductsDto result = productService.followedProducts(userId, Optional.of(ORD_DATE_DESC));

        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertNotNull(result.getPosts());
    }

    @Test
    void getFollowedProductsNoTypeOrder() {
        // Arrange
        user.getFollowed().add(followedUser);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        // Act
        GetFollowedProductsDto result = productService.followedProducts(userId, Optional.empty());

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        assertEquals(2, result.getPosts().size());
    }

    @Test
    void getFollowedProductsUserNotFound() {
        // Arrange
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(NotFoundException.class, () -> {
            productService.followedProducts(userId, Optional.of(ORD_DATE_DESC));
        });
        assertEquals("User with id: 1 not found", exception.getMessage());
        Mockito.verify(userRepository).findById(userId);
    }

    @Test
    @DisplayName("T-0005: el tipo de ordenamiento no existe")
    void getFollowedProductsInvalidTypeOrder() {
        // Arrange
        user.getFollowed().add(followedUser);
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act and Assert
        assertThrows(OrderInvalidException.class, () -> productService.followedProducts(userId, Optional.of("not_a_sort_order")));
    }

    @Test
    @DisplayName("T-0008: devuelve unicamente post de las ultimas 2 semanas")
    void getFollowedProducts(){
        //Arrange
        List<Post> posts= PostFactory.createPost();
        user.getFollowed().add(
                new User(
                        2L,
                        "Jane Doe",
                        new ArrayList<>(),
                        new ArrayList<>(),
                        posts
                )
        );
        //Act
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        GetFollowedProductsDto getFollowedProductsDto = productService.followedProducts(userId,
                Optional.empty()
        );
        //Assert
        assertNotNull(getFollowedProductsDto);
        assertEquals(PostMapper.toPostResponseDto(posts.get(0), 2L), getFollowedProductsDto.getPosts().get(0));
        assertEquals(3, getFollowedProductsDto.getPosts().size());
    }
}
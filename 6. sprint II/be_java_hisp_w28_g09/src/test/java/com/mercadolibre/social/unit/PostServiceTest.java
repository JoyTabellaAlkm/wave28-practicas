package com.mercadolibre.social.unit;

import com.mercadolibre.social.dto.response.PostDetailsDTO;
import com.mercadolibre.social.dto.response.ProductResponseDTO;
import com.mercadolibre.social.dto.response.UserPostsResponseDTO;
import com.mercadolibre.social.entity.Post;
import com.mercadolibre.social.entity.Product;
import com.mercadolibre.social.entity.User;
import com.mercadolibre.social.exception.BadRequestException;
import com.mercadolibre.social.repository.impl.PostRepository;
import com.mercadolibre.social.repository.impl.ProductRepository;
import com.mercadolibre.social.repository.impl.UserRepository;
import com.mercadolibre.social.service.impl.PostService;
import com.mercadolibre.social.util.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("UT-05: Verificar que el tipo de ordenamiento por fecha exista")
    void givenOrder_whenOrderExists_thenReturnOrderedPosts() {
        // ARRANGE
        String order = "date_desc";
        Integer userId = 1;
        Integer followedUserId = 2;

        User expectedUser = new User(userId, "John Doe", Set.of(followedUserId), Set.of());
        when(userRepository.findById(expectedUser.getId())).thenReturn(expectedUser);

        List<Post> expectedPosts = List.of(
                new Post(1, followedUserId, LocalDate.now(), 1, 1, 10.0, false, 0.0),
                new Post(2, followedUserId, LocalDate.now().minusDays(1), 2, 1, 10.0, false, 0.0));
        when(postRepository.findAll()).thenReturn(expectedPosts);

        Integer productId1 = 1;
        Integer productId2 = 2;

        when(productRepository.findById(productId1)).thenReturn(
                new Product(
                        1,
                        "Name",
                        "Type",
                        "Brand",
                        "Color",
                        "Notes"));

        when(productRepository.findById(productId2)).thenReturn(
                new Product(
                        2,
                        "Name",
                        "Type",
                        "Brand",
                        "Color",
                        "Notes"));

        List<PostDetailsDTO> expectedPostDetailsDTO = List.of(
                new PostDetailsDTO(
                        followedUserId,
                        1,
                        LocalDate.now(),
                        new ProductResponseDTO(
                                1,
                                "Name",
                                "Type",
                                "Brand",
                                "Color",
                                "Notes"),
                        1,
                        10.0

                ),
                new PostDetailsDTO(
                        followedUserId,
                        2,
                        LocalDate.now().minusDays(1),
                        new ProductResponseDTO(
                                2,
                                "Name",
                                "Type",
                                "Brand",
                                "Color",
                                "Notes"),
                        1,
                        10.0

                ));

        UserPostsResponseDTO expectedPostsResponseDTO = new UserPostsResponseDTO(expectedUser.getId(),
                expectedPostDetailsDTO);

        // ACT
        UserPostsResponseDTO actualPostsResponseDTO = postService.getPostsByFollowedUsers(expectedUser.getId(),
                order);

        // ASSERT
        assertEquals(expectedPostsResponseDTO, actualPostsResponseDTO);

    }

    @Test
    @DisplayName("UT-05: Verificar que si no existe orden, lanza una excepción")
    void givenOrder_whenOrderNotExists_thenThrowException() {
        // ARRANGE
        String order = "";
        Integer userId = 1;
        Integer followedUserId = 2;

        User expectedUser = new User(userId, "John Doe", Set.of(followedUserId), Set.of());
        when(userRepository.findById(expectedUser.getId())).thenReturn(expectedUser);

        List<Post> expectedPosts = List.of(
                new Post(1, followedUserId, LocalDate.now(), 1, 1, 10.0, false, 0.0),
                new Post(2, followedUserId, LocalDate.now().minusDays(1), 2, 1, 10.0, false, 0.0));
        when(postRepository.findAll()).thenReturn(expectedPosts);

        String messageExpected = "Parametro no valido, debe ingresar 'name_desc' o 'name_asc' para que sea valido";

        // ACT & ASSERT
        Exception exception = assertThrows(
                BadRequestException.class,
                () -> postService.getPostsByFollowedUsers(expectedUser.getId(), order));

        // ASSERT
        assertEquals(messageExpected, exception.getMessage());

    }

    @Test
    @DisplayName("UT-08: Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas.")
    public void givenSeller_whenQueryRecentPosts_thenReturnsPostsFromLastTwoWeeks() {
        // ARRANGE
        List<Post> posts = List.of(
                new Post(
                        1,
                        3,
                        Utils.generatedDateOfLastTwoWeeks(),
                        1,
                        1,
                        1200.00,
                        false,
                        0.00
                ),
                new Post(
                        2,
                        3,
                        Utils.generatedDateOfLastTwoWeeks(),
                        2,
                        2,
                        999.99,
                        true,
                        15.00
                ),
                new Post(
                        3,
                        3,
                        Utils.generatedDateOfLastTwoWeeks(),
                        3,
                        3,
                        350.00,
                        true,
                        20.00
                )
        );

        List<Product> products = List.of(
                new Product(
                        1,
                        "Laptop Dell XPS 13",
                        "Electronics",
                        "Dell",
                        "Silver",
                        "High performance, ultra-portable laptop."

                ),
                new Product(
                        2,
                        "Samsung Galaxy S21",
                        "Phone",
                        "Samsung",
                        "Phantom Black",
                        "Latest model with top-tier camera."
                ),
                new Product(
                        3,
                        "Sony WH-1000XM4",
                        "Headphones",
                        "Sony",
                        "Black",
                        "Noise-canceling, premium sound."
                )
        );

        Integer paramUserId = 1;
        User userMock = new User(1, "john_doe_test", new HashSet<>(Set.of(3)), new HashSet<>());
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        // ACT
        Mockito.when(userRepository.findById(paramUserId)).thenReturn(userMock);
        Mockito.when(postRepository.findAll()).thenReturn(posts);
        Mockito.when(productRepository.findById(posts.get(0).getProductId())).thenReturn(products.get(0));
        Mockito.when(productRepository.findById(posts.get(1).getProductId())).thenReturn(products.get(1));
        Mockito.when(productRepository.findById(posts.get(2).getProductId())).thenReturn(products.get(2));
        UserPostsResponseDTO responseObtained = postService.getPostsByFollowedUsers(paramUserId, null);

        // ASSERT
        assertAll("Verificar las fechas de las publicaciones",
                responseObtained.getPosts().stream().map(
                        post -> () -> {
                            assertFalse(post.getDate().isBefore(twoWeeksAgo), "La publicacion con el ID: " + post.getPostId() + " tiene una fecha anterior a hace dos semanas: " + post.getDate());
                        }
                )
        );
    }

    @Test
    @DisplayName("UT-06: Verificar el correcto ordenamiento ascendente por fecha")
    void givenUser_whenGetPostsByFollowedUsersAsc_thenReturnUserPostsResponseDTOSortedByDateAsc() {
        //Arrange
        int id = 1;
        int followedUserId = 2;
        String order = "date_asc";

        User expectedUser = new User(id, "John Doe", Set.of(followedUserId), Set.of());
        when(userRepository.findById(expectedUser.getId())).thenReturn(expectedUser);

        List<Post> expectedPosts = List.of(
                new Post(1, followedUserId, LocalDate.now(), 1, 1, 10.0, false, 0.0),
                new Post(2, followedUserId, LocalDate.now().minusDays(1), 2, 1, 10.0, false, 0.0)
        );
        when(postRepository.findAll()).thenReturn(expectedPosts);

        int productId1 = 1;
        int productId2 = 2;

        when(productRepository.findById(productId1)).thenReturn(
                new Product(1, "Product 1", "Type", "Brand", "Color", "Notes"));

        when(productRepository.findById(productId2)).thenReturn(
                new Product(2, "Product 2", "Type", "Brand", "Color", "Notes"));

        List<PostDetailsDTO> expectedPostDetailsDTO = List.of(
                new PostDetailsDTO(followedUserId, 1, LocalDate.now(),
                        new ProductResponseDTO(1, "Product 1", "Type", "Brand", "Color", "Notes"),
                        1, 10.0),
                new PostDetailsDTO(followedUserId, 2, LocalDate.now().minusDays(1),
                        new ProductResponseDTO(2, "Product 2", "Type", "Brand", "Color", "Notes"),
                        1, 10.0));

        UserPostsResponseDTO expectedPostsResponseDTO = new UserPostsResponseDTO(expectedUser.getId(), expectedPostDetailsDTO);

        //Act

        UserPostsResponseDTO result = postService.getPostsByFollowedUsers(id, order);

        //Assert

        assertNotNull(result);
        assertEquals(expectedPostsResponseDTO.getPosts().size(), result.getPosts().size());
        assertEquals("Product 2", result.getPosts().getFirst().getProduct().getProductName());


        verify(userRepository, times(1)).findById(anyInt());
        verify(postRepository, times(1)).findAll();
        verify(productRepository, times(expectedPosts.size())).findById(anyInt());
    }

    @Test
    @DisplayName("UT-06: Verificar el correcto ordenamiento descendente por fecha")
    void givenUser_whenGetPostsByFollowedUsersDesc_thenReturnUserPostsResponseDTOSortedByDateDesc() {
        //Arrange
        int id = 1;
        int followedUserId = 2;
        String order = "date_desc";

        User expectedUser = new User(id, "John Doe", Set.of(followedUserId), Set.of());
        when(userRepository.findById(expectedUser.getId())).thenReturn(expectedUser);

        List<Post> expectedPosts = List.of(
                new Post(1, followedUserId, LocalDate.now(), 1, 1, 10.0, false, 0.0),
                new Post(2, followedUserId, LocalDate.now().minusDays(1), 2, 1, 10.0, false, 0.0)
        );
        when(postRepository.findAll()).thenReturn(expectedPosts);

        int productId1 = 1;
        int productId2 = 2;

        when(productRepository.findById(productId1)).thenReturn(
                new Product(1, "Product 1", "Type", "Brand", "Color", "Notes"));

        when(productRepository.findById(productId2)).thenReturn(
                new Product(2, "Product 2", "Type", "Brand", "Color", "Notes"));

        List<PostDetailsDTO> expectedPostDetailsDTO = List.of(
                new PostDetailsDTO(followedUserId, 1, LocalDate.now(),
                        new ProductResponseDTO(1, "Product 1", "Type", "Brand", "Color", "Notes"),
                        1, 10.0),
                new PostDetailsDTO(followedUserId, 2, LocalDate.now().minusDays(1),
                        new ProductResponseDTO(2, "Product 2", "Type", "Brand", "Color", "Notes"),
                        1, 10.0));

        UserPostsResponseDTO expectedPostsResponseDTO = new UserPostsResponseDTO(expectedUser.getId(), expectedPostDetailsDTO);

        //Act

        UserPostsResponseDTO result = postService.getPostsByFollowedUsers(id, order);

        //Assert

        assertNotNull(result);
        assertEquals(expectedPostsResponseDTO.getPosts().size(), result.getPosts().size());
        assertEquals("Product 1", result.getPosts().getFirst().getProduct().getProductName());


        verify(userRepository, times(1)).findById(anyInt());
        verify(postRepository, times(1)).findAll();
        verify(productRepository, times(expectedPosts.size())).findById(anyInt());
    }

}
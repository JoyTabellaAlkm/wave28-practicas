package com.bootcamp.social_meli.unit.service;

import com.bootcamp.social_meli.dto.request.ProductDTO;
import com.bootcamp.social_meli.dto.response.MostProductsResponseDTO;
import com.bootcamp.social_meli.dto.response.PostNoDiscountResponseDTO;
import com.bootcamp.social_meli.dto.response.PostsFromFollowsResponseDTO;
import com.bootcamp.social_meli.dto.response.ProductWithPostCountDTO;
import com.bootcamp.social_meli.exception.BadRequestException;
import com.bootcamp.social_meli.exception.NotFoundException;
import com.bootcamp.social_meli.helpers.UserGenerator;
import com.bootcamp.social_meli.model.Post;
import com.bootcamp.social_meli.model.Product;
import com.bootcamp.social_meli.model.User;
import com.bootcamp.social_meli.repository.IPostRepository;
import com.bootcamp.social_meli.repository.IProductRepository;
import com.bootcamp.social_meli.repository.IUserRepository;
import com.bootcamp.social_meli.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    IPostRepository postRepository;
    @Mock
    IUserRepository userRepository;
    @Mock
    IProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    void getAllPostFollowsLastTwoWeeksUnordered() {
    }

    @Test
    @DisplayName("Verificar el correcto ordenamiento ascendente y descendente por fecha")
    void testGetPostsSortedByDate() {
        // ARR
        User user = new User(1L, "TestUser", "First", "Last", new ArrayList<>(), new ArrayList<>());
        User followedUser = new User(2L, "FollowedUser", "First", "Last", new ArrayList<>(), new ArrayList<>());
        user.getFollowed().add(followedUser);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ProductDTO productDto = new ProductDTO(1L, "ProductName", "ProductType", "ProductBrand", "ProductColor", "ProductNotes");
        Product mockProduct = new Product(1L, "ProductName", "ProductType", "ProductBrand", "ProductColor", "ProductNotes");

        Post post1 = new Post(1L, followedUser, LocalDate.parse("01-12-2024", formatter), mockProduct, null, null, false, null);
        Post post2 = new Post(2L, followedUser, LocalDate.parse("05-12-2024", formatter), mockProduct, null, null, false, null);
        Post post3 = new Post(3L, followedUser, LocalDate.parse("03-12-2024", formatter), mockProduct, null, null, false, null);

        PostNoDiscountResponseDTO postDto1 = new PostNoDiscountResponseDTO(1L, post1.getId(), post1.getCreateDate(), productDto, null, null);
        PostNoDiscountResponseDTO postDto2 = new PostNoDiscountResponseDTO(1L, post2.getId(), post2.getCreateDate(), productDto, null, null);
        PostNoDiscountResponseDTO postDto3 = new PostNoDiscountResponseDTO(1L, post3.getId(), post3.getCreateDate(), productDto, null, null);

        when(userRepository.findFollowsByUserId(1L)).thenReturn(Arrays.asList(followedUser));
        when(postRepository.findByUserIdFilteredByLastTwoWeeks(2L)).thenReturn(Arrays.asList(post1, post2, post3));

        // ACT
        PostsFromFollowsResponseDTO responseAsc = productService.getAllPostsFollowsLastTwoWeeks(1L, "date_asc");
        PostsFromFollowsResponseDTO responseDesc = productService.getAllPostsFollowsLastTwoWeeks(1L, "date_desc");

        // ASSERT ASCENDING
        List<LocalDate> datesAsc = responseAsc.getPosts().stream()
                .map(PostNoDiscountResponseDTO::getCreateDate)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(postDto1.getCreateDate(), postDto3.getCreateDate(), postDto2.getCreateDate()), datesAsc);

        // ASSERT DESCENDING
        List<LocalDate> datesDesc = responseDesc.getPosts().stream()
                .map(PostNoDiscountResponseDTO::getCreateDate)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(postDto2.getCreateDate(), postDto3.getCreateDate(), postDto1.getCreateDate()), datesDesc);
    }

    @Test
    @DisplayName("Verificar que las publicaciones sean de las últimas dos semanas")
    void testGetPostsFromLastTwoWeeks() {
        // ARR
        User user = new User(1L, "TestUser", "First", "Last", new ArrayList<>(), new ArrayList<>());
        User followedUser = new User(2L, "FollowedUser", "First", "Last", new ArrayList<>(), new ArrayList<>());
        user.getFollowed().add(followedUser);

        LocalDate now = LocalDate.now();
        LocalDate twoWeeksAgo = now.minusWeeks(2);

        Product mockProduct = new Product(1L, "ProductName", "ProductType", "ProductBrand", "ProductColor", "ProductNotes");

        Post recentPost1 = new Post(1L, followedUser, now.minusDays(3), mockProduct, null, null, false, null);
        Post recentPost2 = new Post(2L, followedUser, now.minusDays(10), mockProduct, null, null, false, null);

        when(postRepository.findByUserIdFilteredByLastTwoWeeks(2L))
                .thenReturn(Arrays.asList(recentPost1, recentPost2));

        when(userRepository.findFollowsByUserId(1L))
                .thenReturn(Arrays.asList(followedUser));

        // ACT
        PostsFromFollowsResponseDTO response = productService.getAllPostFollowsLastTwoWeeksUnordered(1L);

        // ASSERT
        assertEquals(2, response.getPosts().size());
        assertTrue(response.getPosts().stream().allMatch(post -> !post.getCreateDate().isBefore(twoWeeksAgo)));
    }
    @Test
    @DisplayName("Debe retornar los posts ordenados por fecha ascendente")
    void testGetAllPostsFollowsLastTwoWeeksValidOrder() {
        // Arrange
        Long userId = 1L;
        User user = UserGenerator.userWithFollowersAndFollowed(userId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Product mockProduct = new Product(1L, "ProductName", "ProductType", "ProductBrand", "ProductColor", "ProductNotes");

        Post post1 = new Post(1L, user.getFollowers().get(0), LocalDate.parse("01-12-2024",
                formatter), mockProduct, null, null, false, null);
        Post post2 = new Post(2L, user.getFollowers().get(0), LocalDate.parse("05-12-2024",
                formatter), mockProduct, null, null, false, null);
        Post post3 = new Post(3L, user.getFollowers().get(0), LocalDate.parse("03-12-2024",
                formatter), mockProduct, null, null, false, null);

        when(userRepository.findFollowsByUserId(1L)).thenReturn(user.getFollowers());
        when(postRepository.findByUserIdFilteredByLastTwoWeeks(2L)).thenReturn(Arrays.asList(post1, post2, post3));

        // Act
        PostsFromFollowsResponseDTO result = productService.getAllPostsFollowsLastTwoWeeks(1L, "date_asc");

        // Assert
        assertNotNull(result);
        assertEquals(post1.getCreateDate(), result.getPosts().get(0).getCreateDate());
        assertEquals(post3.getCreateDate(), result.getPosts().get(1).getCreateDate());
        assertEquals(post2.getCreateDate(), result.getPosts().get(2).getCreateDate());
    }


    @Test
    @DisplayName("Arroja BadRequest si el orden es invalido")
    public void testGetAllPostsFollowsLastTwoWeeksInvalidOrder(){
        // Arrange
        Long userId = 1L;
        String invalidOrder = "invalid_order";
        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            productService.getAllPostsFollowsLastTwoWeeks(userId, invalidOrder);
        });

        assertEquals("Orden no válido: debe ser 'date_asc' o 'date_desc'", exception.getMessage());

    }

    @Test
    @DisplayName("Obtiene lista de productos más vendidos usando el parámetro rank")
    public void getMostProductsTestWithRank(){
        // ARR
        String rankParam = "2";
        User user1 = new User(1L, "FrancoCol43", "Franco", "Colapinto", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2L, "MartinG23", "Martín", "Gómez", new ArrayList<>(), new ArrayList<>());

        Product product1 = new Product(1L, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        Product product2 = new Product(2L, "Teclado Mecánico", "Gamer", "HyperX", "Black", "RGB Backlight");

        // Convertir la fecha de String a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse("30-11-2024", formatter);
        LocalDate date2 = LocalDate.parse("12-12-2024", formatter);
        LocalDate date3 = LocalDate.parse("02-12-2024", formatter);

        // Crea instancias de Post
        Post post1 = new Post(1L, user1, date1, product1, 100, 1500.50, true, 0.25);
        Post post2 = new Post(2L, user1, date2, product2, 112, 120.00, false, 0.0);
        Post post3 = new Post(3L, user2, date3, product2, 102, 80.75, true, 0.15);

        when(postRepository.findAll()).thenReturn(Arrays.asList(post1, post2, post3));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product2));

        ProductWithPostCountDTO expectedProduct1 = new ProductWithPostCountDTO(1L, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition", 2);
        ProductWithPostCountDTO expectedProduct2 = new ProductWithPostCountDTO(2L, "Teclado Mecánico", "Gamer", "HyperX", "Black", "RGB Backlight", 1);
        MostProductsResponseDTO expectedResponse = new MostProductsResponseDTO(Arrays.asList(expectedProduct1, expectedProduct2));

        // ACT
        MostProductsResponseDTO actualResponse = productService.getMostProducts(rankParam);

        // ASSERT
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Obtiene lista de productos más vendidos sin usar parámetro rank")
    public void getMostProductsTest(){
        // ARR
        User user1 = new User(1L, "FrancoCol43", "Franco", "Colapinto", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2L, "MartinG23", "Martín", "Gómez", new ArrayList<>(), new ArrayList<>());

        Product product1 = new Product(1L, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        Product product2 = new Product(2L, "Teclado Mecánico", "Gamer", "HyperX", "Black", "RGB Backlight");

        // Convertir la fecha de String a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse("30-11-2024", formatter);
        LocalDate date2 = LocalDate.parse("12-12-2024", formatter);
        LocalDate date3 = LocalDate.parse("02-12-2024", formatter);

        // Crea instancias de Post
        Post post1 = new Post(1L, user1, date1, product1, 100, 1500.50, true, 0.25);
        Post post2 = new Post(2L, user1, date2, product2, 112, 120.00, false, 0.0);
        Post post3 = new Post(3L, user2, date3, product2, 102, 80.75, true, 0.15);

        when(postRepository.findAll()).thenReturn(Arrays.asList(post1, post2, post3));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product2));

        ProductWithPostCountDTO expectedProduct1 = new ProductWithPostCountDTO(1L, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition", 2);
        ProductWithPostCountDTO expectedProduct2 = new ProductWithPostCountDTO(2L, "Teclado Mecánico", "Gamer", "HyperX", "Black", "RGB Backlight", 1);
        MostProductsResponseDTO expectedResponse = new MostProductsResponseDTO(Arrays.asList(expectedProduct1, expectedProduct2));

        // ACT
        MostProductsResponseDTO actualResponse = productService.getMostProducts();

        // ASS
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Arroja BadRequest si rank no es un número")
    public void getMostProductsTestThrowsExceptionIfBadRequest() {
        // ARR
        String rankParam = "not_a_number";

        // ACT & ASSERT
        BadRequestException exception = Assertions.assertThrows(BadRequestException.class, () -> {
            productService.getMostProducts(rankParam);
        });

        assertEquals("El rank debe ser un valor numerico.", exception.getMessage());
    }

    @Test
    void testGetMostProducts() {
    }

    @Test
    void getAmountOfPromosByUser() {
    }
}
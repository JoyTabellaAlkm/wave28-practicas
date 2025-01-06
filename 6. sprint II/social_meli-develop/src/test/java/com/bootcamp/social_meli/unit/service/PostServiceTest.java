package com.bootcamp.social_meli.unit.service;

import com.bootcamp.social_meli.dto.response.MostPostsUsersResponseDTO;
import com.bootcamp.social_meli.exception.BadRequestException;
import com.bootcamp.social_meli.model.Post;
import com.bootcamp.social_meli.model.Product;
import com.bootcamp.social_meli.model.User;
import com.bootcamp.social_meli.repository.IPostRepository;
import com.bootcamp.social_meli.service.impl.PostServiceImpl;
import com.bootcamp.social_meli.dto.response.PostsWithProductResponseDTO;
import com.bootcamp.social_meli.repository.impl.PostRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    IPostRepository postRepository;

    @InjectMocks
    PostServiceImpl postService;

    @Test
    void createPost() {
    }

    @Test
    void createPromoPost() {
    }

    @Test
    void updatePromoPost() {
    }

    @Test
    @DisplayName("La cantidad de posts de un producto deberia ser cero si no hay posts con ese producto")
    void getPostsWithProductReturnsZero() {
        Integer expectedAmount = 0;
        String productName = "Taza";
        when(postRepository.getPostsWithProduct(Mockito.anyString())).thenReturn(List.of());

        PostsWithProductResponseDTO response = postService.getPostsWithProduct(productName);

        Assertions.assertEquals(expectedAmount, response.getPosts().size());
    }

    @Test
    @DisplayName("La cantidad de posts de un producto deberia ser dos si hay dos posts con ese producto")
    void getPostsWithProduct() {
        Integer expectedAmount = 2;
        String productName = "Taza";
        Post post1 = new Post();
        Post post2 = new Post();
        when(postRepository.getPostsWithProduct(Mockito.anyString())).thenReturn(List.of(post1, post2));

        PostsWithProductResponseDTO response = postService.getPostsWithProduct(productName);

        Assertions.assertEquals(expectedAmount, response.getPosts().size());
    }

    @Test
    @DisplayName("Los posts que contienen un producto, son del tipo de producto deseado")
    void getPostsWithProductReturnsTheProductDesired(){
        String productName = "Taza";
        Product product = new Product();
        product.setName("Taza");
        Post post = new Post();
        post.setProduct(product);
        when(postRepository.getPostsWithProduct(Mockito.anyString())).thenReturn(List.of(post));

        PostsWithProductResponseDTO response = postService.getPostsWithProduct(productName);
        Post postTaza = response.getPosts().get(0);

        Assertions.assertEquals(productName, response.getName());
        Assertions.assertTrue(postTaza.productNameContains(productName));
    }

    @Test
    @DisplayName("Debería devolver la lista de usuarios con más publicaciones")
    void mostPostsUsers() {
        // ARR
        Product product1 = new Product(1L, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        Product product2 = new Product(2L, "Teclado Mecánico", "Gamer", "HyperX", "Black", "RGB Backlight");

        // Convertir la fecha de String a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse("30-11-2024", formatter);
        LocalDate date2 = LocalDate.parse("12-12-2024", formatter);
        LocalDate date3 = LocalDate.parse("02-12-2024", formatter);

        User user1 = new User(1L, "Franco", "Colapinto", "Francol43", List.of(), List.of());
        User user2 = new User(2L, "Martín", "Gómez", "MartinG24", List.of(), List.of());

        Post post1 = new Post(1L, user1, date1, product1, 100, 1500.50, true, 0.25);
        Post post2 = new Post(2L, user1, date2, product2, 112, 120.00, false, 0.0);
        Post post3 = new Post(3L, user2, date3, product2, 102, 80.75, true, 0.15);

        when(postRepository.findAll()).thenReturn(Arrays.asList(post1, post2, post3));

        // ACT
        MostPostsUsersResponseDTO result = postService.mostPostsUsers();

        // ASERTS
        assertEquals(2, result.getMost_posts().size(), "La lista debe contener 2 usuarios.");
        assertEquals("Francol43", result.getMost_posts().get(0).getUser_name(), "El primer usuario debería ser Franco."); // Debe ser el que más publicaciones tiene
        assertEquals("MartinG24", result.getMost_posts().get(1).getUser_name(), "El segundo usuario debería ser Martín."); // El siguiente
    }

    @Test
    @DisplayName("Debería devolver la lista de usuarios con más publicaciones usando Rank Param")
    void mostPostsUsersWithRank() {
        // ARR
        Integer rankParam = 3;
        Product product1 = new Product(1L, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        Product product2 = new Product(2L, "Teclado Mecánico", "Gamer", "HyperX", "Black", "RGB Backlight");

        // Convertir la fecha de String a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse("30-11-2024", formatter);
        LocalDate date2 = LocalDate.parse("12-12-2024", formatter);
        LocalDate date3 = LocalDate.parse("02-12-2024", formatter);
        LocalDate date4 = LocalDate.parse("03-12-2024", formatter);

        User user1 = new User(1L, "Franco", "Colapinto", "Francol43", List.of(), List.of());
        User user2 = new User(2L, "Martín", "Gómez", "MartinG24", List.of(), List.of());
        User user3 = new User(3L, "Ana", "Pérez", "AnaPerezzzz", List.of(), List.of());

        Post post1 = new Post(1L, user1, date1, product1, 100, 1500.50, true, 0.25);
        Post post2 = new Post(2L, user1, date2, product2, 112, 120.00, false, 0.0);
        Post post3 = new Post(3L, user2, date3, product2, 102, 80.75, true, 0.15);
        Post post4 = new Post(4L, user3, date4, product2, 102, 80.75, true, 0.15);

        when(postRepository.findAll()).thenReturn(Arrays.asList(post1, post2, post3, post4));

        // ACT
        MostPostsUsersResponseDTO result = postService.mostPostsUsers(rankParam);

        assertEquals(3, result.getMost_posts().size(), "La lista debe contener 3 usuarios.");
        assertEquals("Francol43", result.getMost_posts().get(0).getUser_name(), "El primer usuario debería ser Franco."); // Debe tener más publicaciones
        assertEquals("MartinG24", result.getMost_posts().get(1).getUser_name(), "El segundo usuario debería ser Martín."); // Siguiente
        assertEquals("AnaPerezzzz", result.getMost_posts().get(2).getUser_name(), "El tercer usuario debería ser Ana."); // Tercero
    }

    @Test
    @DisplayName("Debería arrojar una excepción de BadRequest")
    void testMostPostsUsersWithRankZeroOrNegative() {
        // ARR
        Integer rankParam = -1;

        // ACT & ASSERT
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            postService.mostPostsUsers(rankParam); // Lanzar la excepción si rank es 0
        });
        assertEquals("'rank' no puede ser <= 0", exception.getMessage());
    }

    @Test
    @DisplayName("Debería devolver una lista vacía si no hay publicaciones")
    public void testMostPostsUsersWithNoPosts() {
        // ARR
        when(postRepository.findAll()).thenReturn(new ArrayList<>()); // Sin publicaciones en la base de datos

        // ACT
        MostPostsUsersResponseDTO result = postService.mostPostsUsers(2); // Pasar cualquier rank

        // ASS
        assertTrue(result.getMost_posts().isEmpty(), "La lista de usuarios debería estar vacía.");
    }

    @Test
    @DisplayName("Debería devolver todos los usuarios si menos que el rank")
    public void testMostPostsUsersWithLessUsersThanRank() {
        // ARR
        Integer rankParam = 2;

        Product product1 = new Product(1L, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        Product product2 = new Product(2L, "Teclado Mecánico", "Gamer", "HyperX", "Black", "RGB Backlight");

        // Convertir la fecha de String a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse("30-11-2024", formatter);
        LocalDate date2 = LocalDate.parse("12-12-2024", formatter);
        LocalDate date3 = LocalDate.parse("13-12-2024", formatter);

        User user1 = new User(1L, "Francol43", "Franco", "Colapinto", List.of(), List.of());
        User user2 = new User(2L, "Cron", "Franchesco", "Cronos", List.of(), List.of());

        Post post1 = new Post(1L, user1, date1, product1, 100, 1500.50, true, 0.25);
        Post post2 = new Post(2L, user1, date2, product2, 112, 120.00, false, 0.0);
        Post post3 = new Post(3L, user2, date3, product2, 112, 125.00, false, 0.0);

        when(postRepository.findAll()).thenReturn(Arrays.asList(post1, post2, post3));

        // ACT
        MostPostsUsersResponseDTO result = postService.mostPostsUsers(rankParam);

        // ASS
        assertEquals(2, result.getMost_posts().size(), "La lista debe contener todos los usuarios.");
    }

    @Test
    void testMostPostsUsers() {
    }

    @Test
    void getPostsByPriceRange() {
    }
}
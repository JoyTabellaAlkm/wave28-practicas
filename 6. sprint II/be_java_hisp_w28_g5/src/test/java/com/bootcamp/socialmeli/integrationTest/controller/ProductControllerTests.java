package com.bootcamp.socialmeli.integrationTest.controller;

import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.dto.request.PostPromoRequestDto;
import com.bootcamp.socialmeli.dto.request.ProductCreationDto;
import com.bootcamp.socialmeli.dto.request.UserCreationReqDto;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.repository.UserRepository;
import com.bootcamp.socialmeli.service.ProductService;
import com.bootcamp.socialmeli.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductService productService;

    @BeforeEach
    void initData() {
        userService.createUsers(List.of(
                new UserCreationReqDto("Tomas"),
                new UserCreationReqDto("Sara"),
                new UserCreationReqDto("Pepe")
        ));
        userService.followUser(1L, 2L);
        userService.followUser(1L, 3L);

        Product product1 = new Product(1L, "Product A", "Type 1", "Brand A", "Red", "Notes A");
        Product product2 = new Product(2L, "Product B", "Type 2", "Brand B", "Blue", "Notes B");
        Product product3 = new Product(3L, "Product C", "Type 3", "Brand C", "Cyan", "Notes C");

        Post post1 = new Post(1L, LocalDate.now().minusDays(1), product1, 1, 100.0, false, 0.0);
        Post post2 = new Post(2L, LocalDate.now().minusDays(5), product2, 1, 150.0, false, 0.0);
        Post post3 = new Post(3L, LocalDate.now().minusDays(21), product3, 1, 150.0, false, 0.0);


        userRepository.findById(2L).get().setPosts(List.of(post1));
        userRepository.findById(3L).get().setPosts(List.of(post2,post3));
    }

    @Test
    void createProductForExistingUser() throws Exception {
        ProductCreationDto productDto =
                new ProductCreationDto(10L, "Silla", "Mueble", "Maderas MyM", "Neutro", null);
        PostCreationDto postDto =
                new PostCreationDto(1L, "29-04-2021", productDto, 1, 2500.2);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.post_id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product.product_id").value(Matchers.is(10)));
    }

    @Test
    void createProductForNonExistingUser() throws Exception {
        ProductCreationDto productDto =
                new ProductCreationDto(10L, "Silla", "Mueble", "Maderas MyM", "Neutro", null);
        PostCreationDto postDto =
                new PostCreationDto(100L, "29-04-2021", productDto, 1, 2500.2);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDto)))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(Matchers.is(404)));
    }

    @Test
    void testGetFollowedProductsOrderByAsc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                        .param("order", "date_asc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.product_name", Matchers.is("Product B")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].product.product_name", Matchers.is("Product A")));
    }

    @Test
    void testGetFollowedProductsOrderByDesc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                        .param("order", "date_desc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.product_name", Matchers.is("Product A")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].product.product_name", Matchers.is("Product B")));;
    }
  
    @Test
    void testGetFollowedProducts() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.product_name", Matchers.is("Product A")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].product.product_name", Matchers.is("Product B")));
    }

    @Test
    void testGetFollowedProductsOrderExistASC() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                .param("order", "date_asc"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetFollowedProductsOrderExistDESC() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                .param("order", "date_desc"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetFollowedProductsOrderNotExist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                .param("order", "not_exist"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void createProductOnPromotionForExistingUser() throws Exception {
        ProductCreationDto productDto =
                new ProductCreationDto(10L, "Silla", "Mueble", "Maderas MyM", "Neutro", null);
        PostPromoRequestDto postDto =
                new PostPromoRequestDto(1L, "29-04-2021", productDto, 1, 2500.2,true,0.20);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.post_id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product.product_id").value(Matchers.is(10)));
    }

    @Test
    void createProductOnPromotionForNonExistingUser() throws Exception {
        ProductCreationDto productDto =
                new ProductCreationDto(10L, "Silla", "Mueble", "Maderas MyM", "Neutro", null);
        PostPromoRequestDto postDto =
                new PostPromoRequestDto(100L, "29-04-2021", productDto, 1, 2500.2,true,0.20);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDto)))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(Matchers.is(404)));
    }

    @Test
    void testGetProductsOnPromotionByUser() throws Exception{
        ProductCreationDto productDto1 =
                new ProductCreationDto(10L, "Silla", "Mueble", "Maderas MyM", "Neutro", null);
        PostPromoRequestDto postOnPromotion1 =
                new PostPromoRequestDto(1L, "29-04-2021", productDto1, 1, 2500.2,true,0.20);
        ProductCreationDto productDto2 =
                new ProductCreationDto(11L, "Silla", "Mueble", "Maderas MyM", "Neutro", null);
        PostPromoRequestDto postOnPromotion2 =
                new PostPromoRequestDto(1L, "29-04-2021", productDto2, 1, 2500.2,true,0.20);

        productService.createPostWithDiscount(postOnPromotion1);
        productService.createPostWithDiscount(postOnPromotion2);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count").param("user_id","1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.promo_products_count", Matchers.is(2)));
    }

    @Test
    void testGetProductsOnPromotionByNonExistentUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                        .param("user_id","100"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(Matchers.is(404)));
    }
}

package com.mercadolibre.social.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.social.dto.request.PostPromotionRequestDto;
import com.mercadolibre.social.dto.request.PostRequestDto;
import com.mercadolibre.social.dto.request.ProductDto;
import com.mercadolibre.social.dto.response.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @Order(1)
    @DisplayName("IT-08 -> US-10 Llevar a cabo la publicación de un nuevo producto en promoción")
    public void givenPostPromotionRequestDto_whenPostPromotion_thenSuccess() throws Exception {
        // ARRANGE
        LocalDate currentDate = LocalDate.now();

        MessageDto messageDto = new MessageDto("The post with promotion with id 100 has been successfully created");
        ProductDto productDto = new ProductDto(100, "productName", "type", "brand", "color", "notes");

        PostPromotionRequestDto postPromotionRequestDto = new PostPromotionRequestDto(
                1,
                currentDate,
                productDto,
                1,
                10.00,
                true,
                0.5
        );


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(messageDto));
        // ACT & ASSERT
        mockMvc.perform(post("/products/promo-post")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(postPromotionRequestDto)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("IT-07 -> US-11: Obtener la cantidad de productos en promoción de un determinado vendedor")
    public void givenSellerWithPromotionalProducts_whenGetPromotionProductCount_thenReturnCorrectCount() throws Exception {
        //ARRANGE

        ProductCountPromoPostDto response = new ProductCountPromoPostDto(2, "alice_smith_test", 4);
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(response));
        //ACT AND ASSERT
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", "2"))
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        expectedBody
                ).andDo(print());
    }

    @Test
    @Order(2)
    @DisplayName("IT-06 -> US-05 Dar de alta una nueva publicación")
    public void givenPostRequestDto_whenPost_thenSuccess() throws Exception {
        // ARRANGE
        LocalDate currentDate = LocalDate.now();

        MessageDto messageDto = new MessageDto("The post with id 101 has been created correctly");
        ProductDto productDto = new ProductDto(100, "productName", "type", "brand", "color", "notes");

        PostRequestDto postRequestDto = new PostRequestDto(
                1,
                currentDate,
                productDto,
                1,
                10.00
        );


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(messageDto));
        // ACT & ASSERT
        mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(postRequestDto)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @Order(3)
    @DisplayName("IT-09 -> US-06: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas")
    void givenUserId_whenGetPostsByFollowedUsers_thenReturnCorrectPostDetailsDTO() throws Exception {
        // ARRANGE
        objectMapper.registerModule(new JavaTimeModule());

        int userId = 1;
        LocalDate date1 = LocalDate.parse("30-12-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        ProductResponseDTO productResponseDTO1 = new ProductResponseDTO(3, "Sony WH-1000XM4", "Headphones", "Sony", "Black", "Noise-canceling, premium sound.");
        PostDetailsDTO postDetailsDTO1 = new PostDetailsDTO(3, 3, date1, productResponseDTO1, 3, 350.00);

        LocalDate date2 = LocalDate.parse("29-12-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        ProductResponseDTO productResponseDTO2 = new ProductResponseDTO(6, "Bose QuietComfort 35 II", "Headphones", "Bose", "Silver", "Premium noise-canceling headphones.");
        PostDetailsDTO postDetailsDTO2 = new PostDetailsDTO(3, 6, date2, productResponseDTO2, 3, 350.00);

        List<PostDetailsDTO> posts = new ArrayList<>(Arrays.asList(
                postDetailsDTO1, postDetailsDTO2)
        );

        UserPostsResponseDTO userPostsResponseDTO = new UserPostsResponseDTO(userId, posts);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(userPostsResponseDTO));

        // ACT & ASSERT
        mockMvc.perform(get("/products/followed/{userId}/list", userId))
                .andExpectAll(expectedStatus, expectedContentType, expectedBody)
                .andDo(print());

    }

}

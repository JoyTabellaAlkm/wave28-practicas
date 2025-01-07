package com.api.social_meli.integration.controller;

import com.api.social_meli.dto.ExceptionDto;
import com.api.social_meli.dto.FollowedSellerPostsDto;
import com.api.social_meli.dto.PostDto;
import com.api.social_meli.model.Post;
import com.api.social_meli.repository.IPostRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IPostRepository postRepository;

    static ObjectMapper objectMapper;

    @BeforeAll
    public static void setUp() {
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }

    //region GET FOLLOWED SELLERS POSTS

    //region WITHOUT ORDER
    @Test
    @DisplayName("Obtener posts de vendedores seguidos (sin orden), caso OK lista con posts.")
    @DirtiesContext
    void shouldReturnOkWithContentFollowedSellersPosts() throws Exception {
        // Arrange
        int userId = 1;

        Post post2 = postRepository.findById(2);  // Encuentra el post con ID 2
        Post post4 = postRepository.findById(4);  // Encuentra el post con ID 4
        post2.setPublishDate(LocalDate.now().minusWeeks(1));
        post4.setPublishDate(LocalDate.now().minusWeeks(1));

        List<PostDto> postDtoList = objectMapper.convertValue(List.of(post2, post4),
                new TypeReference<List<PostDto>>() {});

        FollowedSellerPostsDto expectedResult = new FollowedSellerPostsDto(userId, postDtoList);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(objectMapper.writeValueAsString(expectedResult));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedContentType,expectedJson,expectedStatus)
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener posts de vendedores seguidos (sin orden), caso OK lista de posts vacía.")
    @DirtiesContext
    void shouldReturnOkWithEmptyListOfFollowedSellersPosts() throws Exception {
        // Arrange
        int userId = 1;

        postRepository.findAll().forEach(
                post -> post.setPublishDate(LocalDate.now().minusWeeks(3))
        );

        FollowedSellerPostsDto expectedResult = new FollowedSellerPostsDto(userId, List.of());

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(objectMapper.writeValueAsString(expectedResult));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",  userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedContentType,expectedJson,expectedStatus)
                .andDo(print());
    }
    //endregion

    //region EXCEPTIONS
    @Test
    @DisplayName("Obtener posts de vendedores seguidos con userId no existente, caso Not Found.")
    void shouldThrowExNonExistentUserWhenGetFollowedSellersPosts() throws Exception {
        // Arrange
        int userId = 99999;

        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedJson = content().json(objectMapper.writeValueAsString(new ExceptionDto("No se encontró ningún usuario con ese ID.")));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        // Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",  userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedContentType,expectedJson,expectedStatus)
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener posts de vendedores seguidos con orden inválido, caso Bad Request.")
    void shouldThrowExNotValidOrderWhenGetFollowedSellersPosts() throws Exception {
        // Arrange
        int userId = 1;
        String order = "not valid order";

        ResultMatcher expectedStatus = status().isBadRequest();
        ResultMatcher expectedJson = content().json(objectMapper.writeValueAsString(new ExceptionDto("Tipo de order no válido, ingrese date_asc o date_desc")));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        // Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedContentType, expectedJson, expectedStatus)
                .andDo(print());
    }
    //endregion

    //endregion
}

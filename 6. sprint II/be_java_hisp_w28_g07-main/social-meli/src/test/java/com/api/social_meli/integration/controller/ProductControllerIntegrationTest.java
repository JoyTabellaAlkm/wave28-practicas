package com.api.social_meli.integration.controller;

import com.api.social_meli.dto.ExceptionDto;
import com.api.social_meli.dto.FollowedSellerPostsDto;
import com.api.social_meli.repository.IPostRepository;
import com.api.social_meli.util.MockFactoryUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;
import java.util.List;

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
    @DisplayName("T-0008 - Obtener posts de vendedores seguidos (sin orden), caso OK lista con posts.")
    @DirtiesContext
    void shouldReturnOkWithContentFollowedSellersPosts() throws Exception {
        // Arrange
        int userId = 1;

        postRepository.findById(2).setPublishDate(LocalDate.now().minusWeeks(1));
        postRepository.findById(4).setPublishDate(LocalDate.now().minusDays(10));

        FollowedSellerPostsDto resultExpected = MockFactoryUtils.getFollowedSellersPostsDtoSortedAsc();

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher jsonExpected = content().json(objectMapper.writeValueAsString(resultExpected));
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(contentTypeExpected,jsonExpected,statusExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("T-0008 - Obtener posts de vendedores seguidos (sin orden), caso OK lista de posts vacía.")
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

    //region WITH ORDER

    @Test
    @DisplayName("T-0006 - Posteos de vendedores seguidos ordenados de forma ascendente. Ok.")
    @DirtiesContext
    public void shouldReturnFollowedSellersPostsAscSortedOk() throws Exception {
        // Arrange
        Integer userId = 1;
        String order = "date_asc";

        postRepository.findById(2).setPublishDate(LocalDate.now().minusWeeks(1));
        postRepository.findById(4).setPublishDate(LocalDate.now().minusDays(10));

        FollowedSellerPostsDto dtoExpected = MockFactoryUtils.getFollowedSellersPostsDtoSortedAsc();

        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(dtoExpected));
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andExpectAll(statusExpected, contentTypeExpected, bodyExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("T-0006 - Posteos de vendedores seguidos ordenados de forma descendente. Ok.")
    @DirtiesContext
    public void shouldReturnFollowedSellersPostsDescSortedOk() throws Exception {
        // Arrange
        Integer userId = 1;
        String order = "date_desc";

        postRepository.findById(2).setPublishDate(LocalDate.now().minusWeeks(1));
        postRepository.findById(4).setPublishDate(LocalDate.now().minusDays(10));

        FollowedSellerPostsDto expectedDto = MockFactoryUtils.getFollowedSellersPostsDtoSortedDesc();

        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(expectedDto));
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andExpectAll(statusExpected, contentTypeExpected, bodyExpected)
                .andDo(print());
    }

    //endregion

    //region EXCEPTIONS

    @Test
    @DisplayName("T-0008 - Obtener posts de vendedores seguidos con userId no existente. Not Found.")
    void shouldReturnNotFoundNonExistentUserWhenGetFollowedSellersPosts() throws Exception {
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
    @DisplayName("T-0006 - Obtener posts de vendedores seguidos con orden inválido. Bad Request.")
    void shouldReturnBadRequestNotValidOrderWhenGetFollowedSellersPosts() throws Exception {
        // Arrange
        Integer userId = 1;
        String order = "invalid";

        ExceptionDto responseExpected = new ExceptionDto("Tipo de order no válido, ingrese date_asc o date_desc");

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(responseExpected));

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andExpectAll(statusExpected, bodyExpected)
                .andDo(print());
    }

    //endregion

    //endregion
}

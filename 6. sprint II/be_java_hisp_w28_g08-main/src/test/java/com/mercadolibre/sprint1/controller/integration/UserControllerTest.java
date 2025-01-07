package com.mercadolibre.sprint1.controller.integration;

import static com.mercadolibre.sprint1.utils.CResourceUtils.MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.sprint1.dto.exception.ExceptionDto;
import com.mercadolibre.sprint1.dto.response.UserPromosAverageDto;
import com.mercadolibre.sprint1.entity.Post;
import com.mercadolibre.sprint1.repository.IRepository;

import util.TestUtilGenerator;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    private IRepository<Post> postRepository;

    ObjectMapper om = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Test
    @DisplayName("T-0016 - Cuándo se envía un id de usuario y un id de un vendedor a seguir, se debe seguir al vendedor")
    public void whenSentFollowerUserIdAndFollowedUserIdShouldFollowSeller() throws Exception {
        // arrange
        int userId = 2;
        int userIdToFollow = 3;
        ResultMatcher statusEsperado = status().isOk();

        // act & assert
        mockMvc.perform(post("/users/" + userId + "/follow/" + userIdToFollow))
                .andExpect(statusEsperado)
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("T-0016 - Cuándo se envía un id de usuario y un id de un vendedor que no existe, debe lanzar una excepción 404")
    public void whenSentFollowerUserIdAndFollowedUserIdAndIsNotExistsShouldThrows404() throws Exception {
        // arrange
        int userId = 2;
        int userIdToFollow = 100;
        ResultMatcher statusEsperado = status().isNotFound();

        // act & assert
        MvcResult result = mockMvc.perform(post("/users/" + userId + "/follow/" + userIdToFollow))
                .andExpect(statusEsperado)
                .andDo(print())
                .andReturn();

        ExceptionDto exception = MAPPER.readValue(result.getResponse().getContentAsString(), ExceptionDto.class);
        assertEquals("No existe el usuario " + userIdToFollow, exception.getMessage());
    }

    @Test
    @DisplayName("T-0016 - Cuándo se envía un id de usuario y un id de un usuario que no es vendedor, debe lanzar una excepción 400")
    public void whenSentFollowerUserIdAndFollowedUserIdAndIsNotSellerShouldThrows400() throws Exception {
        // arrange
        int userId = 3;
        int userIdToFollow = 2;
        ResultMatcher statusEsperado = status().isBadRequest();

        // act & assert
        MvcResult result = mockMvc.perform(post("/users/" + userId + "/follow/" + userIdToFollow))
                .andExpect(statusEsperado)
                .andDo(print())
                .andReturn();

        ExceptionDto exception = MAPPER.readValue(result.getResponse().getContentAsString(), ExceptionDto.class);
        assertEquals("El usuario " + userIdToFollow + " no es un vendedor.", exception.getMessage());
    }

    @Test
    @DisplayName("T-0017 - Cuándo se envía un id existente se debe retornar el conteo de seguidores")
    public void whenUserExistShouldReturnCount() throws Exception {

        // Arrange
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        long idUser = 1;

        // Act & assert
        mockMvc.perform(get("/users/" + idUser + "/followers/count")).andExpect(expectedStatus)
                .andExpect(expectedContentType).andExpect(jsonPath("$.user_id").value(idUser))
                .andExpect(jsonPath("$.user_name").value("John Doe")).andExpect(jsonPath("$.followers_count").value(2))
                .andDo(print());
    }

    @Test
    @DisplayName("T-0017 - Cuándo se envía un id inexistente se debe retornar un error")
    public void whenUserNotExistShouldReturnException() throws Exception {

        // Arrange
        ResultMatcher expectedStatus = status().isBadRequest();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        long idUser = -1;

        // Act & assert
        mockMvc.perform(get("/users/" + idUser + "/followers/count")).andExpect(expectedStatus)
                .andExpect(expectedContentType).andExpect(jsonPath("$.message").value("Ha ocurrido un error"))
                .andDo(print());
    }

    @Test
    @DisplayName("T-0019 - Consultar el promedio de promociones de los vendedores, debe devolver una lista.")
    public void whenGetUserAveragePromosShouldReturnAverage() throws Exception {
        // Arrange
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        List<UserPromosAverageDto> expected = List.of(
                new UserPromosAverageDto(2, "Jane Smith", 85.0, null),
                new UserPromosAverageDto(4, "Bob Brown", 5.0, null));

        when(postRepository.findAll()).thenReturn(TestUtilGenerator.generatePosts());
        // Act & Assert
        MvcResult result = mockMvc.perform(get("/users/average-promos"))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType).andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        List<UserPromosAverageDto> actual = om.readValue(jsonResponse, new TypeReference<>() {
        });

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T-0019 - Consultar el promedio de promociones de los vendedores, debe devolver sin contenido porque no hay post")
    public void whenGetUserAveragePromosIsEmptyShouldReturnError() throws Exception {
        // Arrange
        ResultMatcher expectedStatus = status().isNoContent();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        when(postRepository.findAll()).thenReturn(new ArrayList<>());

        // Act & Assert
        mockMvc.perform(get("/users/average-promos"))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType).andReturn();
    }

}
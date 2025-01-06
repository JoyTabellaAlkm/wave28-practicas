package com.api.social_meli.integration.controller;

import com.api.social_meli.dto.*;
import com.api.social_meli.util.MockFactoryUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.api.social_meli.dto.ProductDto;
import com.api.social_meli.dto.PromoPostDto;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;


@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    static ObjectMapper objectMapper;

    @BeforeAll
    public static void setUp() {
        objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
    }

    //region CREATE PROMO POST

    @Test
    @DisplayName("Bonus - Crear Promo Post. Ok.")
    public void createPromoPostOK() throws Exception{

        // Arrange
        PromoPostDto toRegister = new PromoPostDto(
                1,
                2,
                LocalDate.parse("29-04-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new ProductDto(
                        1,
                        "Silla Gamer",
                        "Gamer",
                        "Racer",
                        "RedBlack",
                        "Special Edition"
                ),
                2,
                1500.50,
                true,
                0.25
        );

        String payloadJson = objectMapper.writeValueAsString(toRegister);

        String expectedMessage = "Post con promo realizado con exito";

        // Act
        mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
        // Assert
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    @Test
    @DisplayName("Bonus - Crea un promo post. BadRequest. Datos inválidos.")
    public void createPromoPostStressTest() throws Exception{

        // Arrange
        PromoPostDto toRegister = new PromoPostDto(
                1,
                -1,
                null,
                new ProductDto(
                        null,
                        "Silla Gamer!·$!%%%!%%%!%!%%!%!%!%!%!!%!!%%!%!%%!",
                        "Gamer AAAAAAAAA())()AAAAA((((·····(((",
                        "Racer OOOOOOOOOOC!))!((()))=)==)))",
                        "Red AND Black UUUUUUUUUUUU!U!!·UU!·U·!U·!U·U!U!·U·U·",
                        "Special Edition )))))))))))))))!!!!!!!!!!???????????)))==)))AAAAAAAAAAAOOOOOOOOOAAA"
                ),
                -1,
                1111111111111.1,
                true,
                0.25
        );

        String payloadJson = objectMapper.writeValueAsString(toRegister);

        // Act
        mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
        // Assert
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value(containsString("El 'user_id' debe ser mayor a cero")))
                .andExpect(jsonPath("$.description").value(containsString("La fecha en 'date' no puede estar vacía")))
                .andExpect(jsonPath("$.description").value(containsString("El 'product_id' no puede estar vacio")))
                .andExpect(jsonPath("$.description").value(containsString("El campo 'product_name' no puede poseer caracteres especiales")))
                .andExpect(jsonPath("$.description").value(containsString("El campo 'type' no puede poseer caracteres especiales")))
                .andExpect(jsonPath("$.description").value(containsString("La longitud del campo 'type' no puede superar los 15 caracteres")))
                .andExpect(jsonPath("$.description").value(containsString("El campo 'brand' no puede poseer caracteres especiales")))
                .andExpect(jsonPath("$.description").value(containsString("La longitud del campo 'brand' no puede superar los 25 caracteres")))
                .andExpect(jsonPath("$.description").value(containsString("El campo 'color' no puede poseer caracteres especiales")))
                .andExpect(jsonPath("$.description").value(containsString("La longitud del campo 'color' no puede superar los 15 caracteres")))
                .andExpect(jsonPath("$.description").value(containsString("El campo 'notes' no puede poseer caracteres especiales")))
                .andExpect(jsonPath("$.description").value(containsString("La longitud del campo 'notes' no puede superar los 80 caracteres")))
                .andExpect(jsonPath("$.description").value(containsString("El campo 'category' debe ser mayor que cero")))
                .andExpect(jsonPath("$.description").value(containsString("El precio maximo por producto es de 10.000.000")));
    }

    //endregion

    //region CREATE POST

    @Test
    @DisplayName("Bonus - Crea un Post. Ok.")
    public void createPostTestOk() throws Exception {
        // Arrange
        PostDto expectedDto = MockFactoryUtils.createPostResponseDto();
        String jsonRequest = objectMapper.writer().writeValueAsString(expectedDto);

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("Post realizado con exito")));

        // Act & Assert
        mockMvc.perform(post("/products/post").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );
    }

    @Test
    @DisplayName("Bonus - Crea un Post. BadRequest.")
    public void createPostTestBadRequest() throws Exception {
        // Arrange
        PostDto expectedDto = MockFactoryUtils.createPostResponseDto();
        expectedDto.setPostId(1);
        String jsonRequest = objectMapper.writer().writeValueAsString(expectedDto);

        ResultMatcher statusExpected= status().isBadRequest();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("El post ya existe")));

        // Act & Assert
        mockMvc.perform(post("/products/post").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );
    }

    //endregion

    //region GET BY CATEGORY ID

    @Test
    @DisplayName("Bonus - Obtener Posts de una categoría por rango de precios.")
    public void getPostByCategoryIdTestOk() throws Exception {
        // Arrange
        int categoryId = 3;
        int priceMin= 100;
        int priceMax= 200;

        GetByCategoryResponseDto expectedDto = MockFactoryUtils.getPostByCategoryResponseDto();

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(expectedDto));

        // Act & Assert
        mockMvc.perform(get("/posts/{categoryId}/category/list/{price_min}/{price_max}", categoryId, priceMin, priceMax)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        statusExpected,
                        contentTypeExpected,
                        bodyExpected
                );
    }


    @Test
    @DisplayName("Bonus - Traer Posts por categoría. NotFound.")
    public void getPostByCategoryIdTestNotFound() throws Exception {
        // Arrange
        int categoryId = 1;
        int priceMin= 100;
        int priceMax= 200;

        ResultMatcher statusExpected= status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("No se encontraron post con ese id o rango de precio")));

        // Act & Assert
        mockMvc.perform(get("/posts/{categoryId}/category/list/{price_min}/{price_max}", categoryId, priceMin, priceMax)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        statusExpected,
                        contentTypeExpected,
                        bodyExpected
                );
    }

    //endregion

    //region PROMO PRODUCT COUNT

    @Test
    @DisplayName("Bonus - Trae la cantidad de productos en promoción de un usuario.")
    public void getPromoProductCountTestOk() throws Exception {
        // Arrange
        int userId = 3;
        PromoPostCountDto expectedDto = new PromoPostCountDto(3,"María López",2);

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(expectedDto));

        // Act & Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(userId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        statusExpected,
                        contentTypeExpected,
                        bodyExpected
                );
    }

    @Test
    @DisplayName("Bonus - Obtener la cantidad de productos en promoción de un usuario. NotFound.")
    public void getPromoProductCountTestNotFoundException() throws Exception {
        // Arrange
        int userId = 4;

        ResultMatcher statusExpected= status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("El usuario no tiene publicaciones con productos promocionados")));

        // Act & Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(userId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        statusExpected,
                        contentTypeExpected,
                        bodyExpected
                );
    }

    //endregion
}

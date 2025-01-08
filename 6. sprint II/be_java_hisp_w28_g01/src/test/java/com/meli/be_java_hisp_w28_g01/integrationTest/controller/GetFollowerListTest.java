package com.meli.be_java_hisp_w28_g01.integrationTest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Tests de integración para obtener lista de seguidores de un seller")
class GetFollowerListTest {
    @Autowired
    MockMvc mockMvc;

    @ParameterizedTest
    @ValueSource(strings = {"name_asc","name_desc"})
    @DisplayName("Acepta 'name_asc' y 'name_desc' como parámetros válidos de ordenamiento")
    void whenOrderByNameAscOrDesc_ValidatesOrderTypeSuccessfully(String order) throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/list",5)
                .param("order",order))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("Obtengo excepcion al ingresar un tipo de ordenamiento inexistente")
    void whenOrderByInvalidType_ThrowsIllegalArgumentException() throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/list",5)
                        .param("order","invalid_order"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener la lista de seguidores sin orden especificado")
    void getFollowersList() throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/list",5))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("Lanzar excepcion cuando el id especificado no existe")
    void whenIdInvalid_ThrowsException() throws Exception {
        int userId = 999;

        mockMvc.perform(get("/users/{userId}/followers/list",userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El 'Vendedor' con el id '999' no existe."));
    }
}

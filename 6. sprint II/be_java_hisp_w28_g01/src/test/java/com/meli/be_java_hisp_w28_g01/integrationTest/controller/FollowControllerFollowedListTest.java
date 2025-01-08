package com.meli.be_java_hisp_w28_g01.integrationTest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Test de integracion para lista de seguidos")
public class FollowControllerFollowedListTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @ValueSource(strings = {"name_asc","name_desc"})
    @DisplayName("Obtener la lista de seguidos con orden especificado")
    void whenOrderByNameAscOrDesc_ValidatesOrderTypeSuccessfully(String order) throws Exception{
        mockMvc.perform(get("/users/{userId}/followed/list",5)
                        .param("order",order))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener la lista de seguidos sin orden especificado")
    void getFollowedList() throws Exception{
        mockMvc.perform(get("/users/{userId}/followed/list",5))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("Lanzar excepcion cuando el id especificado no existe")
    void whenIdInvalid_ThrowsException() throws Exception {
        int userId = 999;

        mockMvc.perform(get("/users/{userId}/followed/list",userId))
                        .andExpect(status().isNotFound())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$.message").value("El 'usuario' con el id '999' no existe."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"name_as"})
    @DisplayName("Orden especificado no permitido debe lanzar una excepcion")
    void whenOrderByInvalidType_ThrowsIllegalArgumentException(String order) throws Exception{
        mockMvc.perform(get("/users/{userId}/followed/list",5)
                        .param("order",order))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
}

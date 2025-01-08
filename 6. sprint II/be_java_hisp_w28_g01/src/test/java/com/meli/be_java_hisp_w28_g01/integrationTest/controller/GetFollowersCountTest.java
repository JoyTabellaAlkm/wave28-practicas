package com.meli.be_java_hisp_w28_g01.integrationTest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Tests de Integración para obtener la cantidad de seguidores por seller")
public class GetFollowersCountTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Obtengo cantidad de seguidores Ok enviando id de seller válido")
    void getFollowersCountOk() throws Exception{
        int userId = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userId));

    }

    @Test
    @DisplayName("Retorna excepción Not Found al enviar un seller inexitente")
    void getFollowersCountNotFound() throws Exception{
        int userId = 1000;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Retorna excepción Bad Request al enviar un userID con formato inválido")
    void getFollowersCountBadRequest() throws Exception{
        String userId = "test";
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}

package com.meli.be_java_hisp_w28_g01.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w28_g01.dto.response.FollowDto;
import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.model.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Test de integracion para el controller addFollow")
class FollowControllerAddFollowTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    @DisplayName("Al agregar un follow deberia crearse y devolverse correctamente")
    void addFollow_ShouldReturnAFollow_WhenBuyerAndSellerAreValid() throws Exception {
        int userId = 1;
        int userIdToFollow = 2;

        Buyer buyer = new Buyer();
        buyer.setId(1);
        buyer.setName("Aspen Fernández");

        Seller seller = new Seller();
        seller.setId(2);
        seller.setName("María López");

        FollowDto followDto = new FollowDto(buyer, seller);


        ResultMatcher status = status().isOk();
        ResultMatcher contentType = content().contentType("application/json");
        ResultMatcher body = content().json(objectMapper.writeValueAsString(followDto));

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status)
                .andExpect(contentType)
                .andExpect(body);
    }
    @Test
    @DisplayName("Al agregar un follow con un id de vendedor inexistente deberia lanzar una excepcion")
    void addFollow_ShouldThrowNotFoundException_WhenSellerDontExist() throws Exception {
        int userId = 1;
        int userIdToFollow = 999;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El 'Vendedor' con el id '999' no existe."));
    }

    @Test
    @DisplayName("Al agregar un follow deberia lanzar una excepcion si ya existe dicho follow")
    void addFollow_ShouldThrowFollowAlreadyExistsException_WhenFollowExists() throws Exception {
        int userId = 1;
        int userIdToFollow = 1;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isConflict())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario con id '1' ya sigue al usuario con id '1'."));
    }
}
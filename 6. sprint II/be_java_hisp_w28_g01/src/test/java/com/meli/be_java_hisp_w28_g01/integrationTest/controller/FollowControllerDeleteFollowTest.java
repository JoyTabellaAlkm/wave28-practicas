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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Test de integracion para deleteFollow")
public class FollowControllerDeleteFollowTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Al borrar un follow deberia borrarse y devolverse correctamente")
    void deleteFollow_ShouldReturnAFollow() throws Exception {
        int userId = 2;
        int userIdToFollow = 2;

        Buyer buyer = new Buyer();
        buyer.setId(userId);
        buyer.setName("Celeste Blanco");

        Seller seller = new Seller();
        seller.setId(userIdToFollow);
        seller.setName("María López");

        FollowDto followDto = new FollowDto(buyer, seller);


        ResultMatcher status = status().isOk();
        ResultMatcher contentType = content().contentType("application/json");
        ResultMatcher body = content().json(mapper.writeValueAsString(followDto));

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status)
                .andExpect(contentType)
                .andExpect(body);
    }

    @Test
    @DisplayName("Al borrar un follow con un id de vendedor inexistente deberia lanzar una excepcion")
    void deleteFollow_ShouldThrowNotFoundException_WhenSellerDontExist() throws Exception {
        int userId = 1;
        int userIdToFollow = 999;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El 'vendedor' con el id '999' no existe."));
    }

    @Test
    @DisplayName("Al borrar un follow con un id de comprador inexistente deberia lanzar una excepcion")
    void deleteFollow_ShouldThrowNotFoundException_WhenBuyerDontExist() throws Exception {
        int userId = 999;
        int userIdToFollow = 1;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El 'comprador' con el id '999' no existe."));
    }

    @Test
    @DisplayName("Al borrar un follow deberia lanzar una excepcion si ya no existe dicho follow")
    void deleteFollow_ShouldThrowFollowNotFoundException_WhenFollowDontExists() throws Exception {
        int userId = 1;
        int userIdToFollow = 2;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El comprador con id '1' no sigue al vendedor con el id '2'."));
    }
}

package com.bootcamp.social_meli.integration.metrics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class GetAmountOfPromosByUserIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetAmountOfPromosSuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                        .param("user_id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1));
    }

    @Test
    public void testGetAmountOfPromosUserNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                        .param("user_id", "9999"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("404"))
                .andExpect(jsonPath("$.message").value("Usuario no encontrado"));
    }
}

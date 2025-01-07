package com.bootcamp.social_meli.integration.metrics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GetMostProductsIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getMostProductsSuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/top/most_products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.most_products", hasSize(10)))
                .andExpect(jsonPath("$.most_products[0].product_id").value(1))
                .andExpect(jsonPath("$.most_products[0].product_name").value("Silla Gamer"))
                .andExpect(jsonPath("$.most_products[0].type").value("Gamer"))
                .andExpect(jsonPath("$.most_products[0].brand").value("Racer"));
    }

    @Test
    public void getMostProductsWithRankParamSuccess() throws Exception {
        int rankParam = 3;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/top/most_products")
                .param("rank", String.valueOf(rankParam)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.most_products", hasSize(3)))
                .andExpect(jsonPath("$.most_products[0].product_id").value(1))
                .andExpect(jsonPath("$.most_products[0].product_name").value("Silla Gamer"))
                .andExpect(jsonPath("$.most_products[0].type").value("Gamer"))
                .andExpect(jsonPath("$.most_products[0].brand").value("Racer"));
    }

    @Test
    @DisplayName("Debería lanzar BadRequest si rank no es un número valido")
    public void getMostProductsBadRequestForNegativeRank() throws Exception {
        String invalidRank = "not_a_number";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/top/most_products")
                .param("rank", invalidRank))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("El rank debe ser un valor numerico."));
    }
}

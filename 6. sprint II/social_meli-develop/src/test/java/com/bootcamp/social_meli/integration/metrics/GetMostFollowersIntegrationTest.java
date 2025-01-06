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
public class GetMostFollowersIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getMostFollowersSuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/top/most_followers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.most_followers", hasSize(5)))
                .andExpect(jsonPath("$.most_followers[0].user_id").value(2))
                .andExpect(jsonPath("$.most_followers[0].user_name").value("MartinG23"))
                .andExpect(jsonPath("$.most_followers[0].followers_count").value(3))
                .andExpect(jsonPath("$.most_followers[1].user_id").value(3))
                .andExpect(jsonPath("$.most_followers[1].user_name").value("AnaPerezzz"))
                .andExpect(jsonPath("$.most_followers[1].followers_count").value(3))
                .andExpect(jsonPath("$.most_followers[2].user_id").value(4))
                .andExpect(jsonPath("$.most_followers[2].user_name").value("CarlosSan_15"))
                .andExpect(jsonPath("$.most_followers[2].followers_count").value(3))
                .andExpect(jsonPath("$.most_followers[3].user_id").value(1))
                .andExpect(jsonPath("$.most_followers[3].user_name").value("FrancoCol43"))
                .andExpect(jsonPath("$.most_followers[3].followers_count").value(2))
                .andExpect(jsonPath("$.most_followers[4].user_id").value(5))
                .andExpect(jsonPath("$.most_followers[4].user_name").value("LauLopez87"))
                .andExpect(jsonPath("$.most_followers[4].followers_count").value(1));
    }

    @Test
    public void getMostFollowersWithRankParamSuccess() throws Exception {
        int rankParam = 3;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/top/most_followers")
                .param("rank", String.valueOf(rankParam)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.most_followers", hasSize(3)))
                .andExpect(jsonPath("$.most_followers[0].user_id").value(2))
                .andExpect(jsonPath("$.most_followers[0].user_name").value("MartinG23"))
                .andExpect(jsonPath("$.most_followers[0].followers_count").value(3))
                .andExpect(jsonPath("$.most_followers[1].user_id").value(3))
                .andExpect(jsonPath("$.most_followers[1].user_name").value("AnaPerezzz"))
                .andExpect(jsonPath("$.most_followers[1].followers_count").value(3))
                .andExpect(jsonPath("$.most_followers[2].user_id").value(4))
                .andExpect(jsonPath("$.most_followers[2].user_name").value("CarlosSan_15"))
                .andExpect(jsonPath("$.most_followers[2].followers_count").value(3));
    }

    @Test
    @DisplayName("Debería lanzar BadRequest si rank no es un número valido")
    public void getMostFollowersBadRequestForNegativeRank() throws Exception {
        int invalidRank = -1;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/top/most_followers")
                .param("rank", String.valueOf(invalidRank)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("'rank' no puede ser <= 0"));
    }
}

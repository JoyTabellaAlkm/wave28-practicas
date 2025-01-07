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
public class GetMostPostsIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getMostPostsSuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/top/most_posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.most_posts", hasSize(5)))
                .andExpect(jsonPath("$.most_posts[0].user_id").value(1))
                .andExpect(jsonPath("$.most_posts[0].user_name").value("FrancoCol43"))
                .andExpect(jsonPath("$.most_posts[0].posts_amount").value(10));
    }

    @Test
    public void getMostPostsWithRankParamSuccess() throws Exception {
        int rankParam = 2;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/top/most_posts")
                .param("rank", String.valueOf(rankParam)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.most_posts", hasSize(2)))
                .andExpect(jsonPath("$.most_posts[0].user_id").value(1))
                .andExpect(jsonPath("$.most_posts[0].user_name").value("FrancoCol43"))
                .andExpect(jsonPath("$.most_posts[0].posts_amount").value(10))
                .andExpect(jsonPath("$.most_posts[1].user_id").value(2))
                .andExpect(jsonPath("$.most_posts[1].user_name").value("MartinG23"))
                .andExpect(jsonPath("$.most_posts[1].posts_amount").value(10));
    }

    @Test
    @DisplayName("Debería lanzar BadRequest si rank no es un número valido")
    public void getMostPostsBadRequestForNegativeRank() throws Exception {
        int invalidRank = -1;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/top/most_posts")
                        .param("rank", String.valueOf(invalidRank)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("'rank' no puede ser <= 0"));
    }
}

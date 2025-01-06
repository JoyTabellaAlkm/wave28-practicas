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
public class GetUserDetailsIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetUserDetailsSuccess() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/4/details"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("CarlosSan_15"))
                .andExpect(jsonPath("$.count_followers").value(3))
                .andExpect(jsonPath("$.count_followed").value(3))
                .andExpect(jsonPath("$.count_post").value(3))
                .andExpect(jsonPath("$.follower_not_followed.length()").value(1))
                .andExpect(jsonPath("$.follower_not_followed[0].user_id").value(5))
                .andExpect(jsonPath("$.follower_not_followed[0].user_name").value("LauLopez87"))
                .andExpect(jsonPath("$.followed_not_follower.length()").value(1))
                .andExpect(jsonPath("$.followed_not_follower[0].user_id").value(1))
                .andExpect(jsonPath("$.followed_not_follower[0].user_name").value("FrancoCol43"));
    }

    @Test
    public void testGetUserDetailsNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/99/details"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("404"))
                .andExpect(jsonPath("$.message").value("No se ha encontrado al usuario: 99"));
    }

    @Test
    public void testGetUserDetailsBadRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/-1/details"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("userId debe ser mayor que o igual a 1"));
    }
}

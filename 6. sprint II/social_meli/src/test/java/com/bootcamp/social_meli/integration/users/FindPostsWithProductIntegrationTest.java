package com.bootcamp.social_meli.integration.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@SpringBootTest
@AutoConfigureMockMvc
public class FindPostsWithProductIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnAndListOfPostsAndStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/posts/search?name=Silla Gamer"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Silla Gamer"))
                .andExpect(MockMvcResultMatchers.jsonPath("posts").isArray());
    }
}

package com.bootcamp.social_meli.integration.users;

import org.hamcrest.Matchers;
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
public class GetPostsByPriceRangeIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnAndListOfPostsAndStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/posts/prices?min=1000&&max=1500"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    void shouldThrowAnExceptionWhenMinIsHigherThanMax() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/posts/prices?min=100&&max=90"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("El precio maximo no puede ser menor que el precio minimo"));
    }

    @Test
    void shouldThrowAnExceptionWhenParameterIsNotANumber() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/posts/prices?min=a&&max=90"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("Formato precio minimo invalido"));
    }
}

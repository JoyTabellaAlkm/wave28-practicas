package com.bootcamp.social_meli.integration.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostProductIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testPostProductSucces()throws Exception{
        String postJson = "{\n" +
                "    \"user_id\": 6,\n" +
                "    \"date\": \"10-12-2025\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 1,\n" +
                "        \"product_name\": \"Silla Gamer\",\n" +
                "        \"type\": \"Gamer\",\n" +
                "        \"brand\": \"Racer\",\n" +
                "        \"color\": \"Red and Black\",\n" +
                "        \"notes\": \"Special Edition\"\n" +
                "    },\n" +
                "    \"category\": 100,\n" +
                "    \"price\": 1500.50\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Post creado exitosamente!"))
                .andExpect(jsonPath("$.user_id").value(6))
                .andExpect(jsonPath("$.date").value("2025-12-10"))
                .andExpect(jsonPath("$.product.product_id").value(1))
                .andExpect(jsonPath("$.product.product_name").value("Silla Gamer"))
                .andExpect(jsonPath("$.product.type").value("Gamer"))
                .andExpect(jsonPath("$.product.brand").value("Racer"))
                .andExpect(jsonPath("$.product.color").value("Red and Black"))
                .andExpect(jsonPath("$.product.notes").value("Special Edition"))
                .andExpect(jsonPath("$.category").value(100))
                .andExpect(jsonPath("$.price").value(1500.5))
                .andExpect(jsonPath("$.has_promo").value(false))
                .andExpect(jsonPath("$.discount").value(0.0));

    }
    @Test
    public void testPostProductBadRequest() throws Exception{
        String postJson = "{\n" +
                "    \"user_id\": 1,\n" +
                "    \"date\": \"10-12-2025\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 1,\n" +
                "        \"product_name\": \"Silla Gamer\",\n" +
                "        \"type\": \"Gamer\",\n" +
                "        \"brand\": \"Racer\",\n" +
                "        \"color\": \"Red and Black\",\n" +
                "        \"notes\": \"Special Edition\"\n" +
                "    },\n" +
                "    \"category\": 100,\n" +
                "    \"price\": 1500.50\n" +
                "}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("Post ya existente para el usuario 1"));
    }
    @Test
    public void testGetUserNotFound() throws Exception {
        String postJson = "{\n" +
                "    \"user_id\": 99,\n" +
                "    \"date\": \"10-12-2025\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 99,\n" +
                "        \"product_name\": \"Silla Gamer\",\n" +
                "        \"type\": \"Gamer\",\n" +
                "        \"brand\": \"Racer\",\n" +
                "        \"color\": \"Red and Black\",\n" +
                "        \"notes\": \"Special Edition\"\n" +
                "    },\n" +
                "    \"category\": 100,\n" +
                "    \"price\": 1500.50\n" +
                "}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("404"))
                .andExpect(jsonPath("$.message").value("No se ha encontrado al usuario: 99"));
    }
}

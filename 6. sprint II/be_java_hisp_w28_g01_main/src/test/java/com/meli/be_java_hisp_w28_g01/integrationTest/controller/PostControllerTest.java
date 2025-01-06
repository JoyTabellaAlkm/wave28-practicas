package com.meli.be_java_hisp_w28_g01.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w28_g01.dto.request.PostDto;
import com.meli.be_java_hisp_w28_g01.dto.request.ProductDto;
import com.meli.be_java_hisp_w28_g01.dto.request.PromoPostDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Tests de integración para Post")
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    public PostControllerTest() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("Obtengo lista de post OK sin envío de parámetros")
    public void whenListAllPost_ShouldReturnListOk() throws Exception{
        mockMvc.perform(get("/products/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

//Bonus - Add Post

    @Test
    @DisplayName("Obtengo el post creado al enviar un post con formato válido")
    void whenAddPostCalled_withValidPostDto_shouldReturnCreatedPost() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        PostDto postDto = new PostDto();
        postDto.setDate(LocalDate.parse(LocalDate.now().minusDays(3).format(formatter),formatter));
        postDto.setUserId(1);
        postDto.setProductDto(new ProductDto(150,"Aire Acondicionado Split","A","Acme","Black","notes" ));
        postDto.setPrice(350000.0);
        postDto.setCategory(1);

        String payloadJson = objectMapper.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andDo(print());
    }


//T-0005 -> OK(WithoutOrder)
    @Test
    @DisplayName("Obtengo lista de posts de seller que sigue un buyer, sin el envío de parámetros de orden - OK")
    void whenGetProductsCalledWithoutOrder_shouldReturnPosts() throws Exception {
        int userId = 1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.posts[0].date").value("31-12-2024"))

                .andDo(print());
    }

    @Test
    @DisplayName("Retorna exception Not Found al solicitar lista de post enviando usuario inexistente")
    public void whenGetProductsCalledWithUnexistingUserId_shouldReturnNotFound() throws Exception {
        int userId = -1;

        mockMvc.perform(get("/products/followed/{userId}/list", userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El 'usuario' con el id '-1' no existe."));
    }

    @Test
    @DisplayName("Obtengo lista de post OK al enviar un type válido y existente")
    void  whenGet_listPostByProductType_shouldResponseAList () throws Exception {
        String productType = "Gamer";

        ResultMatcher status = status().isOk();
        ResultMatcher contentType = content().contentType("application/json");

        mockMvc.perform(MockMvcRequestBuilders.get("/products/type/{productType}", productType))
                .andExpect(status)
                .andExpect(contentType);
    }

    @Test
    @DisplayName("Retorna exception Bad Request al enviar un product type inválido")
    void  whenGet_listPostByProductType_shouldThowException () throws Exception {
        String productType = "adafasf";

        ResultMatcher status = status().isBadRequest();
        ResultMatcher contentType = content().contentType("application/json");

        mockMvc.perform(MockMvcRequestBuilders.get("/products/type/{productType}", productType))
                .andExpect(status)
                .andExpect(contentType)
                .andExpect(jsonPath("$.message").value("La lista de 'productos de tipo adafasf' está vacía."));
    }

    @Test
    @DisplayName("Obtengo el promo post creado al enviar un promo post con formato válido\"")
    public void whenAddPromoPostCalled_withValidPostDto_shouldReturnCreatedPost() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        PromoPostDto postDto = new PromoPostDto();
        postDto.setDate(LocalDate.parse(LocalDate.now().minusDays(3).format(formatter),formatter));
        postDto.setUserId(1);
        postDto.setProductDto(new ProductDto(150,"Aire Acondicionado Split","A","Acme","Black","notes" ));
        postDto.setPrice(350000.0);
        postDto.setCategory(1);
        postDto.setDiscount(5.0);
        postDto.setHasPromo(true);

        String payloadJson = objectMapper.writeValueAsString(postDto);

        mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Se creó la publicación correctamente con el id: 5"))
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andDo(print());
    }
}

package com.bootcamp.social_meli.integration.products;

import com.bootcamp.social_meli.dto.request.ProductDTO;
import com.bootcamp.social_meli.dto.request.PromoPostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class CreatePromoPostIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void createPromoPostShouldReturnStatus200() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate creationDate = LocalDate.parse("12-09-2024", formatter);
        ProductDTO productDTO = new ProductDTO(4L,
                "Monitor CURVO",
                "Monitor",
                "Samsung",
                "Black",
                "32 pulgadas");

        PromoPostDTO postDTO = new PromoPostDTO();
        postDTO.setUserId(1L);
        postDTO.setCreateDate(creationDate);
        postDTO.setProduct(productDTO);
        postDTO.setCategory(1);
        postDTO.setPrice(650000D);
        postDTO.setHas_promo(true);
        postDTO.setDiscount(15.0);

        String postDTOJSON = objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter().writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOJSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void createPromoPostShouldReturnStatus400WhenPassingNullProduct() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate creationDate = LocalDate.parse("12-09-2024", formatter);

        PromoPostDTO postDTO = new PromoPostDTO();
        postDTO.setUserId(1L);
        postDTO.setCreateDate(creationDate);
        postDTO.setCategory(1);
        postDTO.setPrice(650000D);
        postDTO.setHas_promo(true);
        postDTO.setDiscount(15.0);

        String postDTOJSON = objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter().writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOJSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors.product").value("Producto no puede ser nulo."));
    }

    @Test
    void shouldReturnStatus400WhenPassingNullInAllFieldsAndDetailMessage() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ProductDTO productDTO = new ProductDTO();
        PromoPostDTO postDTO = new PromoPostDTO();
        postDTO.setProduct(productDTO);

        String postDTOJSON = objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter().writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOJSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['product.product_id']").value("El campo no puede ser nulo."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['product.product_name']").value("El campo no puede estar vacío."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['price']").value("El precio no puede ser nulo."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['product.brand']").value("El campo no puede estar vacío."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['product.color']").value("El campo no puede estar vacío."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['discount']").value("El descuento no puede ser nulo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['category']").value("categoria no puede ser nulo."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['has_promo']").value("El campo has_promo no puede ser nulo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['userId']").value("El user_id no puede ser nulo."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['createDate']").value("la fecha de creacion no puede ser nulo."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors['product.type']").value("El campo no puede estar vacío."));
    }

}

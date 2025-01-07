package com.mercadolibre.social.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.social.dto.response.PostDetailsDTO;
import com.mercadolibre.social.dto.response.ProductResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("IT-BONUS -> US-12: Search")
    public void givenQueryAndPriceRange_whenSearchProducts_thenReturnFilteredResults() throws Exception {
        // ARRANGE
        String query = "light";
        String rangePrice = "100-149";

        List<PostDetailsDTO> response = List.of(
                new PostDetailsDTO(
                        1,
                        10,
                        LocalDate.of(2024, 11, 10),
                        new ProductResponseDTO(
                                10,
                                "Kindle Paperwhite",
                                "E-reader",
                                "Amazon",
                                "Black",
                                "E-reader with adjustable light."
                        ),
                        7,
                        129.99
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(response));

        // ACT AND ASSERT
        mockMvc.perform(get("/products")
                        .param("search", query)
                        .param("range_price", rangePrice))
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        expectedBody
                ).andDo(print());
    }
}
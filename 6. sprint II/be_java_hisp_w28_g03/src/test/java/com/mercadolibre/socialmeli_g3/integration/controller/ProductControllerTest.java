package com.mercadolibre.socialmeli_g3.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.socialmeli_g3.dto.ProductDTO;
import com.mercadolibre.socialmeli_g3.dto.response.ExceptionDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    private static final ProductDTO productDTO1 = new ProductDTO(101, "Silla Gamer",
            "Gamer", "Racer",  "Red & Black", "Special Edition"
    );

    private static final ProductDTO productDTO2 = new ProductDTO(103, "Mouse Gamer",
            "Gamer", "Razer",  "Green", "Wireless"
    );

    private static final ProductDTO productDTO3 = new ProductDTO(104, "Monitor Gamer",
            "Gamer", "AOC",  "Black", "Curved"
    );

    @Test
    @DisplayName("IT-0014 - The endpoint product/search should return a list of products filtered by keyword (1 product found)")
    void searchProducts() throws Exception {

        List<ProductDTO> productDTOS = new ArrayList<>();
        productDTOS.add(productDTO1);

        ResultMatcher expectedStatusCode = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(productDTOS));

        mockMvc.perform(get("/products/search?keyword=sil")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(expectedStatusCode, expectedContentType, expectedBody)
                .andDo(print());
    }

    @Test
    @DisplayName("IT-0014 - The endpoint product/search should throw a BadRequestException when the parameter keyword is not provided")
    void searchProducts_should_throw_BadRequestException_when_keyword_is_not_provided() throws Exception {

        String errorMessage = "Required request parameter 'keyword' is missing";
        ExceptionDTO expectedException = new ExceptionDTO(errorMessage, null);

        ResultMatcher expectedStatusCode = status().isBadRequest();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(expectedException));

        mockMvc.perform(get("/products/search")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(expectedStatusCode, expectedContentType, expectedBody)
                .andDo(print());
    }

    @Test
    @DisplayName("IT-0014 - The endpoint product/search should throw a BadRequestException when the parameter keyword is null or less than 3 characters")
    void searchProducts_should_throw_BadRequestException_when_keyword_is_null() throws Exception {

        List<String> errorMessage = new ArrayList<>(List.of("keyword: Keyword cannot be null or less than 3 characters"));
        String errorDetails = errorMessage.toString();

        ExceptionDTO expectedException = new ExceptionDTO("Data request invalid", errorDetails);

        ResultMatcher expectedStatusCode = status().isBadRequest();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(expectedException));

        mockMvc.perform(get("/products/search?keyword=si")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(expectedStatusCode, expectedContentType, expectedBody)
                .andDo(print());
    }

    @Test
    @DisplayName("IT-0014 - The endpoint product/search should throw a NotFoundException when the product with the provided keyword does not exist")
    void searchProducts_should_throw_NotFoundException_when_product_does_not_exist() throws Exception {

        String errorMessage = "Products not found";
        ExceptionDTO expectedException = new ExceptionDTO(errorMessage, null);

        ResultMatcher expectedStatusCode = status().isNotFound();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(expectedException));

        mockMvc.perform(get("/products/search?keyword=testProductNotFound")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(expectedStatusCode, expectedContentType, expectedBody)
                .andDo(print());
    }

    @Test
    @DisplayName("IT-0014 - The endpoint product/search should return a list of products filtered by keyword (Multiple products found)")
    void searchProducts_should_return_a_list_of_products_filtered_by_keyword() throws Exception {
        List<ProductDTO> productDTOS = new ArrayList<>();

        productDTOS.add(productDTO1);
        productDTOS.add(productDTO2);
        productDTOS.add(productDTO3);

        ResultMatcher expectedStatusCode = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(productDTOS));

        mockMvc.perform(get("/products/search?keyword=gam")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(expectedStatusCode, expectedContentType, expectedBody)
                .andDo(print());
    }

}
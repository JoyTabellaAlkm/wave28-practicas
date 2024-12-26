package com.mercadolibre.romannumerals;

import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RomanNumeralsRestController.class)
class RomanNumeralsRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ContentNegotiatingViewResolver contentNegotiatingViewResolver;

    @Test
    @DisplayName("1 a romano")
    void testToRoman_1() throws Exception{
        performTest("1","I");
    }
    @Test
    @DisplayName("3 a romano")
    void testToRoman_3() throws Exception{
        performTest("3","III");
    }
    @Test
    @DisplayName("5 a romano")
    void testToRoman_5() throws Exception{
        performTest("5","V");
    }
    @Test
    @DisplayName("7 a romano")
    void testToRoman_7() throws Exception{
        performTest("7","VII");
    }
    @Test
    @DisplayName("10 a romano")
    void testToRoman_10() throws Exception{
        performTest("10","X");
    }
    @Test
    @DisplayName("50 a romano")
    void testToRoman_50() throws Exception{
        performTest("50","L");
    }

    void performTest(String decimal, String roman) throws Exception{
        mockMvc.perform(get("/"+decimal))
                .andExpect(status().isOk())
                .andExpect(content().string(roman));
    }


}

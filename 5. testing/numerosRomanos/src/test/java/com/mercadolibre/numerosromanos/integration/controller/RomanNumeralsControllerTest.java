package com.mercadolibre.numerosromanos.integration.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void oneShouldBeI() throws Exception {
        performTest("1", "I");
    }

    @Test
    public void threeShouldBeIII() throws Exception {
        performTest("3", "III");
    }

    @Test
    public void fiveShouldBeV() throws Exception {
        performTest("5", "V");
    }

    @Test
    public void sevenShouldBeVII() throws Exception {
        performTest("7", "VII");
    }

    @Test
    public void tenShouldBeX() throws Exception {
        performTest("10", "X");
    }

    @Test
    public void fiftyShouldBeL() throws Exception {
        performTest("50", "L");
    }



    private void performTest(String decimal, String roman) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/" + decimal))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(roman)))
                .andDo(print());
    }
}

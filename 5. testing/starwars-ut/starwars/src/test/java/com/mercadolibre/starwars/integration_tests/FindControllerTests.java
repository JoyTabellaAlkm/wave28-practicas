package com.mercadolibre.starwars.integration_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Verifica que hay mas de un resultado si se busca 'Darth'")
    public void verificaResultadoMultiple() throws Exception {
        ResultMatcher statusOk = status().isOk();
        ResultMatcher atLeastOneValue = jsonPath("$", hasSize(greaterThan(0)));

        mockMvc.perform(get("/{query}","Darth"))
                .andDo(print())
                .andExpect(statusOk)
                .andExpect(atLeastOneValue);
    }

}

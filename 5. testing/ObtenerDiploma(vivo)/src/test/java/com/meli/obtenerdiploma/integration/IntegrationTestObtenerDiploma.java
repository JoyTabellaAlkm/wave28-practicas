package com.meli.obtenerdiploma.integration;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestObtenerDiploma {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void obtenerDiploma() throws Exception {
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        long idEstudiante = 1L;

        mockMvc.perform(get("/analyzeScores/"+idEstudiante)).
                andExpect(expectedStatus).andExpect(expectedContentType).
                andExpect(jsonPath("$.id").value(idEstudiante)).andDo(print());
    }

    @Test
    public void obtenerDiplomaNotExist() throws Exception {
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        long idEstudiante = 4;

        mockMvc.perform(get("/analyzeScores/"+idEstudiante)).
                andExpect(expectedStatus).andExpect(expectedContentType).
                andExpect(jsonPath("$.name").value("StudentNotFoundException")).
                andDo(print());
    }

}

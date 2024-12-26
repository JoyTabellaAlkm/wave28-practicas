package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;

import com.meli.obtenerdiploma.utils.StudentsDtos;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("-analyzeScores Ok- Obtener puntaje de un estudiante válido")
    void analyzeScores_withValidStudentId_shouldReturnStudentDTO() throws Exception {
        // Arrange
        StudentDTO studentDTO = StudentsDtos.getStudent1();

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        // Act & Assert
         mockMvc.perform(get("/analyzeScores/{studentId}", 2)
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(expectedStatus)
                 .andExpect(expectedContentType)
                 .andDo(print())
                 .andReturn();
    }

    @Test
    void testGivenAnInvalidStudentIdThrowExceptionMessage() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", 590L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andDo(print())
                .andReturn();
    }

}

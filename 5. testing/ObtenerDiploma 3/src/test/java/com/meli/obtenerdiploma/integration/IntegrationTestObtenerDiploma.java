package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestObtenerDiploma {
    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    public void analyze_score_of_student_with_subjects() throws Exception {
        Long expectedId = 1L;
        String expectedName = "Juan";
        String expectedDescription= "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.";
        Double expectedAverageScore = 7.333333333333333;
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", expectedId)).
                andExpect(contentTypeEsperado).
                andExpect(statusEsperado).
                andExpect(jsonPath("$.id").value(expectedId)).
                andExpect(jsonPath("$.message").value(expectedDescription)).
                andExpect(jsonPath("$.studentName").value(expectedName)).
                andExpect(jsonPath("$.averageScore").value(expectedAverageScore));
    }
}

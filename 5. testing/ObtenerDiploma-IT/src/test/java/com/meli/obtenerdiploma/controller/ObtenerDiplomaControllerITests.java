package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerITests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void analyzeScoreTest() throws Exception {
        StudentDTO studentDTO1 = new StudentDTO(
                1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                List.of(
                new SubjectDTO("Matemática", 9D),
                new SubjectDTO("Física", 7D),
                new SubjectDTO("Química", 6D))
        );
        StudentDTO studentEsperado = studentDTO1;
        ObjectMapper objectMapper = new ObjectMapper();
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(studentEsperado));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    public void throwsError() throws Exception {
        ErrorDTO errorEsperado = new ErrorDTO("StudentNotFoundException", "El alumno con Id -1 no se encuetra registrado.");
        ObjectMapper objectMapper = new ObjectMapper();
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(errorEsperado));
        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(get("/analyzeScores/{studentId}", -1))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }
}

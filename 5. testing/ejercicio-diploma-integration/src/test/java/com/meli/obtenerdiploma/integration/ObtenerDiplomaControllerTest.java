package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.Assert;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void analyzeScoresOk() throws Exception {
        StudentDTO student = new StudentDTO(
                1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));

        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(student));
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");

        long studentId = 1L;

        mockMvc.perform(get("/analyzeScores/{studentId}", studentId))
                .andExpect(expectedBody)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andDo(print());
    }

    @Test
    public void analyzeScoresNotFound() throws Exception {
        long studentId = 0;
        ErrorDTO error = new ErrorDTO(
                "StudentNotFoundException",
                "El alumno con Id " + studentId + " no se encuetra registrado.");

        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(error));
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedContentType = content().contentType("application/json");



        mockMvc.perform(get("/analyzeScores/{studentId}", studentId))
                .andExpect(expectedBody)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andDo(print());
    }





}

package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void analyzeScores() throws Exception {
        //Arrange
        Long parametroEntrada = 1L;
        ObjectMapper mapper = new ObjectMapper();
        StudentDTO st = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.",
                8.0, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0)));

        //Act & Assert

        mockMvc.perform(get("/analyzeScores/{studentId}", parametroEntrada))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(st)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }
}
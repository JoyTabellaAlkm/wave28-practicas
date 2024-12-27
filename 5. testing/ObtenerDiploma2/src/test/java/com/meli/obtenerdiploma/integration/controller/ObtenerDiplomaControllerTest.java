package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    private StudentDTO studentDTO1;

    ObjectMapper objectMapper = new ObjectMapper();
    //.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
    // Justo esta linea no hace falta porque el Json de prueba esta escrito en camelCase :O
    //.registerModule(new JavaTimeModule());
    // Tampoco hace falta manejar fechas en este ejercicio.

    @BeforeEach
    public void setupStudents() {
        studentDTO1 = new StudentDTO(1L, "Juan","El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", 7.333333333333333, List.of(
                new SubjectDTO("Matemática", 9D),
                new SubjectDTO("Física", 7D),
                new SubjectDTO("Química", 6D))
        );
    }

    @Test
    @DisplayName("Debe retornar el analisis del estudiante con el codigo de respuesta esperado")
    void analyzeScores() throws Exception {
        StudentDTO studentEsperado = studentDTO1;
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(studentEsperado));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("Debe lanzar una NotFoundException si el id del usuario no es valido")
    void throwsError() throws Exception {
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
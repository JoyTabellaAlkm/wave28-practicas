package com.mercadolibre.obtener_diploma.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.obtener_diploma.model.StudentDTO;
import com.mercadolibre.obtener_diploma.service.IObtenerDiplomaService;
import com.mercadolibre.obtener_diploma.util.TestUtilsGenerator;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @Test
    @DisplayName("Debe analizar el puntaje del estudiante con id 1")
    public void analizarPuntajeEstudiante() throws Exception {
        // ARRANGE
        long studentId = 1;
        StudentDTO studentEsperado = new StudentDTO();
        studentEsperado.setId(studentId);
        studentEsperado.setStudentName("Juan");

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        MvcResult result = mockMvc.perform(get("/analyzeScores/" + studentId))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andDo(print())
                .andReturn();

        StudentDTO response = objectMapper.readValue(result.getResponse().getContentAsString(), StudentDTO.class);
        assertEquals(8.0, response.getAverageScore());
        assertEquals("El alumno Juan ha obtenido un promedio de 8,00. Puedes mejorar.", response.getMessage());
    }

    @Test
    @DisplayName("Debe lanzar una excepción para el estudiante con id 100")
    public void analizarPuntajeEstudianteNoExistente() throws Exception {
        // ARRANGE
        long studentId = 100;
        StudentDTO studentEsperado = new StudentDTO();
        studentEsperado.setId(studentId);
        studentEsperado.setStudentName("Juan");

        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(get("/analyzeScores/" + studentId))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andDo(print())
                .andReturn();
    }

}

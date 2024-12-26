package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;

import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentsDtos;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("-analyzeScores Ok- Obtener puntaje de un estudiante válido")
    void analyzeScores_withValidStudentId_shouldReturnStudentDTO() throws Exception {
        // Arrange
        StudentDTO studentDTO = StudentsDtos.getStudent1();

        String expectedJson = objectMapper.writeValueAsString(studentDTO);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        when(service.analyzeScores(studentDTO.getId())).thenReturn(studentDTO);

        // Act & Assert
         MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", studentDTO.getId())
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(expectedStatus)
                 .andExpect(expectedContentType)
                 .andDo(print())
                 .andReturn();

        String actualJson = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(expectedJson, actualJson, "La respuesta JSON no coincide con la esperada.");
    }

}

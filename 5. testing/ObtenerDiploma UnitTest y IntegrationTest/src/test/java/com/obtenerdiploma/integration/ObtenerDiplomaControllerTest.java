package com.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.obtenerdiploma.dto.StudentWithMessageDTO;
import com.obtenerdiploma.dto.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {


    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();


    @Test
    void analyzeScores() throws Exception {
        Long idMock = 1L;
        StudentWithMessageDTO response = new StudentWithMessageDTO(1L, "Juan", Set.of(new SubjectDTO("Matemática", 9.0),new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0)), "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", 7.333333333333333);

        mockMvc.perform(get("/analyzeScores/{studentId}", idMock))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(response)))
                .andExpect(content().contentType("application/json"))
                .andDo(print());
    }
}
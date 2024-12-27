package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.unit.factory.StudentFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @AfterEach
    public void tearDown() throws Exception {
        Path original = Path.of("src/test/resources/users.json");
        Path backup = Path.of("src/test/resources/users_backup.json");
        Files.copy(backup, original, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void shouldReturnStudentWithAnalizedScoresWhenValidStudentIdIsProvided() throws Exception {
        StudentDTO studentToAnalize = StudentFactory.createJuanStudentDTO();
        StudentDTO expectedStudentAnalized = StudentFactory.juanStudentWithScoresDTO;

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(expectedStudentAnalized));

        mockMvc.perform(get("/analyzeScores/{studentId}", studentToAnalize.getId())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(studentToAnalize)))
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andDo(print());
    }

    @Test
    public void shouldReturnNotFoundtWhenNotExistingStudentIdIsProvided() throws Exception {
        StudentDTO studentToAnalize = StudentFactory.createInvalidStudentDTO();
        Long nonExistentStudentId = studentToAnalize.getId();

        ResultMatcher expectedStatus = status().isNotFound();
        ErrorDTO expectedError = new ErrorDTO(
                StudentNotFoundException.class.getSimpleName(),
                "El alumno con Id " + nonExistentStudentId + " no se encuetra registrado."
        );
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(expectedError));

        mockMvc.perform(get("/analyzeScores/{studentId}", nonExistentStudentId)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(studentToAnalize)))
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andDo(print());
    }
}

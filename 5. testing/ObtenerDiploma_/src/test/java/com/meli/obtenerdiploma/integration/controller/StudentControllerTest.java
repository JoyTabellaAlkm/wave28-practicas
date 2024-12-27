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
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
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
    public void shouldRegisterWhenValidStudentIsProvided() throws Exception {
        StudentDTO studentToRegister = StudentFactory.createSofiaStudentDTO();
        ResultMatcher expectedStatus = status().isOk();

        mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(studentToRegister)))
                .andExpect(expectedStatus)
                .andDo(print());
    }

    @Test
    public void shouldNotRegisterWhenInvalidStudentIsProvided() throws Exception {
        StudentDTO studentToRegister = StudentFactory.createInvalidStudentDTO();
        ResultMatcher expectedStatus = status().isBadRequest();

        mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(studentToRegister)))
                .andExpect(expectedStatus)
                .andDo(print());
    }

    @Test
    public void shouldReturnStudentWhenExistingIdIsProvided() throws Exception {
        StudentDTO expectedStudent = StudentFactory.createPedroStudentDTO();
        Long expectedStudentId = expectedStudent.getId();

        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(expectedStudent));
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");

        mockMvc.perform(get("/student/getStudent/{id}", expectedStudentId))
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andExpect(expectedContentType)
                .andDo(print());
    }

    @Test
    public void shouldReturnNotFoundWhenNonExistingIdIsProvided() throws Exception {
        Long nonExistentStudentId = 10L;

        ErrorDTO expectedError = new ErrorDTO(
                StudentNotFoundException.class.getSimpleName(),
                "El alumno con Id " + nonExistentStudentId + " no se encuetra registrado."
        );
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(expectedError));
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedContentType = content().contentType("application/json");

        mockMvc.perform(get("/student/getStudent/{id}", nonExistentStudentId))
                .andExpect(expectedStatus)
                .andExpect(expectedBody)
                .andExpect(expectedContentType)
                .andDo(print());
    }

    @Test
    public void shouldModifyStudentWhenValidDataIsProvided() throws Exception {
        StudentDTO studentToUpdate = StudentFactory.pedroStudentWithScoresDTO;
        ResultMatcher expectedStatus = status().isOk();

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(studentToUpdate)))
                .andExpect(expectedStatus)
                .andDo(print());
    }

    @Test
    public void shouldReturnBadRequestWhenInvalidDataIsProvided() throws Exception {
        StudentDTO studentToRegister = StudentFactory.createInvalidStudentDTO();
        ResultMatcher expectedStatus = status().isBadRequest();

        mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(studentToRegister)))
                .andExpect(expectedStatus)
                .andDo(print());
    }

    @Test
    public void shouldRemoveStudentById() throws Exception {
        ResultMatcher expectedStatus = status().isNoContent();
        Long expectedStudentId = StudentFactory.createPedroStudentDTO().getId();

        mockMvc.perform(delete("/student/removeStudent/{id}", expectedStudentId))
                .andExpect(expectedStatus)
                .andDo(print());
    }

    @Test
    public void testListStudentsOK() throws Exception {
        Set<StudentDTO> studentsEsperado = Set.of(StudentFactory.createPedroStudentDTO(), StudentFactory.createJuanStudentDTO());
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(studentsEsperado));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(get("/student/listStudents"))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }
}

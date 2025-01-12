package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private StudentDTO studentDTO;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        studentDTO = new StudentDTO(
                3L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9D),
                        new SubjectDTO("Física", 7D),
                        new SubjectDTO("Química", 6D))
        );
    }

    @Test
    @DisplayName("Debe registrar correctamente un usuario")
    @Order(1)
    void registerStudent() throws Exception {
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String body = objectWriter.writeValueAsString(studentDTO);
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().string("");

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Debe lanzar una MethodArgumentNotValidException si el id es menor a 0")
    @Order(2)
    void shouldThrowIfIdIsLessThanZero() throws Exception {
        studentDTO.setId(-1L);
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String body = objectWriter.writeValueAsString(studentDTO);
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher typeEsperado = content().contentType("application/json");
        ErrorDTO errorEsperado = new ErrorDTO("MethodArgumentNotValidException", "El id no puede ser menor a 0");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(errorEsperado));

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(statusEsperado)
                .andExpect(typeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Debe lanzar una MethodArgumentNotValidException si la lista de materias esta vacia")
    @Order(3)
    void shouldThrowIfSubjectsListIsEmpty() throws Exception {
        studentDTO.setSubjects(new ArrayList<>());
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String body = objectWriter.writeValueAsString(studentDTO);
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher typeEsperado = content().contentType("application/json");
        ErrorDTO errorEsperado = new ErrorDTO("MethodArgumentNotValidException", "La lista de materias no puede estar vacía.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(errorEsperado));

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(statusEsperado)
                .andExpect(typeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Debe lanzar una MethodArgumentNotValidException si el nombre del estudiante esta vacio")
    @Order(4)
    void shouldThrowIfStudentNameIsEmpty() throws Exception {
        studentDTO.setStudentName("");
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String body = objectWriter.writeValueAsString(studentDTO);
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher typeEsperado = content().contentType("application/json");
        ErrorDTO errorEsperado = new ErrorDTO("MethodArgumentNotValidException", "El nombre del estudiante no puede estar vacío.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(errorEsperado));

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(statusEsperado)
                .andExpect(typeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Debe lanzar una MethodArgumentNotValidException si el nombre del estudiante no comienza con mayuscula")
    @Order(5)
    void shouldThrowIfStudentNameDoesNotStartWithCapitalLetters() throws Exception {
        studentDTO.setStudentName("pepe");
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String body = objectWriter.writeValueAsString(studentDTO);
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher typeEsperado = content().contentType("application/json");
        ErrorDTO errorEsperado = new ErrorDTO("MethodArgumentNotValidException", "El nombre del estudiante debe comenzar con mayúscula.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(errorEsperado));

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(statusEsperado)
                .andExpect(typeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Debe lanzar una MethodArgumentNotValidException si el nombre del estudiante tiene mas de 50 caracteres")
    @Order(6)
    void shouldThrowIfStudentNameHasMoreThanFiftyCharacters() throws Exception {
        studentDTO.setStudentName("AaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaa");
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String body = objectWriter.writeValueAsString(studentDTO);
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher typeEsperado = content().contentType("application/json");
        ErrorDTO errorEsperado = new ErrorDTO("MethodArgumentNotValidException", "La longitud del nombre del estudiante no puede superar los 50 caracteres.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(errorEsperado));

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(statusEsperado)
                .andExpect(typeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Debe traer al estudiante correcto por id")
    @Order(7)
    void getStudent() throws Exception {
        StudentDTO studentEsperado = studentDTO;
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher typeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(studentEsperado));

        mockMvc.perform(get("/student/getStudent/{id}", 3L))
                .andExpect(statusEsperado)
                .andExpect(typeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Debe lanzar una StudentNotFoundException si el id proporcionado no es correcto")
    @Order(8)
    void shouldThrowAStudentNotFoundExceptionIfUserIdIsNotValid() throws Exception {
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id 100 no se encuetra registrado.");
        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher typeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(errorDTO));

        mockMvc.perform(get("/student/getStudent/{id}", 100L))
                .andExpect(statusEsperado)
                .andExpect(typeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Debe actualizar correctamente un usuario")
    @Order(9)
    void modifyStudent() throws Exception {
        StudentDTO estudianteAModificar = studentDTO;
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String body = objectWriter.writeValueAsString(estudianteAModificar);
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentEsperado = content().string("");

        mockMvc.perform(put("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(statusEsperado)
                .andExpect(contentEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Debe eliminar un estudiante")
    @Order(10)
    void removeStudent() throws Exception {
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentEsperado = content().string("");

        mockMvc.perform(delete("/student/removeStudent/{id}", 3L))
                .andExpect(statusEsperado)
                .andExpect(contentEsperado)
                .andDo(print());
    }
}
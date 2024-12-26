package com.meli.ejercicio_diploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ejercicio_diploma.model.StudentDTO;
import com.meli.ejercicio_diploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    private static StudentDTO student;

    @BeforeAll
    public static void init() {
        objectMapper = new ObjectMapper();
        student = new StudentDTO(
                2L,
                "Nico",
                "El alumno Nico ha obtenido un promedio de 9,00. Felicitaciones!",
                9.0,
                List.of(
                        new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Fisica", 9.0),
                        new SubjectDTO("Quimica",    8.0)
                )
        );
    }

    @BeforeEach @AfterEach
    public void setUp() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/test/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"studentName\": \"Juan\",\n" +
                "    \"message\": \"El alumno Juan ha obtenido un promedio de 9,00. Felicitaciones!\",\n" +
                "    \"averageScore\": 9.0,\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matematica\",\n" +
                "        \"score\": 10.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Fisica\",\n" +
                "        \"score\": 9.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Quimica\",\n" +
                "        \"score\": 8.0\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");
        writer.close();
    }

    @Test
    public void testRegisterStudent() throws Exception {
        mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(student)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterStudentValidationException() throws Exception {
        StudentDTO invalidStudent = new StudentDTO(
                3L,
                "Marco",
                "El alumno Marco ha obtenido un promedio de 9,00. Felicitaciones!",
                9.0,
                List.of());
        mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(invalidStudent)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacia."));
    }

    @Test
    public void testGetStudent() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"));
    }

    @Test
    public void testGetStudentNotFoundException() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 999 no se encuetra registrado" +
                        "."));
    }


    @Test
    public void testModifyStudent() throws Exception {
        student.setStudentName("Nico Modificado");

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(student)))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/student/getStudent/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Nico Modificado"));
    }


    @Test
    public void testRemoveStudent() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testListStudents() throws Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
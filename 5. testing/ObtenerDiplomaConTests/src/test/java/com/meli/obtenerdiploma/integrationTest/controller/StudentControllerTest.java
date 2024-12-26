package com.meli.obtenerdiploma.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    public StudentControllerTest() {
        this.objectMapper = new ObjectMapper();
    }

    @BeforeAll
    public static void setUp() {
        objectMapper  = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false);

    }
    @Test
    public void registerStudentTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Gabriel");
        studentDTO.setId(3L);
        SubjectDTO fisica = new SubjectDTO("Fisica", 1.0);
        SubjectDTO quimica = new SubjectDTO("Quimica", 9.0);
        SubjectDTO plastica = new SubjectDTO("Plástica", 10.0);
        studentDTO.setSubjects(List.of(fisica, quimica, plastica));

        String payloadJson = objectMapper.writeValueAsString(studentDTO);


        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk());


    }

    @Test
    public void getStudentTest() throws Exception {
        Long studentId = 3L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentId);
        studentDTO.setStudentName("Gabriel");

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value("Gabriel"));

    }
}

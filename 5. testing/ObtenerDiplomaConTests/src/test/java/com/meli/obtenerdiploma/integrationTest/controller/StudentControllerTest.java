package com.meli.obtenerdiploma.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private ObjectMapper objectMapper;

    public StudentControllerTest() {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void registerStudentTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Gabriel");
        String payloadJson = objectMapper.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk());


        verify(studentService, atLeast(1)).create(studentDTO);
    }

    @Test
    public void getStudentTest() throws Exception {
        Long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentId);
        studentDTO.setStudentName("Gabriel");

        when(studentService.read(studentId)).thenReturn(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value("Gabriel"));

        verify(studentService, times(1)).read(studentId);
    }
}

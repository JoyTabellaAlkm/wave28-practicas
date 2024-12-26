package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.StudentsDtos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    void register_isValidStudent() throws Exception{
        //ARRANGE
        StudentDTO student = StudentsDtos.getStudent3();
        ResultMatcher expertedStatus = status().isOk();
        String body = objectMapper.writeValueAsString(student);
        String contentType = "application/json";
        String URL = "/student/registerStudent";

        // ACT & ASSERT
        mockMvc.perform(post(URL)
                        .contentType(contentType)
                        .content(body))
                .andExpect(expertedStatus)
                .andDo(print());
    }

    @Test
    void update_isValidStudent() throws Exception {

        StudentDTO student = StudentsDtos.getStudent4();
        studentService.create(student);

        StudentDTO studentUpdate = StudentsDtos.getStudent5Update();

        String body = objectMapper.writeValueAsString(studentUpdate);
        String contentType = "application/json";
        String URL = "/student/modifyStudent";
        ResultMatcher expertedStatus = status().isOk();

        mockMvc.perform(post(URL)
                        .contentType(contentType)
                        .content(body))
                .andExpect(expertedStatus)
                .andDo(print());
        /*
                verify(studentService, times(1)).update(studentUpdate);
        */
    }

    @Test
    void read_studentValid() throws Exception{

        StudentDTO student = StudentsDtos.getStudent4();

        when(studentService.read(student.getId())).thenReturn(student);

        ResultMatcher expertedStatus = status().isOk();
        Long studentId = student.getId();
        MediaType contentType = MediaType.APPLICATION_JSON;
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(contentType);

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/"+studentId)
                        .contentType(contentType))
                .andExpect(expectedContentType)
                .andExpect(expertedStatus)
                .andDo(print())
                .andReturn();

        String actualJson = mvcResult.getResponse().getContentAsString();
        String expectedJson = objectMapper.writeValueAsString(student);
        Assertions.assertEquals(expectedJson, actualJson, "La respuesta JSON no coincide con la esperada.");
    }

    @Test
    void remove_isValidStudent_CorrectWay() throws Exception {
        mockMvc.perform(delete("/student/removeStudent/{id}", 1L))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    void remove_isValidStudent() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}", 1L))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void listStudent() throws Exception {
        // Crear estudiantes únicos
        StudentDTO student4 = StudentsDtos.getStudent4();
        StudentDTO student5 = StudentsDtos.getStudent6();
        Set<StudentDTO> students = Set.of(student4, student5);

        when(studentService.getAll()).thenReturn(students);

        ResultMatcher expertedStatus = status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        String URL = "/student/listStudents";

        MvcResult mvcResult = mockMvc.perform(get(URL))
                .andExpect(expertedStatus)
                .andExpect(expectedContentType)
                .andDo(print())
                .andReturn();

        String actualJson = mvcResult.getResponse().getContentAsString();
        String expectedJson = objectMapper.writeValueAsString(students);
        Assertions.assertEquals(expectedJson, actualJson, "La respuesta JSON no coincide con la esperada.");
    }
}

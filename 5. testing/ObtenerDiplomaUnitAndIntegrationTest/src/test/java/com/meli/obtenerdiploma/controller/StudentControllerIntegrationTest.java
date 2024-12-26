package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.StudentsDtos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

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
    }

    @Test
    void read_studentValid() throws Exception{
        //ARRANGE
        StudentDTO student = StudentsDtos.getStudent4();
        Long studentId = student.getId();

        ResultMatcher expertedStatus = status().isOk();
        MediaType contentType = MediaType.APPLICATION_JSON;
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(contentType);

        // ACT & ASSERT
        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/"+studentId)
                        .contentType(contentType))
                .andExpect(expectedContentType)
                .andExpect(expertedStatus)
                .andDo(print())
                .andReturn();
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
        ResultMatcher expertedStatus = status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        String URL = "/student/listStudents";

        mockMvc.perform(get(URL))
                .andExpect(expertedStatus)
                .andExpect(expectedContentType)
                .andDo(print())
                .andReturn();
    }

}

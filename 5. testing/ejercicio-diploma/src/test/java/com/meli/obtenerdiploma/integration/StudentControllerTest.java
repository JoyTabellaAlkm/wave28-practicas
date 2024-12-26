package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void listAllStudents() throws Exception {
        StudentDTO student = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));

        StudentDTO student2 = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)
                ));

        List<StudentDTO> list = List.of(student, student2);

        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(list));
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");


        mockMvc.perform(get("/student/listStudents"))
                .andExpect(expectedBody)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andDo(print());

    }
}

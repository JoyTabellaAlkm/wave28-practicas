package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class IntegrationTestIStudentController {
    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    StudentDTO student1 = new StudentDTO(4L, "Pedro", null, null, Arrays.asList(
            new SubjectDTO("Math", 7.0),
            new SubjectDTO("Science", 8.0)
    )) ;

    @Test
    public void crearEstudiante() throws Exception {
        ResultMatcher expectedStatus = status().isOk();

        String body = mapper.writeValueAsString(student1);

        mockMvc.perform(post("/student/registerStudent/").contentType(MediaType.APPLICATION_JSON).content(body)).
                andExpect(expectedStatus).
                andDo(print());
    }

    @Test
    public void eliminarEstudiante() throws Exception {
        ResultMatcher expectedStatus = status().isNoContent();
        Long idEstudiante = 1L;

        mockMvc.perform(delete("/student/removeStudent/"+idEstudiante)).
                andExpect(expectedStatus).
                andDo(print());
    }

}

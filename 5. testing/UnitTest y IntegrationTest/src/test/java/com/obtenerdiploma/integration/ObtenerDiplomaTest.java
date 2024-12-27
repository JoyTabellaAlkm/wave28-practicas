package com.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.obtenerdiploma.dto.StudentDTO;
import com.obtenerdiploma.dto.SubjectDTO;
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
public class ObtenerDiplomaTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final StudentDTO student1 = new StudentDTO ( 1, "hola", List.of(
            new SubjectDTO("Matemática", 9D),
            new SubjectDTO("Física", 7D),
            new SubjectDTO("Química", 6D))
    );

    @Test
    void obtenerDiploma () throws Exception {
        ResultMatcher status = status().isOk();
        ResultMatcher contentType = content().contentType("application/json");
        ResultMatcher bodyContent = content().json(objectMapper.writeValueAsString(student1));

        String nombreDeBusqueda = "Juan";

        mockMvc.perform(get("/students/{studentName}", nombreDeBusqueda))
                .andExpect(status)
                .andExpect(contentType)
                .andExpect(bodyContent)
                .andDo(print());
    }


}

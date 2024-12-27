package com.meli.obtenerdiploma.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.websocket.OnMessage;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Analiza puntaje de estudiante de id 1 con tres materias")
    public void analizaPuntajeDeEstudianteConTresMaterias() throws Exception {
        int parametro = 1;
        StudentDTO student = new StudentDTO(1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                (7.0 + 9.0 + 6.0)/3,
                List.of(
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Química", 6.0)
    ));

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(student));

        mockMvc.perform(get("/analyzeScores/{studentId}", parametro))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }
}

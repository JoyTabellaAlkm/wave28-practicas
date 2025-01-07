package com.meli.obtenerdiploma.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.DecimalFormat;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ObtenerDiplomaController.class)
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    private static final StudentDTO student1Complete = new StudentDTO(1L, "Juan",
            "El alumno " + "Juan" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format((9+7+6)/3.0)
                    + ". Puedes mejorar.", (9+7+6)/3.0,
            List.of(
                    new SubjectDTO("Matemática", 9.0),
                    new SubjectDTO("Física", 7.0),
                    new SubjectDTO("Química", 6.0)
            ));

    private static final StudentDTO student2Complete = new StudentDTO(2L, "Pedro",
            "El alumno " + "Pedro" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format((10+8+9.5)/3.0)
                    + ". Felicitaciones!", (10+8+9.5)/3.0,
            List.of(
                    new SubjectDTO("Matemática", 10.0),
                    new SubjectDTO("Física", 8.0),
                    new SubjectDTO("Química", 9.5)
            ));

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScores() throws Exception {
        //ARRANGE
        Long studentId = 1L;
        StudentDTO studentExpected = student1Complete;
        Mockito.when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(student1Complete);

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(studentExpected));

        //ACT & ASSERT
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(statusExpected)
                .andDo(print());

    }


}

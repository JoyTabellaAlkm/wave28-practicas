package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    ObtenerDiplomaController controller;

    private static final ObjectMapper oMapper = new ObjectMapper();
    private static final StudentDTO expectedStudent1 = new StudentDTO(
            Long.parseLong("1"),
            "Juan",
                    "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                    7.333333333333333,
                    List.of(new SubjectDTO(
                    "Matemática",
                            9.0
    ), new SubjectDTO(
                        "Física",
                                7.0
    ), new SubjectDTO(
                        "Química",
                                6.0
    )
            )
                    );


    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @Test
    @DisplayName("analyzeScores")
    public void analyzeScoresTestOK() throws Exception {

        //ARRANGE
        int parametroEntrada = 1;

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(oMapper.writeValueAsString(expectedStudent1));

        //ACT & ASSERT
        mockMvc.perform(get("/analyzeScores/{studentId}", parametroEntrada))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }



}

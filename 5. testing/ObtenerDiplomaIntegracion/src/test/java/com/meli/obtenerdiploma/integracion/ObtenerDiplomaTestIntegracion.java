package com.meli.obtenerdiploma.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaTestIntegracion {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObtenerDiplomaService obtenerDiplomaService;

    @Autowired
    StudentDAO studentDAO;

    @PostConstruct
    public void setup() {
        StudentDTO student = new StudentDTO(1L, "Mariano", null, null,
                new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Lengua", 7.0),
                        new SubjectDTO("Química", 6.0))));
        studentDAO.save(student);
        obtenerDiplomaService.analyzeScores(1L);
    }

    @Test
    public void obtenerDiplomaTestIntegracion() throws Exception{
        StudentDTO esperado = new StudentDTO(1L,"Mariano","El alumno Mariano ha obtenido un promedio de 7,33. Puedes mejorar.", 7.333333333333333,
                new ArrayList<>(List.of(new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Lengua",7.0),
                        new SubjectDTO("Química",6.0))));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonEsperado = objectMapper.writeValueAsString(esperado);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(jsonEsperado))
                .andReturn();
    }

    @Test
    public void testStudentNotFound() throws Exception {
        Long studentId = 9999L;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andExpect(status().isNotFound());
    }

}

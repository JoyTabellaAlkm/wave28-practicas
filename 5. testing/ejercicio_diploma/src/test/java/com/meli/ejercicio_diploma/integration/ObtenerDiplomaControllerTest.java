package com.meli.ejercicio_diploma.integrationTest;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.ejercicio_diploma.model.StudentDTO;
import com.meli.ejercicio_diploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    static SubjectDTO matematica;
    static SubjectDTO fisica;
    static SubjectDTO quimica;

    static StudentDTO student;

    @BeforeAll
    public static void beforeAll() {
        matematica = new SubjectDTO("Matematica", 10.0);
        fisica = new SubjectDTO("Fisica", 9.0);
        quimica = new SubjectDTO("Quimica",    8.0);

        student =new StudentDTO(1L, "Juan","El alumno Juan ha obtenido un promedio de 9,00. " +
                "Felicitaciones!", 9.0, List.of() );

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/test/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"studentName\": \"Juan\",\n" +
                "    \"message\": \"El alumno Juan ha obtenido un promedio de 9,00. Felicitaciones!\",\n" +
                "    \"averageScore\": 9.0,\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matematica\",\n" +
                "        \"score\": 10.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Fisica\",\n" +
                "        \"score\": 9.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Quimica\",\n" +
                "        \"score\": 8.0\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");
        writer.close();
    }

    @Test
    public void testAnalyzeScoresFunnyPath() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.averageScore").value(9.0))
                .andExpect(jsonPath("$.subjects.length()").value(3))
                .andExpect(jsonPath("$.subjects[?(@.name == \""+matematica.getName()+"\"  && @.score == "+matematica.getScore()+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+fisica.getName()+"\"  && @.score == "+fisica.getScore()+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+quimica.getName()   +"\"  && @.score == "+quimica.getScore()+")]").exists())
        ;
    }

    @Test
    void testAnalyzeScoresThrowStudentNotFoundException() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 22))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

}

package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestObtenerDiploma {
    @Autowired
    MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;

    SubjectDTO ingles = new SubjectDTO("Ingles", 10.0);
    SubjectDTO quimica = new SubjectDTO("Quimica", 3.0);
    SubjectDTO fisica = new SubjectDTO("Fisica", 5.0);
    StudentDTO student = new StudentDTO(1L,
            "Anibal",
            "El alumno Anibal ha obtenido un promedio de 6. Puedes mejorar.",
            6.0,
            List.of(fisica, ingles, quimica));

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void beforEach() {
        if (!studentDAO.exists(student))
            studentDAO.save(student);
    }

    @Test
    public void testGivenValidUserIdGetDiplomaWithAverangeScore() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Anibal"))
                .andExpect(jsonPath("$.averageScore").value(6.0))
                .andExpect(jsonPath("$.subjects.length()").value(3))
                .andExpect(jsonPath("$.subjects[?(@.name == \"" + ingles.getName() + "\"  && @.score == " + ingles.getScore() + ")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \"" + fisica.getName() + "\"  && @.score == " + fisica.getScore() + ")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \"" + quimica.getName() + "\"  && @.score == " + quimica.getScore() + ")]").exists());
    }

    @Test
    void analyzeScoresTest() throws Exception {
        // arrange
        String userJson = writer.writeValueAsString(student);
        System.out.println(userJson);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/analyzeScores/{studentId}",
                1);

        // assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedContentType)
                .andExpect(expectedJson)
                .andExpect(expectedStatus);
    }

    @Test
    void testGivenAnInvalidStudentIdThrowExceptionMessage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 22))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    void testRegisterStudent() throws Exception {
        // arrange
        String studentJson = writer.writeValueAsString(student);

        // act y assert
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isOk());
    }
}

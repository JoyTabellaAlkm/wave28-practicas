package com.meli.obtenerdiploma.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){

    }


    private static final StudentDTO studentDTO1 = new StudentDTO(1L, "Juan", null, null, List.of(
            new SubjectDTO("Matemática", 9D),
            new SubjectDTO("Física", 7D))
    );

    private static final StudentDTO studentDTO2 = new StudentDTO(2L, "Pedro",null, null, List.of(
            new SubjectDTO("Matemática", 10D),
            new SubjectDTO("Física", 8D),
            new SubjectDTO("Química", 4D))
    );
    private static final StudentDTO studentDTO3 = new StudentDTO(3L, "Pedro",null,null, List.of(
            new SubjectDTO("Matemática", 5D),
            new SubjectDTO("Física", 3D),
            new SubjectDTO("Historia", 4D))
    );

    @Test
    public void testGetStudentById() throws Exception{
        //arrange
        Long id = 1L;

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(studentDTO1));

        //act & assert
        mockMvc.perform(get("/student/getStudent/{id}",id))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Test OK - List Students")
    public void testListStudentsOK() throws Exception {
        //ARRANGE
        Set<StudentDTO> studentsEsperado = Set.of(studentDTO1, studentDTO2);
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(studentsEsperado));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Test OK - Register Student")
    public void testRegisterStudentOK() throws Exception {
        //ARRANGE
        ResultMatcher statusEsperado = status().isNoContent();

        // ACT & ASSERT
        mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(studentDTO3)))
                .andExpect(statusEsperado)
                .andDo(print());
    }
}

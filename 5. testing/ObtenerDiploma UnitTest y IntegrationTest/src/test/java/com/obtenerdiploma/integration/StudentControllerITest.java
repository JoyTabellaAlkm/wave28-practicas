package com.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.obtenerdiploma.dto.StudentDTO;
import com.obtenerdiploma.dto.SubjectDTO;
import com.obtenerdiploma.entity.Student;
import com.obtenerdiploma.entity.Subject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerITest {

    @Autowired
    MockMvc mockMvc;

    private static final Student student1 = new Student (1L, "Juan", Set.of(
            new Subject("Matemática", 9D),
            new Subject("Física", 7D),
            new Subject("Química", 6D))
    );

    private static final StudentDTO studentDTO1 = new StudentDTO(1L, "Juan", Set.of(
            new SubjectDTO("Matemática", 9D),
            new SubjectDTO("Física", 7D),
            new SubjectDTO("Química", 6D))
    );

    private static final StudentDTO studentDTO2 = new StudentDTO(2L, "Pedro", Set.of(
            new SubjectDTO("Matemática", 10D),
            new SubjectDTO("Física", 8D),
            new SubjectDTO("Química", 4D))
    );
    private static final Student student2 = new Student (2L, "Pedro", Set.of(
            new Subject("Matemática", 10D),
            new Subject("Física", 8D),
            new Subject("Química", 4D))
    );

    private static final StudentDTO studentDTO3 = new StudentDTO(3L, "Pedro", Set.of(
            new SubjectDTO("Matemática", 5D),
            new SubjectDTO("Física", 3D),
            new SubjectDTO("Historia", 4D))
    );
    private static final StudentDTO studentDTO3Modified = new StudentDTO(3L, "Pablo", Set.of(
            new SubjectDTO("Matemática", 5D),
            new SubjectDTO("Física", 3D),
            new SubjectDTO("Historia", 4D))
    );

    ObjectMapper objectMapper = new ObjectMapper();
            //.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            // Justo esta linea no hace falta porque el Json de prueba esta escrito en camelCase :O
            //.registerModule(new JavaTimeModule());
            // Tampoco hace falta manejar fechas en este ejercicio.


    // CASO GET CON LISTA DE ESTUDIANTES , NO SE USA EL USERS.JSON
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


    // CASO DE POST CON 204 NO CONTENT
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

    @Test
    @DisplayName("Test OK - Student by ID")
    public void testStudentsByIdOK() throws Exception {
        //ARRANGE
        Long idEsperado = 1l;
        StudentDTO studentEsperado = studentDTO1;
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(studentEsperado));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(get("/student/getStudent/{id}",idEsperado))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print()).andReturn();
    }
    @Test
    @DisplayName("Test Bad Request - Student by ID")
    public void testStudentsByIdBadRequest() throws Exception {
        //ARRANGE
        Long idEsperado = 100l;
        ResultMatcher statusEsperado = status().isNotFound();

        // ACT & ASSERT
        mockMvc.perform(get("/student/getStudent/{id}",idEsperado))
                .andExpect(statusEsperado)
                .andDo(print()).andReturn();
    }
    @Test
    @DisplayName("Test OK - Modify Student")
    public void testModifyStudentOK() throws Exception {
        //ARRANGE
        ResultMatcher statusEsperado = status().isNoContent();

        // ACT & ASSERT
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(studentDTO3Modified)))
                .andExpect(statusEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Test OK - Remove Student by ID")
    public void testRemoveStudentsByIdOK() throws Exception {
        //ARRANGE
        Long idEsperado = 1l;
        ResultMatcher statusEsperado = status().isNoContent();

        // ACT & ASSERT
        mockMvc.perform(get("/student/removeStudent/{id}",idEsperado))
                .andExpect(statusEsperado)
                .andDo(print());
    }
    @Test
    @DisplayName("Test BadRequest - Remove Student by ID")
    public void testRemoveStudentsByIdBadRequest() throws Exception {
        //ARRANGE
        Long idEsperado = 100l;
        ResultMatcher statusEsperado = status().isNotFound();

        // ACT & ASSERT
        mockMvc.perform(get("/student/removeStudent/{id}",idEsperado))
                .andExpect(statusEsperado)
                .andDo(print());
    }






}

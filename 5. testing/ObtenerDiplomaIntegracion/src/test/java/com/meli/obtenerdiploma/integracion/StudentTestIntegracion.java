package com.meli.obtenerdiploma.integracion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentTestIntegracion {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    private ObjectMapper objectMapper;


    StudentDTO student1 = new StudentDTO(1L, "Juan", null, null,
            new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0),
                    new SubjectDTO("Física", 7.0),
                    new SubjectDTO("Química", 6.0))));

    StudentDTO student2 = new StudentDTO(2L, "Pedro", null, null,
            new ArrayList<>(List.of(new SubjectDTO("Matemática", 10.0),
                    new SubjectDTO("Física", 8.0),
                    new SubjectDTO("Química", 4.0))));

    @BeforeEach
    public void setup() {
        studentDAO.deleteAll();
        loadInitialData();
    }

    private void loadInitialData() {
        studentDAO.save(student1);
        studentDAO.save(student2);
    }

    @Test
    public void registerStudentTest() throws Exception{
        StudentDTO student = new StudentDTO(3L, "Mariano", "mensaje", 7.0,
                new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Lengua", 7.0),
                        new SubjectDTO("Química", 6.0))));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    public void registerStudentBadParams() throws Exception{
        StudentDTO studentDTO = new StudentDTO();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DirtiesContext
    public void getStudentTest() throws Exception{
        Long id = 1L;

        String jsonEsperado = objectMapper.writeValueAsString(student1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(jsonEsperado))
                .andReturn();
    }

    @Test
    public void getStudentNotFoundTest() throws Exception{
        Long id = 50000L;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void removeStudentTest() throws Exception{

        Long id = 2L;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
        .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    public void removeStudentNotFound() throws Exception{
        Long id = 0L;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
        .andExpect(status().isNotFound());
    }

    @Test
    public void removeStudentBadParms() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", "id"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DirtiesContext
    public void listStudentsTest() throws Exception {
        Set<StudentDTO> students = new HashSet<>();
        students.add(student1);
        students.add(student2);

        String esperado = objectMapper.writeValueAsString(students);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(esperado))
                .andExpect(status().isOk())
                .andReturn();
    }

}

package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    ObjectMapper mapper = new ObjectMapper();
    StudentDAO studentRepository = new StudentDAO();

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Trae al estudiante de id 1.")
    public void getStudentOk() throws Exception {
        //Arrange
        StudentDTO stuSpected = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );

        ResultMatcher statusSpected = status().isOk();
        ResultMatcher contentTypeSpected = content().contentType("application/json");
        ResultMatcher bodySpected = content().json(mapper.writeValueAsString(stuSpected));

        //Act + Assert
        mockMvc.perform(get("/student/getStudent/{id}", stuSpected.getId()))
                .andExpect(statusSpected)
                .andExpect(contentTypeSpected)
                .andExpect(bodySpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Intenta traer un estudiante con id inexistente.")
    public void getStudentNotFoundException() throws Exception {
        // Arrange
        long idParam = studentRepository.getStudents().size() + 1;
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id " + idParam + " no se encuetra registrado.");

        ResultMatcher statusSpected = status().isNotFound();
        ResultMatcher contentTypeSpected = content().contentType("application/json");
        ResultMatcher bodySpected = content().json(mapper.writeValueAsString(errorDTO));

        // Act + Assert
        mockMvc.perform(get("/student/getStudent/{id}", idParam))
                .andExpect(statusSpected)
                .andExpect(contentTypeSpected)
                .andExpect(bodySpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Agregar un nuevo estudiante.")
    void registerStudentOk() throws Exception{
        //Arrange
        StudentDTO stuSpected = new StudentDTO(
                (long) studentRepository.getStudents().size() + 1,
                "Roberto",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 8.0)
                )
        );

        ResultMatcher statusSpected = status().isCreated();
        ResultMatcher contentTypeSpected = content().contentType("application/json");
        ResultMatcher bodySpected = content().json(mapper.writeValueAsString(stuSpected));

        //Act + Assert
        mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(stuSpected)))
                .andExpect(statusSpected)
                .andExpect(contentTypeSpected)
                .andExpect(bodySpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Error al agregar un estudiante. Falta el nombre.")
    void registerStudentErrorNoName() throws Exception{
        //Arrange
        StudentDTO stuSpected = new StudentDTO(
                (long) studentRepository.getStudents().size() + 1,
                null,
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 8.0)
                )
        );
        ErrorDTO errorDTO = new ErrorDTO("MethodArgumentNotValidException", "El nombre del estudiante no puede estar vacío.");

        ResultMatcher statusSpected = status().isBadRequest();
        ResultMatcher contentTypeSpected = content().contentType("application/json");
        ResultMatcher bodySpected = content().json(mapper.writeValueAsString(errorDTO));

        //Act + Assert
        mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(stuSpected)))
                .andExpect(statusSpected)
                .andExpect(contentTypeSpected)
                .andExpect(bodySpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Modificar los datos del estudiante id 2.")
    void modifyStudent() throws Exception{
        StudentDTO stuSpected = new StudentDTO(
                3L,
                "Federico",
                null,
                null,
                List.of(
                        new SubjectDTO("Física", 6.0),
                        new SubjectDTO("Química", 9.0)
                )
        );
        ResultMatcher statusSpected = status().isOk();
        ResultMatcher contentTypeSpected = content().contentType("application/json");
        ResultMatcher bodySpected = content().json(mapper.writeValueAsString(stuSpected));

        //Act + Assert
        mockMvc.perform(post("/student/modifyStudent")
                    .contentType("application/json")
                    .content(mapper.writeValueAsString(stuSpected)))
                .andExpect(statusSpected)
                .andExpect(contentTypeSpected)
                .andExpect(bodySpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Error al modificar un estudiante. No contiene materias.")
    public void modifyStudentErrorNoSubjects() throws Exception {
        StudentDTO stuSpected = new StudentDTO(
                1L,
                "Federico",
                null,
                null,
                new ArrayList<>()
        );
        ErrorDTO errorDTO = new ErrorDTO("MethodArgumentNotValidException", "La lista de materias no puede estar vacía.");

        ResultMatcher statusSpected = status().isBadRequest();
        ResultMatcher contentTypeSpected = content().contentType("application/json");
        ResultMatcher bodySpected = content().json(mapper.writeValueAsString(errorDTO));

        //Act + Assert
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(stuSpected)))
                .andExpect(statusSpected)
                .andExpect(contentTypeSpected)
                .andExpect(bodySpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Eliminar el último estudiante de la lista.")
    void removeStudentOk() throws Exception{
        //Arrange
        long idParam = studentRepository.getStudents().size();

        ResultMatcher statusSpected = status().isOk();
        ResultMatcher contentTypeSpected = content().contentType("application/json");
        ResultMatcher bodySpected = content().string("true");

        //Act + Assert
        mockMvc.perform(get("/student/removeStudent/{id}", idParam))
                .andExpect(statusSpected)
                .andExpect(contentTypeSpected)
                .andExpect(bodySpected)
                .andDo(print());
    }

    @Test
    @DisplayName("Eliminar un estudiante inexistente.")
    void removeStudentErrorNotExists() throws Exception{
        //Arrange
        long idParam = studentRepository.getStudents().size() + 1;

        ResultMatcher statusSpected = status().isOk();
        ResultMatcher contentTypeSpected = content().contentType("application/json");
        ResultMatcher bodySpected = content().string("false");

        //Act + Assert
        mockMvc.perform(get("/student/removeStudent/{id}", idParam))
                .andExpect(statusSpected)
                .andExpect(contentTypeSpected)
                .andExpect(bodySpected)
                .andDo(print());
    }

    @Test
    void listStudents() throws Exception {
        //Arrange
        List<StudentDTO> listStudents = new ArrayList<>();

        StudentDTO stuRoberto = new StudentDTO(
                4L,
                "Roberto",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 8.0)
                )
        );
        StudentDTO stuPedro = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)
                        )
        );
        StudentDTO stuJuan = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        StudentDTO stuFederico = new StudentDTO(
                3L,
                "Federico",
                null,
                null,
                List.of(
                        new SubjectDTO("Física", 6.0),
                        new SubjectDTO("Química", 9.0)
                )
        );
        listStudents.add(stuRoberto);
        listStudents.add(stuPedro);
        listStudents.add(stuJuan);
        listStudents.add(stuFederico);

        ResultMatcher statusSpected = status().isOk();
        ResultMatcher contentTypeSpected = content().contentType("application/json");
        ResultMatcher bodySpected = content().json(mapper.writeValueAsString(listStudents));

        //Act + Assert
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(statusSpected)
                .andExpect(contentTypeSpected)
                .andExpect(bodySpected)
                .andDo(print());
    }
}

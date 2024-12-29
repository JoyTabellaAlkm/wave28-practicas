package com.mercadolibre.obtener_diploma.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.obtener_diploma.model.StudentDTO;
import com.mercadolibre.obtener_diploma.model.SubjectDTO;
import com.mercadolibre.obtener_diploma.service.IStudentService;
import com.mercadolibre.obtener_diploma.util.TestUtilsGenerator;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void registerStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.registerStudent(stu);

        // assert
        verify(service, atLeastOnce()).create(stu);
    }

    @Test
    @DisplayName("Debe registar el estudiante")
    public void registrarEstudiante() throws Exception {
        // ARRANGE
        StudentDTO request = new StudentDTO();
        request.setStudentName("Andrés");
        request.setSubjects(List.of(new SubjectDTO("Historia", 4.5), new SubjectDTO("Matemáticas", 10.0)));

        ResultMatcher statusEsperado = status().isOk();

        // ACT & ASSERT
        mockMvc.perform(post("/student/registerStudent").contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(statusEsperado)
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.read(stu.getId())).thenReturn(stu);

        // act
        StudentDTO readStu = controller.getStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    @DisplayName("Debe retornar el estudiante con el id 1")
    public void consultarEstudianteExistente() throws Exception {
        // ARRANGE
        long studentId = 1;
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        MvcResult result = mockMvc.perform(get("/student/getStudent/" + studentId))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andDo(print())
                .andReturn();

        StudentDTO response = objectMapper.readValue(result.getResponse().getContentAsString(), StudentDTO.class);
        assertNotNull(response);
        assertEquals(response.getId(), studentId);
    }

    @Test
    @DisplayName("Debe lanzar un NotFound al intentar consultar el estudiante con el id 100")
    public void consultarEstudianteNoExistente() throws Exception {
        // ARRANGE
        long studentId = 100;
        ResultMatcher statusEsperado = status().isNotFound();

        // ACT & ASSERT
        mockMvc.perform(get("/student/getStudent/" + studentId))
                .andExpect(statusEsperado)
                .andDo(print())
                .andReturn();
    }

    @Test
    public void modifyStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.modifyStudent(stu);

        // assert
        verify(service, atLeastOnce()).update(stu);
    }

    @Test
    @DisplayName("Debe modificar los datos del estudiante con el id 1")
    public void modificarEstudianteExistente() throws Exception {
        // ARRANGE
        StudentDTO request = new StudentDTO();
        request.setId(1L);
        request.setStudentName("Juan");
        request.setSubjects(List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 9.0)));

        ResultMatcher statusEsperado = status().isOk();

        // ACT & ASSERT
        mockMvc.perform(post("/student/modifyStudent").contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(statusEsperado)
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("Debe lanzar un NotFound al intentar modificar el estudiante con el id 100")
    public void modificarEstudianteNoExistente() throws Exception {
        // ARRANGE
        StudentDTO request = new StudentDTO();
        request.setId(100L);
        request.setStudentName("Pepito");
        request.setSubjects(List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 9.0)));

        ResultMatcher statusEsperado = status().isNotFound();

        // ACT & ASSERT
        mockMvc.perform(post("/student/modifyStudent").contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(statusEsperado)
                .andDo(print())
                .andReturn();
    }

    @Test
    public void removeStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.removeStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).delete(stu.getId());
    }

    @Test
    @DisplayName("Debe eliminar el estudiante con el id 1")
    public void eliminarEstudianteExistente() throws Exception {
        // ARRANGE
        long studentId = 1;
        ResultMatcher statusEsperado = status().isOk();

        // ACT & ASSERT
        mockMvc.perform(get("/student/removeStudent/" + studentId))
                .andExpect(statusEsperado)
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("Debe lanzar un NotFound al intentar eliminar el estudiante con el id 100")
    public void eliminarEstudianteNoExistente() throws Exception {
        // ARRANGE
        long studentId = 100;
        ResultMatcher statusEsperado = status().isNotFound();

        // ACT & ASSERT
        mockMvc.perform(get("/student/removeStudent/" + studentId))
                .andExpect(statusEsperado)
                .andDo(print())
                .andReturn();
    }

    @Test
    public void listStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(service.getAll()).thenReturn(students);

        // act
        Set<StudentDTO> readStudents = controller.listStudents();

        // assert
        verify(service, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }

    @Test
    @DisplayName("Debe listar los estudiantes registrados")
    public void listarEstudiantes() throws Exception {
        // ARRANGE
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        MvcResult result = mockMvc.perform(get("/student/listStudents"))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andDo(print())
                .andReturn();

        Set<StudentDTO> response = objectMapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<Set<StudentDTO>>() {
                });

        assertNotEquals(0, response.size());
    }
}

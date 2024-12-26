package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ObtenerDiplomaServiceTest {
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores() {
        StudentDTO studentDTO = new StudentDTO("Nombre","Mensaje",1.0, List.of(new SubjectDTO("Subject",1.0)));
        StudentDTO addedStudent = obtenerDiplomaService.analyzeScores(studentDTO);
        assertNotNull(addedStudent);
        assertEquals(studentDTO.getMessage(),addedStudent.getMessage());
        assertEquals(studentDTO.getAverageScore(),addedStudent.getAverageScore());
    }

    @Test
    void addStudent() {
        StudentDTO studentDTO = new StudentDTO("Nombre","Mensaje",1.0, List.of(new SubjectDTO("Subject",1.0)));
        StudentDTO addedStudent = obtenerDiplomaService.addStudent(studentDTO);
        assertNotNull(addedStudent.getStudentName());
        assertEquals(studentDTO.getStudentName(),addedStudent.getStudentName());
        assertEquals(studentDTO.getSubjects(),addedStudent.getSubjects());
    }

    @Test
    void getNameRqParam() {
        StudentDTO studentDTO = new StudentDTO("Andres","Mensaje",1.0, List.of(new SubjectDTO("Subject",1.0)));
        StudentDTO addedStudent = obtenerDiplomaService.addStudent(studentDTO);
        addedStudent = obtenerDiplomaService.analyzeScores(addedStudent);

        StudentDTO student = obtenerDiplomaService.getNameRqParam("Andres");
        assertNotNull(student.getMessage());
        assertEquals(studentDTO.getStudentName(),student.getStudentName());
        assertEquals(studentDTO.getAverageScore(),student.getAverageScore());
    }
    @Test
    void getNameRqParamThrowsError() {
        StudentDTO studentDTO = new StudentDTO("Andres","Mensaje",1.0, List.of(new SubjectDTO("Subject",1.0)));
        StudentDTO addedStudent = obtenerDiplomaService.addStudent(studentDTO);
        addedStudent = obtenerDiplomaService.analyzeScores(addedStudent);
        assertThrows(IllegalArgumentException.class,() -> obtenerDiplomaService.getNameRqParam("Mauricio"));
    }

    @Test
    void getName() {
        StudentDTO studentDTO = new StudentDTO("Andres","Mensaje",1.0, List.of(new SubjectDTO("Subject",1.0)));
        StudentDTO addedStudent = obtenerDiplomaService.addStudent(studentDTO);
        addedStudent = obtenerDiplomaService.analyzeScores(addedStudent);

        StudentDTO student = obtenerDiplomaService.getName("Andres");
        assertNotNull(student.getMessage());
        assertEquals(studentDTO.getStudentName(),student.getStudentName());
        assertEquals(studentDTO.getAverageScore(),student.getAverageScore());
    }
    @Test
    void getNameThrowsError() {
        StudentDTO studentDTO = new StudentDTO("Andres","Mensaje",1.0, List.of(new SubjectDTO("Subject",1.0)));
        StudentDTO addedStudent = obtenerDiplomaService.addStudent(studentDTO);
        addedStudent = obtenerDiplomaService.analyzeScores(addedStudent);
        assertThrows(IllegalArgumentException.class,() -> obtenerDiplomaService.getName("Mauricio"));

    }
}
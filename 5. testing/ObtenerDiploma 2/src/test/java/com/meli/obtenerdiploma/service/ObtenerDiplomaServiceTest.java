package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @Test
    public void analyzeScoresAvgStudentWithOneSubject(){
        SubjectDTO subject = new SubjectDTO("Math", 9.0);
        StudentDTO expectedStudent = new StudentDTO(1L, "Juan", null, null, List.of(subject));
        Mockito.when(studentDAO.findById(1L)).thenReturn(expectedStudent);
        double expectedAvgScore = 9.0;

        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);

        Assertions.assertEquals(expectedAvgScore, student.getAverageScore());
    }

    @Test
    public void analyzeScoresAvgStudentWithoutSubjects(){
        StudentDTO expectedStudent = new StudentDTO(1L, "Juan", null, null, List.of());
        Mockito.when(studentDAO.findById(1L)).thenReturn(expectedStudent);
        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);

        Assertions.assertTrue(student.getAverageScore().isNaN());
    }

    @Test
    public void analyzeScoresMsgStudentScoreLowerThan9(){
        SubjectDTO subject = new SubjectDTO("Math", 9.0);
        StudentDTO expectedStudent = new StudentDTO(1L, "Juan", null, null, List.of(subject));
        Mockito.when(studentDAO.findById(1L)).thenReturn(expectedStudent);
        String expectedMessage = "El alumno Juan ha obtenido un promedio de 9. Puedes mejorar.";

        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);

        Assertions.assertEquals(expectedMessage, student.getMessage());
    }

    @Test
    public void analyzeScoresMsgStudentScoreHigherThan9(){
        SubjectDTO subject = new SubjectDTO("Math", 9.4);
        StudentDTO expectedStudent = new StudentDTO(1L, "Juan", null, null, List.of(subject));
        Mockito.when(studentDAO.findById(1L)).thenReturn(expectedStudent);
        String expectedMessage = "El alumno Juan ha obtenido un promedio de 9,4. Felicitaciones!";

        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);


        Assertions.assertEquals(expectedMessage, student.getMessage());
    }

    @Test
    public void analyzeScoresThrowExceptionWhenStudentNotFound() {
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenThrow(new StudentNotFoundException(1L));

        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            obtenerDiplomaService.analyzeScores(1L);
        });
    }
}
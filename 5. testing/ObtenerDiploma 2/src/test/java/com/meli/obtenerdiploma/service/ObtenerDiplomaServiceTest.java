package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import java.text.DecimalFormat;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresForExistingStudent() {
        // Arrange
        Long studentId = 1L;
        Double expectedAverageScore = 10.0;
        String studentName = "Pepe";
        SubjectDTO firstSubject = new SubjectDTO("Inglés", 10.0);
        SubjectDTO secondSubject = new SubjectDTO("Matemática", 10.0);
        List<SubjectDTO> studentSubjects = List.of(firstSubject, secondSubject);
        StudentDTO studentDTOExpected = new StudentDTO(studentId, studentName, getGreetingMessage(studentName, expectedAverageScore ), expectedAverageScore, studentSubjects);

        // Act
        Mockito.when(studentDAO.findById(studentId)).thenReturn(
                new StudentDTO(studentId, studentName, "", 0.0, studentSubjects)
        );

        StudentDTO studentObtained = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        Assertions.assertEquals(studentDTOExpected, studentObtained);
    }

    @Test
    public void analyzeScoresForNonExistingStudent() {
        Long nonExistentId = 101L;

        Mockito.when(studentDAO.findById(nonExistentId)).thenThrow(new StudentNotFoundException(nonExistentId));

        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(nonExistentId));
    }
    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }
}

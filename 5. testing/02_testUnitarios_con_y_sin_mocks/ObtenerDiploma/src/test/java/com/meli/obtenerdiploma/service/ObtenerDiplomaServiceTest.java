package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Validación de promedio bajo y leyenda del diploma")
    void analyzeLowScore() {

        //ARRANGE
        long studentId = 2L;
        Double expectedAvg= 7.333333333333333;
        String expectedMessage = "Puedes mejorar";
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0));

        StudentDTO student = new StudentDTO(2L, "test", null, null, subjects);

        //ACT
        Mockito.when(studentDAO.findById(studentId)).thenReturn(student);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //ASSERT
        Assertions.assertNotNull(result);
        Assertions.assertEquals(studentId, result.getId());
        Assertions.assertEquals(expectedAvg, result.getAverageScore());
        Assertions.assertTrue(result.getMessage().contains(expectedMessage));
    }

    @Test
    @DisplayName("Validación de promedio alto y leyenda del diploma")
    void analyzeHighScore() {

        //ARRANGE
        long studentId = 4L;
        Double expectedAvg= 9.333333333333334;
        String expectedMessage = "Felicitaciones";
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 9.0),
                new SubjectDTO("Química", 9.0));

        StudentDTO student = new StudentDTO(4L, "test", null, null, subjects);

        //ACT
        Mockito.when(studentDAO.findById(studentId)).thenReturn(student);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //ASSERT
        Assertions.assertNotNull(result);
        Assertions.assertEquals(studentId, result.getId());
        Assertions.assertEquals(expectedAvg, result.getAverageScore());
        Assertions.assertTrue(result.getMessage().contains(expectedMessage));
    }
}
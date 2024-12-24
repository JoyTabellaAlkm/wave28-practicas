package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScores() {
        // Arrange

        // Excpected student
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.00));
        subjects.add(new SubjectDTO("Física", 7.00));
        subjects.add(new SubjectDTO("Química", 6.00));

        Long id = 1L;
        StudentDTO expected = new StudentDTO();
        expected.setStudentName("Juan");
        expected.setId(id);
        expected.setSubjects(subjects);
        expected.setMessage("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.");
        expected.setAverageScore(7.333333333333333);

        // Mocked student
        List<SubjectDTO> subjectsMock = new ArrayList<>();
        subjectsMock.add(new SubjectDTO("Matemática", 9.00));
        subjectsMock.add(new SubjectDTO("Física", 7.00));
        subjectsMock.add(new SubjectDTO("Química", 6.00));

        Long idMock = 1L;
        StudentDTO studentMock = new StudentDTO();
        studentMock.setStudentName("Juan");
        studentMock.setId(id);
        studentMock.setSubjects(subjectsMock);

        // Act
        Mockito.when(studentDAO.findById(idMock)).thenReturn(studentMock);
        StudentDTO obtained =  obtenerDiplomaService.analyzeScores(id);

        // Assert
        Assertions.assertEquals(expected, obtained);
    }
}

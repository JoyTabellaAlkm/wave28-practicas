package com.mercadolibre.obtener_diploma.obtener_diploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.obtener_diploma.obtener_diploma.model.StudentDTO;
import com.mercadolibre.obtener_diploma.obtener_diploma.model.SubjectDTO;
import com.mercadolibre.obtener_diploma.obtener_diploma.repository.IStudentDAO;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    IObtenerDiplomaService obtenerDiplomaService = new ObtenerDiplomaService();

    Set<StudentDTO> mockStudents = initialize();

    @Test
    public void analyzeScoresUnsuccesful() {
        // 1. arrange
        long id = 1;
        StudentDTO mockStudent = mockStudents.stream()
                .filter(s -> s.getId() == 1)
                .findFirst()
                .orElse(null);

        when(studentDAO.findById(id)).thenReturn(mockStudent);

        // 2. act
        StudentDTO res = obtenerDiplomaService.analyzeScores(id);

        // 3. assert
        assertEquals(res.getAverageScore(), (10 + 5 + 9.5) / 3);
        assertEquals(res.getMessage(), "El alumno Andrés ha obtenido un promedio de 8,17. Puedes mejorar.");
    }

    @Test
    public void analyzeScoresSuccessful() {
        // 1. arrange
        long id = 2;
        StudentDTO mockStudent = mockStudents.stream()
                .filter(s -> s.getId() == 2)
                .findFirst()
                .orElse(null);

        when(studentDAO.findById(id)).thenReturn(mockStudent);

        // 2. act
        StudentDTO res = obtenerDiplomaService.analyzeScores(id);

        // 3. assert
        assertEquals(res.getAverageScore(), (10 + 10 + 9.5) / 3);
        assertEquals(res.getMessage(), "El alumno Leonardo ha obtenido un promedio de 9,83. Felicitaciones!");
    }

    public static Set<StudentDTO> initialize() {
        List<SubjectDTO> subjects1 = List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Historia", 5.0),
                new SubjectDTO("Geografía", 9.5));

        StudentDTO newStudent1 = new StudentDTO();
        newStudent1.setId(1L);
        newStudent1.setStudentName("Andrés");
        newStudent1.setSubjects(subjects1);

        List<SubjectDTO> subjects2 = List.of(new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Historia", 10.0),
                new SubjectDTO("Geografía", 9.5));

        StudentDTO newStudent2 = new StudentDTO();
        newStudent2.setId(2L);
        newStudent2.setStudentName("Leonardo");
        newStudent2.setSubjects(subjects2);

        return Set.of(newStudent1, newStudent2);
    }

}

package com.mercadolibre.testing.obtener_diploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mercadolibre.testing.obtener_diploma.model.StudentDTO;
import com.mercadolibre.testing.obtener_diploma.model.SubjectDTO;

public class ObtenerDiplomaServiceTests {

    IObtenerDiplomaService service = new ObtenerDiplomaService();

    @Test
    public void analyzeScores() {
        // 1. arrange
        StudentDTO req = new StudentDTO();
        req.setStudentName("Andrés");
        req.setSubjects(List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Historia", 5.0),
                new SubjectDTO("Geografía", 9.5)));

        // 2. act
        StudentDTO res = service.analyzeScores(req);

        // 3. assert
        assertEquals(res.getAverageScore(), (10 + 5 + 9.5) / 3);
        assertEquals(res.getMessage(), "El alumno Andrés ha obtenido un promedio de 8,17. Puedes mejorar.");
    }

    @Test
    public void analyzeScoresSuccessful() {
        // 1. arrange
        StudentDTO req = new StudentDTO();
        req.setStudentName("Andrés");
        req.setSubjects(List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Historia", 10.0),
                new SubjectDTO("Geografía", 9.5)));

        // 2. act
        StudentDTO res = service.analyzeScores(req);

        // 3. assert
        assertEquals(res.getAverageScore(), (10 + 10 + 9.5) / 3);
        assertEquals(res.getMessage(), "El alumno Andrés ha obtenido un promedio de 9,83. Felicitaciones!");
    }

}

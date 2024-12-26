package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Validacion Datos de Salida idénticos a datos de Entrada.")
    public void testAnalyzeScores() {
        // Arrange
        StudentDTO studentEsperado = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.33, List.of(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));

        // Act
        Mockito.when(studentDAO.findById(studentEsperado.getId())).thenReturn(studentEsperado);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentEsperado.getId());

        //Assert
        assertNotNull(result);
        assertEquals(studentEsperado, result);
    }

    @Test
    @DisplayName("Validacion Mensaje de Diploma con Honores.")
    public void testAnalyzeScoresWithHonors() {
        // Arrange
        StudentDTO studentEsperado = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 9.5. Felicitaciones!", 9.5, List.of(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Física", 9.0)));
        // Act
        Mockito.when(studentDAO.findById(studentEsperado.getId())).thenReturn(studentEsperado);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentEsperado.getId());

        //Assert
        assertNotNull(result);
        assertEquals(studentEsperado, result);
    }

    @Test
    @DisplayName("Validacion Cálculo del Promedio.")
    public void testCalculateAverage() {
        // Arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
        // Act
        Double result = obtenerDiplomaService.calculateAverage(subjects);

        //Assert
        assertEquals(7.33, Math.round(result * 100.0) / 100.0);
    }

    @Test
    @DisplayName("Validacion Mensaje de Saludo.")
    public void testGetGreetingMessage() {
        // Arrange
        String studentName = "Juan";
        Double average = 7.33;
        // Act
        String result = obtenerDiplomaService.getGreetingMessage(studentName, average);

        //Assert
        assertEquals("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", result);
    }

}

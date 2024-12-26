package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.NotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;
    private StudentDTO studentDTO;
    private StudentDTO bestStudentDTO;
    private StudentDTO notValidStudentDTO;

    @BeforeEach
    public void setStudentDTO() {
        studentDTO = new StudentDTO(1L,
                "Dummy User",
                "",
                0.0,
                new ArrayList<>(){
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 8.93));
                        add(new SubjectDTO("Química", 9.0));
                    }
                }
        );

        bestStudentDTO = new StudentDTO(1L,
                "Dummy User",
                "",
                0.0,
                new ArrayList<>(){
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 10.0));
                        add(new SubjectDTO("Química", 10.0));
                    }
                }
        );

        notValidStudentDTO = new StudentDTO(1L,
                "Dummy User",
                "",
                0.0,
                new ArrayList<>()
        );
    }

    @Test
    @DisplayName("Se debe devolver el studentDAO esperado")
    void analyzeScoresShouldReturnCorrectStudentDTO() {
        StudentDTO expectedStudent = bestStudentDTO;

        when(studentDAO.findById(1L)).thenReturn(expectedStudent);
        StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(1L);
        System.out.println(currentStudent.toString());

        verify(studentDAO, atLeastOnce()).findById(1L);
        assertEquals(expectedStudent, currentStudent);
    }

    @Test
    @DisplayName("Se debe calcular el promedio correctamente")
    void analyzeScoresShouldCalculateCorrectAverage() {
        StudentDTO expectedStudent = studentDTO;
        double expectedAverage = 8.98;

        when(studentDAO.findById(1L)).thenReturn(expectedStudent);
        StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(1L);
        Double currentAverage = currentStudent.getAverageScore();

        verify(studentDAO, atLeastOnce()).findById(1L);
        assertEquals(expectedAverage, currentAverage, 0.0034);
    }

    @Test
    @DisplayName("Se debe retornar la leyenda de diploma correcta")
    void analyzeScoresShouldReturnTheCorrectMessage() {
        StudentDTO expectedStudent = studentDTO;
        String expectedMessage = "El alumno Dummy User ha obtenido un promedio de 8,98. Puedes mejorar.";

        when(studentDAO.findById(1L)).thenReturn(expectedStudent);
        StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(1L);
        String currentMessage = currentStudent.getMessage();

        verify(studentDAO, atLeastOnce()).findById(1L);
        assertEquals(expectedMessage, currentMessage);
    }

    @Test
    @DisplayName("Se debe devolver el mensaje de diploma con honores si el promedio es igual o superior a 9")
    void shouldReturnCongratsMessageIfAverageIsHigherOrEqualsNine() {
        StudentDTO expectedStudent = bestStudentDTO;
        String expectedMessage = "El alumno Dummy User ha obtenido un promedio de 9,67. Felicitaciones!";
        double expectedAverage = 9.67;

        when(studentDAO.findById(1L)).thenReturn(expectedStudent);
        StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(1L);
        String currentMessage = currentStudent.getMessage();
        double currentAverage = currentStudent.getAverageScore();

        verify(studentDAO, atLeastOnce()).findById(1L);
        assertEquals(expectedMessage, currentMessage);
        assertEquals(expectedAverage, currentAverage, 0.02);
    }

    @Test
    @DisplayName("Se debe lanzar una NotFoundException si el alumno no tiene lista de materias cuando se calcula el promedio")
    void shouldThrowNotFoundExceptionIfStudentDoesNotHaveASubjectsList() {
        StudentDTO expectedStudent = notValidStudentDTO;
        when(studentDAO.findById(1L)).thenReturn(expectedStudent);

        assertThrows(NotFoundException.class, () -> {
            obtenerDiplomaService.analyzeScores(expectedStudent.getId());
        });
    }
}
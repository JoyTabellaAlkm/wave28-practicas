package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.utils.StudentsDtos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("-Datos validos- Verifica el calculo correcto del promedio y el mensaje de felicitaciones")
    public void analyzeScores_WithValidStudent_ReturnsExpectedResults(){
        //Arrange
        Long studentId = 1L;

        List<SubjectDTO> subjects = List.of(
                    new SubjectDTO("Math", 9.0),
                    new SubjectDTO("English", 8.5),
                    new SubjectDTO("Science", 10.0)
                );

        StudentDTO student = new StudentDTO(studentId, "Pepe", null, null,  subjects );

        when(studentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertNotNull(result);
        assertEquals("Pepe", result.getStudentName());
        assertEquals(9.166666666666666, result.getAverageScore());
        assertTrue(result.getMessage().contains("Felicitaciones"));
    }

    @Test
    @DisplayName("-Datos validos- Verifica se genere un mensaje motivacional cuando el promedio es bajo")
    public void analyzeScores_WithLowAverage_ReturnsMotivationMessage(){
        //Arrage
        StudentDTO student = StudentsDtos.getStudent10();
        when(studentDAO.findById(student.getId())).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(student.getId());

        //Assert
        assertNotNull(result);
        assertEquals(9.2, result.getAverageScore());
        assertEquals("Sofia", result.getStudentName());
        assertTrue(result.getMessage().contains("Felicitaciones!"));
    }
}

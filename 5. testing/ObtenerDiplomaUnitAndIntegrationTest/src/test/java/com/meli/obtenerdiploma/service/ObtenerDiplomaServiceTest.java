package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
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

    @DisplayName("-Datos validos- Verifica el calculo correcto del promedio y el mensaje de felicitaciones")
    @Test
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

    @DisplayName("-Datos validos- Verifica se genere un mensaje motivacional cuando el promedio es bajo")
    @Test
    public void analyzeScores_WithLowAverage_ReturnsMotivationMessage(){
        //Arrage
        Long studentID = 2L;

        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Math", 5.5),
                new SubjectDTO("English", 5.5),
                new SubjectDTO("Science", 5.5)
                );
        StudentDTO student = new StudentDTO(studentID, "Pepe", null, null, subjects);

        when(studentDAO.findById(studentID)).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentID);

        //Assert
        assertNotNull(result);
        assertEquals(5.5, result.getAverageScore());
        assertEquals("Pepe", result.getStudentName());
        assertTrue(result.getMessage().contains("Puedes mejorar"));
    }

/*    @Test
    void analyzeScores_WithNullStudent_ThrowsExceptions(){
        //Arrage
        Long studentId = 3L;
        StudentDTO student = new StudentDTO(studentId, "Pepe", "Empty List Of subject", null, Collections.emptyList());
        when(studentDAO.findById(studentId)).thenReturn(null);

        //Art && Assert
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(studentId));
    }*/


}

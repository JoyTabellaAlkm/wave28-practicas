package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analyze the score whit correct data")
    void testAnalyzeScoresWhenTheDataIsCorrectShouldReturnAStudentDto() {
        //Arrange
        long id = 1L;
        String expectedName = "Carlos";
        double expectedScore = 4.5;
        StudentDTO studentMock = new StudentDTO(
                id,
                "Carlos",
                "",
                0.0,
                Arrays.asList(
                        new SubjectDTO("Matemáticas", 9.0),
                        new SubjectDTO("Física", 0.0)
                )
        );
        when(studentDAO.findById(anyLong())).thenReturn(studentMock);

        //Act
        StudentDTO studentDTO = obtenerDiplomaService.analyzeScores(id);

        //Assert
        assertNotNull(studentDTO);
        assertEquals(expectedName, studentDTO.getStudentName());
        assertEquals(expectedScore, studentDTO.getAverageScore());
        verify(studentDAO, times(1)).findById(anyLong());
    }
}
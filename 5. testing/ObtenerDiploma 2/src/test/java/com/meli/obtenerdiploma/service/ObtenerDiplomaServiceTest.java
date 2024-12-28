package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores() {
        // Arrange
        Long id = 1L;
        List<SubjectDTO> subjectDTOList = List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("Literature", 10.0));
        StudentDTO studentDTO = new StudentDTO(1L, "George Rusell", "", 0.0, subjectDTOList);
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        // Act
        StudentDTO responseStudentDTO = obtenerDiplomaService.analyzeScores(id);
        // Assert
        assertNotNull(responseStudentDTO);
        assertEquals(9.0, responseStudentDTO.getAverageScore());
        assertFalse(responseStudentDTO.getMessage().isEmpty());
    }
}
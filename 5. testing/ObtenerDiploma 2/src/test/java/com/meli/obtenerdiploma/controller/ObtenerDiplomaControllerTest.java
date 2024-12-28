package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    void analyzeScores() {
        // Arrange
        StudentDTO expectedStudentDTO = new StudentDTO(1L,
                "George",
                "lorem",
                7.5,
                new ArrayList<>());
        when(service.analyzeScores(1L)).thenReturn(expectedStudentDTO);
        // Act
        StudentDTO returnedStudentDTO = controller.analyzeScores(1L);
        // Assert
        verify(service, times(1)).analyzeScores(1L);
        assertEquals(expectedStudentDTO, returnedStudentDTO);
    }
}
package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.factory.StudentFactory;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScores() {
        //Arrange
        StudentDTO studentDTO = StudentFactory.createStudent();
        long id = studentDTO.getId();
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(studentDTO);

        //Act
        StudentDTO analyzedStudent = obtenerDiplomaController.analyzeScores(id);

        //Assert
        assertNotNull(analyzedStudent);
        assertEquals(studentDTO.getStudentName(), analyzedStudent.getStudentName());
        verify(obtenerDiplomaService, times(1)).analyzeScores(anyLong());
    }
}
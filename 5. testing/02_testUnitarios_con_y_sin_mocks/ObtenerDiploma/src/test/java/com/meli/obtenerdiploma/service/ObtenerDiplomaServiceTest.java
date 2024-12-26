package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores() {

        //ARRANGE
        long studentId = 1L;
        Double expectedAvg= 7.33;

        //ACT
        StudentDTO resutl = obtenerDiplomaService.analyzeScores(studentId);

        //ASSERT

        Mockito.when(studentDAO.findById(studentId)).thenReturn(resutl);

        Assertions.assertEquals(expectedAvg, resutl.getAverageScore());
    }
}
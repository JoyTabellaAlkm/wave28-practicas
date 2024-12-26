package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO studentDTO;

    @BeforeEach
    public void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setStudentName("John Doe");
    }

    @Test
    public void analyzeScoresValidStudent(){
        //arrange
        Long studentId = 4L;
        studentDTO.setSubjects(Arrays.asList(
                new SubjectDTO("Math", 10.0),
                new SubjectDTO("Science", 8.0)
        ));
        Mockito.when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        Double esperado = 9.0;
        //act
        StudentDTO obtenido = obtenerDiplomaService.analyzeScores(studentId);

        //assert
        Assertions.assertEquals(esperado,obtenido.getAverageScore());
    }

    @Test
    public void analyzeScoresStudentWithNoSubjects(){
        //arrange
        Long studentId = 4L;
        studentDTO.setSubjects(Collections.emptyList());
        Mockito.when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        Double esperado = 0.0;

        //act
        StudentDTO obtenido = obtenerDiplomaService.analyzeScores(studentId);
        //assert
        Assertions.assertEquals(esperado,obtenido.getAverageScore().byteValue());
    }

    @Test
    public void analyzeScoresStudentNullId(){
        //arrange
        Long studentId = null;
        //act & assert
        Assertions.assertThrows(NullPointerException.class,
                ()->obtenerDiplomaService.analyzeScores(studentId));
    }

}

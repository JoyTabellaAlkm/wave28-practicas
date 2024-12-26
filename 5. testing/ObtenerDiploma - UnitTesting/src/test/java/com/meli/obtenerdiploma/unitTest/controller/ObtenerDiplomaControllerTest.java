package com.meli.obtenerdiploma.unitTest.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    StudentDTO testStudent = new StudentDTO(
            Long.parseLong("1"),
            "Juan",
            null,
            null,
            List.of(new SubjectDTO(
                            "Matemática",
                            9.0
                    ), new SubjectDTO(
                            "Física",
                            7.0
                    ), new SubjectDTO(
                            "Química",
                            6.0
                    )
            )
    );

    @Test
    @DisplayName("1.1: AnalyzeScore Ok")
    public void analyzeScoreOK(){
        //ARRANGE
        StudentDTO expectedStudent = testStudent;
        Long testId = 1L;
        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(expectedStudent);
        //ACT
        StudentDTO receivedStudent = obtenerDiplomaController.analyzeScores(testId);
        //ASSERT
        Mockito.verify(obtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(1L);
        Assertions.assertEquals(receivedStudent, expectedStudent);
    }

    //ToDo: consultar a joy, como se supone que testee el funcionamiento de las funciones, si una depende de otra, pero no se accede a esta debido a usar mocks?
    @Test
    @DisplayName("1.2: AnalyzeScore NotFound")
    public void analyzeScoreNotFound(){
        //ARRANGE
        Long testId = 10L;
        Mockito.when(obtenerDiplomaService.analyzeScores(10L)).thenThrow(StudentNotFoundException.class);
        //ASSERT
        Assertions.assertThrows
            (
                StudentNotFoundException.class,
                () -> {obtenerDiplomaService.analyzeScores(testId);}
            );
    }



}

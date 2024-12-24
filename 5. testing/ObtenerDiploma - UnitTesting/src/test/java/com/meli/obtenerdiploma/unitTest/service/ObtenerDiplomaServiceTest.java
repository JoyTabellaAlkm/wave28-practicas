package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    StudentDTO belowAverageStudent = new StudentDTO(
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

    StudentDTO aboveAverageStudent = new StudentDTO(
            Long.parseLong("2"),
            "Clonan",
            null,
            null,
            List.of(new SubjectDTO(
                            "Matemática",
                            9.2
                    ), new SubjectDTO(
                            "Física",
                            9.1
                    ), new SubjectDTO(
                            "Química",
                            9.4
                    )
            )
    );





    //ToDo: Casos nulos, vacios e invalidos para cuando se use "analyzeScores", "getGreetingMessage", y "calculateAverage"
    //ToDo: Datos de salida identicos a datos de entrada, a que se refiere

    @Test
    @DisplayName("Test 1.1: AnalyzeScores OK (Gives proper number)")
    public void analyzeScoresAverageOK(){
        //ARRANGE
        StudentDTO toAnalyze = belowAverageStudent;
        when(studentDAO.findById(toAnalyze.getId())).thenReturn(toAnalyze);//This is used inside the service

        //ACT
        StudentDTO receivedResults = obtenerDiplomaService.analyzeScores(toAnalyze.getId());

        //ASSERT
        verify(studentDAO, atLeastOnce()).findById(toAnalyze.getId()); //This verifies that the mock was called once during the test
        Assertions.assertEquals(7.33, receivedResults.getAverageScore());

    }

    @Test
    @DisplayName("Test 2.1: AnalyzeScores OK (Gives proper message AVG 9+)")
    public void analyzeScoresMessage9Up(){
        //ARRANGE
        StudentDTO toAnalyze = aboveAverageStudent;
        String expectedMessage =
                "El alumno " + toAnalyze.getStudentName() +
                " ha obtenido un promedio de 9.23. Felicitaciones!";
        when(studentDAO.findById(toAnalyze.getId())).thenReturn(toAnalyze);

        //ACT
        StudentDTO receivedResult = obtenerDiplomaService.analyzeScores(toAnalyze.getId());

        //ASSERT
        verify(studentDAO, atLeastOnce()).findById(toAnalyze.getId()); //This verifies that the mock was called once during the test
        Assertions.assertEquals(receivedResult.getMessage(), expectedMessage);
    }

    @Test
    @DisplayName("Test 2.2: AnalyzeScores OK (Gives proper message AVG -9)")
    public void analyzeScoresMessage9Down(){
        //ARRANGE
        StudentDTO toAnalyze = belowAverageStudent;
        String expectedMessage =
                "El alumno " + toAnalyze.getStudentName() +
                " ha obtenido un promedio de 7.33. Puedes mejorar.";
        when(studentDAO.findById(toAnalyze.getId())).thenReturn(toAnalyze);

        //ACT
        StudentDTO receivedResult = obtenerDiplomaService.analyzeScores(toAnalyze.getId());

        //ASSERT
        verify(studentDAO, atLeastOnce()).findById(toAnalyze.getId()); //This verifies that the mock was called once during the test
        Assertions.assertEquals(receivedResult.getMessage(), expectedMessage);
    }

    //ToDo: consultar a Joy por los casos border (ie: relacionados a validaciones)

}

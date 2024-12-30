package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    private static final StudentDTO student1 = new StudentDTO(1L, "Juan", null, null,
            List.of(
                    new SubjectDTO("Matemática", 9.0),
                    new SubjectDTO("Física", 7.0),
                    new SubjectDTO("Química", 6.0)
            ));

    private static final StudentDTO student1Complete = new StudentDTO(1L, "Juan",
            "El alumno " + "Juan" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format((9+7+6)/3.0)
                    + ". Puedes mejorar.", (9+7+6)/3.0,
            List.of(
                    new SubjectDTO("Matemática", 9.0),
                    new SubjectDTO("Física", 7.0),
                    new SubjectDTO("Química", 6.0)
            ));

    private static final StudentDTO student2 = new StudentDTO(2L, "Pedro", null, null,
            List.of(
                    new SubjectDTO("Matemática", 10.0),
                    new SubjectDTO("Física", 8.0),
                    new SubjectDTO("Química", 9.5)
            ));

    private static final StudentDTO student2Complete = new StudentDTO(2L, "Pedro",
            "El alumno " + "Pedro" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format((10+8+9.5)/3.0)
                    + ". Felicitaciones!", (10+8+9.5)/3.0,
            List.of(
                    new SubjectDTO("Matemática", 10.0),
                    new SubjectDTO("Física", 8.0),
                    new SubjectDTO("Química", 9.5)
            ));



    @Test
    void analyzeScoresBadAverage(){
        //ARRANGE
        Long studentId = 1L;
        StudentDTO student = student1;
        StudentDTO studentExpected = student1Complete;
        Mockito.when(studentDAO.findById(studentId)).thenReturn(student);

        //ACT
        StudentDTO studentObtained = obtenerDiplomaService.analyzeScores(studentId);

        //ASSERT
        Assertions.assertEquals(studentObtained,studentExpected,"Los alumnos no son iguales");
    };

    @Test
    void analyzeScoresGoodAverage(){
        //ARRANGE
        Long studentId = 2L;
        StudentDTO student = student2;
        StudentDTO studentExpected = student2Complete;
        Mockito.when(studentDAO.findById(studentId)).thenReturn(student);

        //ACT
        StudentDTO studentObtained = obtenerDiplomaService.analyzeScores(studentId);

        //ASSERT
        Assertions.assertEquals(studentObtained,studentExpected,"Los alumnos no son iguales");
    };

    @Test
    void analyzeScoresFail(){
        //ARRANGE
        Long studentId = 3L;
        Mockito.when(studentDAO.findById(studentId))
                .thenThrow(new StudentNotFoundException(studentId));

        String messageExpected = "El alumno con Id " + studentId + " no se encuetra registrado.";

        //ACT & ASSERT
        StudentNotFoundException exception = Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> obtenerDiplomaService.analyzeScores(studentId)
        );

        //ASSERT
        Assertions.assertEquals(messageExpected, exception.getError().getDescription(), "Se encuentra un estudiante inexistente");

    };

}

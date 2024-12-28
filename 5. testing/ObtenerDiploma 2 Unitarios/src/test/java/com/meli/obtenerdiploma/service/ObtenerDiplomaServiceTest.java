package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresTest() {
        Long input = 2L;
        StudentDTO expected = new StudentDTO(2L, "Pedro", "El alumno Pedro ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333, List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)
        ));

        Mockito.when(studentDAO.findById(input)).thenReturn(expected);
        StudentDTO response = obtenerDiplomaService.analyzeScores(input);

        Assertions.assertEquals(response, expected);

    }

    @Test
    void analyzeScoresSadTest() {
        Long input = 0L;

        Mockito.when(studentDAO.findById(input)).thenThrow(new StudentNotFoundException(input));

        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(input));
    }
}
package com.meli.obtenerdiploma.unitTest.conMock;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresTest(){
        StudentDTO esperado = new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", 7.333333333333333,
                new ArrayList<>(List.of(new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química",6.0))));
        Long id = 1L;

        Mockito.when(service.analyzeScores(id)).thenReturn(esperado);

        StudentDTO obtenido = obtenerDiplomaController.analyzeScores(id);

        Assertions.assertEquals(esperado, obtenido);
    }

    @Test
    public void analyzeScoresTestBadPath(){
        StudentDTO esperado = new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", 7.333333333333333,
                new ArrayList<>(List.of(new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química",6.0))));

        StudentDTO estudiante2 = new StudentDTO(2L, "Pedro", null, null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0))));

        Long id = 2L;

        Mockito.when(service.analyzeScores(id)).thenReturn(estudiante2);

        StudentDTO obtenido = obtenerDiplomaController.analyzeScores(id);

        Assertions.assertNotEquals(esperado, obtenido);
    }
}

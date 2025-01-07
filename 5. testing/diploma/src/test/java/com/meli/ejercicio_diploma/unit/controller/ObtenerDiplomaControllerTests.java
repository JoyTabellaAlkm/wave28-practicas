package com.meli.ejercicio_diploma.unit.controller;

import com.meli.ejercicio_diploma.controller.ObtenerDiplomaController;
import com.meli.ejercicio_diploma.model.StudentDTO;
import com.meli.ejercicio_diploma.model.SubjectDTO;
import com.meli.ejercicio_diploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = new StudentDTO(1L,
                "Juan",
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

}

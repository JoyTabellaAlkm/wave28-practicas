package com.meli.obtenerdiploma.unitTest.conMock;

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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void getAnalizedScoreTest(){

        Long id = 1L;
        StudentDTO esperado = new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", 7.333333333333333,
                new ArrayList<>(List.of(new SubjectDTO("Matemática",9.0),
                new SubjectDTO("Física",7.0),
                new SubjectDTO("Química",6.0))));

        Mockito.when(studentDAO.findById(id)).thenReturn(esperado);

        var obtenido = obtenerDiplomaService.analyzeScores(id);

        Assertions.assertEquals(esperado, obtenido);

    }
}

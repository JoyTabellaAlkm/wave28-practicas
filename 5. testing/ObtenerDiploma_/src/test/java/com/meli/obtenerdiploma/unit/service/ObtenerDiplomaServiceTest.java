package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.unit.factory.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService diplomaService;

    @Test
    public void analyzeStudentScoresCanImprove() {
        StudentDTO juanStudentDTO = StudentFactory.createJuanStudentDTO();
        Long juanId = juanStudentDTO.getId();

        Mockito
                .when(studentDAO.findById(juanId))
                .thenReturn(juanStudentDTO);

        StudentDTO student = diplomaService.analyzeScores(juanId);

        Assertions.assertEquals(StudentFactory.juanStudentWithScoresDTO, student);
    }

    @Test
    public void analyzeStudentScoresWithHonors() {
        StudentDTO pedroStudentDTO = StudentFactory.createPedroStudentDTO();
        Long pedroId = pedroStudentDTO.getId();

        Mockito
                .when(studentDAO.findById(pedroId))
                .thenReturn(pedroStudentDTO);

        StudentDTO student = diplomaService.analyzeScores(pedroId);

        Assertions.assertEquals(StudentFactory.pedroStudentWithScoresDTO, student);
    }
}

package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScores() {
        //arrange
        StudentDTO stu = new StudentDTO(1L, "Geraldo", "mensaje1", 4.0,
                List.of(new SubjectDTO("Ciencias", 9.0)));

        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        //act
        obtenerDiplomaService.analyzeScores(stu.getId());
        //assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(9.0, studentDAO.findById(stu.getId()).getAverageScore());
    }

    @Test
    public void analyzeScoresMessage() {
        //arrange
        Long id = 1L;
        StudentDTO stu = new StudentDTO(id, "Geraldo", "mensaje1", 4.0,
                List.of(new SubjectDTO("Ciencias", 9.0)));

        when(studentDAO.findById(id)).thenReturn(stu);

        //act
        obtenerDiplomaService.analyzeScores(id);
        //assert
        verify(studentDAO, atLeastOnce()).findById(id);
        assertEquals("El alumno Geraldo ha obtenido un promedio de 9. Puedes mejorar.", stu.getMessage());
    }

}

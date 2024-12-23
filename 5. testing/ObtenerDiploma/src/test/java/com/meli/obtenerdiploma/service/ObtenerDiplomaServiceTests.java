package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeStudentScoreWithoutSubjects() {
        Long studentId = 100L;
        StudentDTO student = new StudentDTO(studentId, "Tomas", null, null, new ArrayList<>());
        when(studentDAO.findById(studentId))
                .thenReturn(student);
        obtenerDiplomaService.analyzeScores(studentId);
        assertTrue(Double.isNaN(student.getAverageScore()));
        assertEquals("El alumno Tomas ha obtenido un promedio de NaN. Puedes mejorar.", student.getMessage());
    }

    @Test
    void analyzeStudentScoreWithSubjects() {
        Long studentId = 100L;
        SubjectDTO subject = new SubjectDTO("Matematica", 89.2);
        StudentDTO student = new StudentDTO(studentId, "Tomas", null, null, List.of(subject));
        when(studentDAO.findById(studentId)).thenReturn(student);

        obtenerDiplomaService.analyzeScores(studentId);
        assertEquals(subject.getScore(), student.getAverageScore());
        assertEquals("El alumno Tomas ha obtenido un promedio de 89,2. Felicitaciones!", student.getMessage());
    }

    @Test
    void analyzeNonExistingStudentScore() {
        when(studentDAO.findById(Mockito.anyLong())).thenThrow(new StudentNotFoundException(1L));
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(Mockito.anyLong()));
    }

}

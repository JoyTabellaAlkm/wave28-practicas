package com.meli.obtenerdiploma.uniTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void averageScoreWellCalculated() {
        // arrange
        StudentDTO stu = new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 8.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                );
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(7.00, stu.getAverageScore());
    }

    @Test
    public void averageScoreOver9MessageWellWritten() {
        // arrange
        StudentDTO stu = new StudentDTO(9999L,
                "Juan",
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 10.0)
                )
        );
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Juan ha obtenido un promedio de 9,33. Felicitaciones!",
                stu.getMessage());
    }

    @Test
    public void averageScoreBelow9MessageWellWritten() {
        // arrange
        StudentDTO stu = new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                );
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                stu.getMessage());
    }

    @Test
    public void RequestStudentNameMatchesResponseStudentName() {
        // arrange
        StudentDTO stu = new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                );
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("Juan", stu.getStudentName());
    }

    @Test
    public void RequestStudentSubjectListMatchesResponseSubjectList() {
        // arrange
        StudentDTO stu = new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                );
        List<SubjectDTO> initalList = new ArrayList<>();
        stu.getSubjects().stream().forEach((s) -> initalList.add(SerializationUtils.clone(s)));

        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertTrue(CollectionUtils.isEqualCollection(initalList, stu.getSubjects()));
    }
}

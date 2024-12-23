package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void testCalculateAverage() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Math", 1.0),
                new SubjectDTO("English", 10.0),
                new SubjectDTO("Science", 7.0));

        StudentDTO student = new StudentDTO(1L,
                "John Doe",
                "Sample message",
                null,
                subjects);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        assertEquals(6.0, obtenerDiplomaService.analyzeScores(student.getId()).getAverageScore());
    }

    @Test
    public void testCalculateAverageWhenAverageIsPredefined() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Math", 1.0),
                new SubjectDTO("English", 10.0),
                new SubjectDTO("Science", 7.0));

        StudentDTO student = new StudentDTO(1L,
                "John Doe",
                "Sample message",
                1.0,
                subjects);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        assertEquals(6.0, obtenerDiplomaService.analyzeScores(student.getId()).getAverageScore());
    }

    @Test
    void testCalculateAverageWithOneScore() {
        StudentDTO student = new StudentDTO(1L,
                "John Doe",
                "Sample message",
                null,
                List.of(new SubjectDTO("Math", 10.0)));
        when(studentDAO.findById(student.getId())).thenReturn(student);

        assertEquals(10.0, obtenerDiplomaService
                .analyzeScores(student.getId())
                .getAverageScore());
    }

    @Test
    void testCalculateAverageWithZeroScores() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Math", 0.0),
                new SubjectDTO("English", 0.0),
                new SubjectDTO("Science", 0.0));

        StudentDTO student = new StudentDTO(1L,
                "John Doe",
                "Sample message",
                null,
                subjects);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        assertEquals(0.0, obtenerDiplomaService
                .analyzeScores(student.getId())
                .getAverageScore());
    }

    @Test
    void testGreetingMessageWithHonors() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Math", 10.0),
                new SubjectDTO("English", 9.8),
                new SubjectDTO("Science", 9.5));

        StudentDTO student = new StudentDTO(1L,
                "John Doe",
                "Sample message",
                null,
                subjects);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        assertTrue(obtenerDiplomaService
                .analyzeScores(student.getId())
                .getMessage()
                .contains("Felicitaciones!"));
    }

    @Test
    void testGreetingMessageWithoutHonors() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Math", 7.0),
                new SubjectDTO("English", 8.0),
                new SubjectDTO("Science", 6.5));

        StudentDTO student = new StudentDTO(1L,
                "John Doe",
                "Sample message",
                null,
                subjects);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        assertTrue(obtenerDiplomaService
                .analyzeScores(student.getId())
                .getMessage()
                .contains("Puedes mejorar."));
    }

    @Test
    void testMessageExactAverage9() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Math", 9.0),
                new SubjectDTO("English", 9.0),
                new SubjectDTO("Science", 9.0));

        StudentDTO student = new StudentDTO(1L,
                "John Doe",
                "Sample message",
                null,
                subjects);
        when(studentDAO.findById(student.getId())).thenReturn(student);
        StudentDTO result = obtenerDiplomaService.analyzeScores(student.getId());

        assertFalse(result.getMessage().contains("Felicitaciones!"));
    }
}

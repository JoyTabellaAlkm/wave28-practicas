package com.mercadolibre.obtener_diploma.obtener_diploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.obtener_diploma.obtener_diploma.model.StudentDTO;
import com.mercadolibre.obtener_diploma.obtener_diploma.model.SubjectDTO;
import com.mercadolibre.obtener_diploma.obtener_diploma.repository.IStudentDAO;
import com.mercadolibre.obtener_diploma.obtener_diploma.repository.IStudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    IStudentService studentService = new StudentService();

    Set<StudentDTO> mockStudents = initialize();

    @Test
    public void testGetAll() {
        // Arrange
        when(studentRepository.findAll()).thenReturn(mockStudents);

        // Act
        Set<StudentDTO> students = studentService.getAll();

        // Assert
        verify(studentRepository, atLeast(1)).findAll();
        assertIterableEquals(mockStudents, students);
    }

    @Test
    public void testRead() {
        // Arrange
        long id = 1;
        StudentDTO mockStudent = mockStudents.stream()
                .findFirst()
                .orElse(null);

        when(studentDAO.findById(id)).thenReturn(mockStudent);

        // Act
        StudentDTO findedStudent = studentService.read(id);

        // Assert
        verify(studentDAO, atLeast(1)).findById(id);
        assertEquals(findedStudent, mockStudent);
    }

    @Test
    public void testUpdate() {
        // Arrange
        StudentDTO mockStudent = mockStudents.stream()
                .findFirst()
                .orElse(null);

        // Act
        studentService.update(mockStudent);

        // Assert
        verify(studentDAO, atLeast(1)).save(mockStudent);
    }

    @Test
    public void testDelete() {
        // Arrange
        long id = 1;
        when(studentDAO.delete(id)).thenReturn(true);

        // Act
        studentService.delete(id);

        // Assert
        verify(studentDAO, atLeast(1)).delete(id);
    }

    public static Set<StudentDTO> initialize() {
        long id = 1;
        String studentName = "Andrés";
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Historia", 4.5), new SubjectDTO("Inglés", 9.7));

        StudentDTO newStudent = new StudentDTO();
        newStudent.setId(id);
        newStudent.setStudentName(studentName);
        newStudent.setSubjects(subjects);

        return Set.of(newStudent);
    }

}

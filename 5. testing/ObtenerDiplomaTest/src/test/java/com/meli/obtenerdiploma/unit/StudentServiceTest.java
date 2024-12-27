package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    public void create() { // same as update
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Agustin", "", 9.0, null);

        // Act
        doNothing().when(studentDAO).save(student);
        studentService.create(student);
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(student);
    }

    @Test
    public void read() {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Inaki", "", 7.0, null);

        // Act
        Mockito.when(studentDAO.findById(student.getId())).thenReturn(student);
        StudentDTO result = studentService.read(student.getId());

        // Assert
        assertNotNull(result);
        assertEquals(student, result);
        Mockito.verify(studentDAO, Mockito.times(1)).findById(student.getId());
    }

    @Test
    void delete() {
        // Arrange
        Long studentId = 2L;
        // Act
        Mockito.when(studentDAO.delete(studentId)).thenReturn(true);
        studentService.delete(studentId);
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).delete(studentId);
    }

    @Test
    void getAll() {
        // Arrange
        Set<StudentDTO> students = Set.of(
                new StudentDTO(1L, "Inaki", "", 7.0, null),
                new StudentDTO(2L, "Tomas", "", 8.0, null),
                new StudentDTO(3L, "Juan", "", 9.0, null));

        // Act
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        Mockito.verify(studentRepository, Mockito.times(1)).findAll();
        assertNotNull(result);
        assertEquals(3, result.size());

    }
}
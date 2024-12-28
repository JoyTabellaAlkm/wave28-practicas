package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    void create() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(studentDAO).save(studentDTO);
        // Act
        studentService.create(studentDTO);
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(studentDTO);
    }

    @Test
    void read() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L,
                "George",
                "lorem",
                7.5,
                new ArrayList<>());
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        // Act
        StudentDTO obtainedStudent = studentService.read(1L);
        // Assert
        assertEquals(studentDTO, obtainedStudent);
    }

    @Test
    void update() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(studentDAO).save(studentDTO);
        // Act
        studentService.update(studentDTO);
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(studentDTO);

    }

    @Test
    void delete() {
        // Arrange
        Long id = 1L;
        when(studentDAO.delete(id)).thenReturn(true);
        // Act
        studentService.delete(id);
        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).delete(id);
    }

    @Test
    void getAll() {
        // Arrange
        Set<StudentDTO> expected = Set.of(new StudentDTO(), new StudentDTO());
        when(studentRepository.findAll()).thenReturn(expected);
        // Act
        Set<StudentDTO> students = studentService.getAll();
        // Assert
        assertEquals(expected, students);
        assertFalse(students.isEmpty());
    }
}
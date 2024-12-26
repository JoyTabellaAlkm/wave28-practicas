package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    @Test
    void create() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        // Act
        studentService.create(studentDTO);
        // Assert
        //Mockito.verify(studentDAO.save(studentDTO), Mockito.times(1));
    }

    @Test
    void read() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L,
                "George",
                "lorem",
                7.5,
                new ArrayList<>());
        Mockito.when(studentDAO.findById(1L)).thenReturn(studentDTO);
        // Act
        StudentDTO obtainedStudent = studentService.read(1L);
        // Assert
        assertEquals(studentDTO, obtainedStudent);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}
package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.StudentsDtos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_WithValidStudent_ShouldCallServiceCreate() {
        //Arrange
        StudentDTO studentDTO = StudentsDtos.getStudent7();
        doNothing().when(studentDAO).save(studentDTO);

        // Act
        studentService.create(studentDTO);

        // Assert
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    void read_and_update_withValidStudent(){

        StudentDTO studentDTO = StudentsDtos.getStudent1();

        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO student = studentService.read(studentDTO.getId());

        assertNotNull(student);
        assertEquals(studentDTO, student);
        verify(studentDAO, times(1)).findById(studentDTO.getId());
    }

    @Test
    void delete_withValidId_shouldDeleteStudent() {
        // Arrange
        Long studentId = 1L;
        when(studentDAO.delete(studentId)).thenReturn(true);

        // Act
        studentService.delete(studentId);  // Llamamos al method delete del servicio

        // Assert
        verify(studentDAO, times(1)).delete(studentId);  // Verificamos que el method delete fue llamado una vez
    }
}

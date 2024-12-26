package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    IStudentDAO studentDAOMock;
    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    StudentDTO student;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testRead() {
        StudentDTO student = new StudentDTO(1L, "Juan Perez", null, null, Collections.emptyList());

        when(studentDAOMock.findById(1L)).thenReturn(student);

        StudentDTO result = studentService.read(1L);

        assertEquals(student, result);
        verify(studentDAOMock, times(1)).findById(1L);
    }
}

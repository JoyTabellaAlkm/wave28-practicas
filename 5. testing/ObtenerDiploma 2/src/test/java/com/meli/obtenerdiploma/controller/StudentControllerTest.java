package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.factory.StudentFactory;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("List all students")
    void testListStudentsShouldReturnAStudentSet() {
        //Arrange
        Set<StudentDTO> expected = StudentFactory.createStudents(5);
        when(studentService.getAll()).thenReturn(expected);

        //Act
        Set<StudentDTO> result = studentController.listStudents();

        //Assert
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        verify(studentService, times(1)).getAll();
    }
}
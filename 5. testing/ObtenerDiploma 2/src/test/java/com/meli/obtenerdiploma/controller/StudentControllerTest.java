package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L,
                "George",
                "lorem",
                7.5,
                new ArrayList<>());
        Mockito.doNothing().when(studentService).create(studentDTO);
        // Act
        studentController.registerStudent(studentDTO);
        // Assert
        Mockito.verify(studentService, Mockito.times(1)).create(studentDTO);
    }

    @Test
    void getStudent() {
        // Arrange
        StudentDTO expectedStudentDTO = new StudentDTO(1L,
                "George",
                "lorem",
                7.5,
                new ArrayList<>());
        when(studentService.read(1L)).thenReturn(expectedStudentDTO);
        // Act
        StudentDTO returnedStudent = studentController.getStudent(1L);
        // Assert
        assertEquals(expectedStudentDTO, returnedStudent);
    }

    @Test
    void modifyStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L,
                "George",
                "lorem",
                7.5,
                new ArrayList<>());
        Mockito.doNothing().when(studentService).update(studentDTO);
        // Act
        ResponseEntity<?> responseEntity = studentController.modifyStudent(studentDTO);
        // Assert
        verify(studentService, times(1)).update(studentDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void removeStudent() {
        // Arrange
        Long idToBeDeleted = 1L;
        Mockito.doNothing().when(studentService).delete(idToBeDeleted);
        // Act
        ResponseEntity<?> responseEntity = studentController.removeStudent(idToBeDeleted);
        // Assert
        verify(studentService, times(1)).delete(idToBeDeleted);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void listStudents() {
        // Arrange
        Set<StudentDTO> studentDTOSet = Set.of(new StudentDTO(), new StudentDTO());
        when(studentService.getAll()).thenReturn(studentDTOSet);
        // Act
        Set<StudentDTO> returnedStudentDTOSet = studentController.listStudents();
        // Assert
        assertEquals(returnedStudentDTOSet, studentDTOSet);
    }
}
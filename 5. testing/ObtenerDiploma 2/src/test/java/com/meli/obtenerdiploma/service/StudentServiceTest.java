package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.factory.StudentFactory;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
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
class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    @Test
    void create() {
        //Arrange
        StudentDTO studentDTO = StudentFactory.createStudent();
        doNothing().when(studentDAO).save(any(StudentDTO.class));

        //Act
        studentService.create(studentDTO);

        //Assert
        verify(studentDAO, times(1)).save(any(StudentDTO.class));
    }

    @Test
    @DisplayName("Find a student with existing Id")
    void testReadWhenIdExistsShouldReturnAStudentDto() {
        //Arrange
        StudentDTO studentDTO = StudentFactory.createStudent();
        long id = studentDTO.getId();
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        //Act
        StudentDTO studentFound = studentService.read(id);

        //Assert
        assertNotNull(studentFound);
        assertEquals(studentDTO.getStudentName(), studentFound.getStudentName());
        verify(studentDAO, times(1)).findById(anyLong());
    }

    @Test
    @DisplayName("Find a student with non-existent Id")
    void testReadWhenIdDoesNotExistShouldReturnAStudentNotFoundException() {
        //Arrange
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);

        //Act and Assert
        assertThrows(StudentNotFoundException.class, () -> studentService.read(anyLong()));
        verify(studentDAO, times(1)).findById(anyLong());
    }

    @Test
    void update() {
        //Arrange
        StudentDTO studentDTO = StudentFactory.createStudent();
        doNothing().when(studentDAO).save(any(StudentDTO.class));

        //Act
        studentService.create(studentDTO);

        //Assert
        verify(studentDAO, times(1)).save(any(StudentDTO.class));
    }

    @Test
    void delete() {
        //Arrange
        when(studentDAO.delete(anyLong())).thenReturn(true);

        //Act
        studentService.delete(1L);

        //Assert
        verify(studentDAO, times(1)).delete(anyLong());
    }

    @Test
    @DisplayName("Get all students")
    void testGetAllShouldReturnASetOfStudents() {
        //Arrange
        Set<StudentDTO> studentsDTO = StudentFactory.createStudents(5);
        when(studentRepository.findAll()).thenReturn(studentsDTO);

        //Act
        Set<StudentDTO> studentsFound = studentService.getAll();

        //Assert
        assertNotNull(studentsFound);
        assertEquals(studentsDTO.size(), studentsFound.size());
        verify(studentRepository, times(1)).findAll();
    }
}
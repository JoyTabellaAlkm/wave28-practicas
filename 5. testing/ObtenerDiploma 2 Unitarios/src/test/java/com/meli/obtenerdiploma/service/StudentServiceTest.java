package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void createStudentTest() {
        StudentDTO input = new StudentDTO(3L, "Nicolas", "", 4.2,
                new ArrayList<>(List.of(new SubjectDTO("Maths", 5.0))));

        StudentDTO expected = input;

        Mockito.when(studentDAO.save(input)).thenReturn(input);

        Assertions.assertEquals(expected, studentService.create(input));
    }

    @Test
    void readStudentTest() {
        Long input = 1L;
        StudentDTO expected = new StudentDTO(input, "Juan", null, null,
                new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))));

        Mockito.when(studentDAO.findById(input)).thenReturn(expected);
        Assertions.assertEquals(expected, studentService.read(input));
    }

    @Test
    void updateStudentTest() {
        StudentDTO input = new StudentDTO(1L, "Ernesto", null, null,
                new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0))));
        StudentDTO expected = input;

        Mockito.when(studentDAO.save(input)).thenReturn(expected);
        Assertions.assertEquals(expected, studentService.update(input));
    }

    @Test
    void deleteStudentTest() {
        Long input = 2L;
        boolean expected = true;

        Mockito.when(studentDAO.delete(input)).thenReturn(true);

        Assertions.assertEquals(expected, studentService.delete(input));
    }

    @Test
    void getAllStudentTest() {
        Set<StudentDTO> expected = new HashSet<>(List.of(new StudentDTO(1L, "Ernesto", null, null,
                new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0))))));

        Mockito.when(studentRepository.findAll()).thenReturn(expected);

        Assertions.assertEquals(expected, studentService.getAll());
    }
}
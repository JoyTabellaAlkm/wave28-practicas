package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

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

        //ARRANGE
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0));

        StudentDTO student = new StudentDTO(4L, "test", null, null, subjects);

        Mockito.doNothing().when(studentDAO).save(student);
        //ACT
        studentService.create(student);

        //ASSERT

        Mockito.verify(studentDAO, times(1)).save(student);
    }

    @Test
    void read() {
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
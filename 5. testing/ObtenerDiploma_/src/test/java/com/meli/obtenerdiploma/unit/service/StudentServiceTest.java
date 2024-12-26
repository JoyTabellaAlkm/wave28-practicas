package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.unit.factory.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void createStudent() {
        StudentDTO juanStudentDTO = StudentFactory.createJuanStudentDTO();
        Mockito.doNothing().when(studentDAO).save(juanStudentDTO);

        studentService.create(juanStudentDTO);

        Mockito
                .verify(studentDAO, Mockito.times(1))
                .save(juanStudentDTO);
    }

    @Test
    public void readStudent() {
        StudentDTO juanStudentDTO = StudentFactory.createJuanStudentDTO();
        Long juanId = juanStudentDTO.getId();

        Mockito
                .when(studentDAO.findById(juanId))
                .thenReturn(juanStudentDTO);

        StudentDTO student = studentService.read(juanId);

        Mockito
                .verify(studentDAO, Mockito.times(1))
                .findById(juanId);

        Assertions.assertEquals(student, juanStudentDTO);
    }

    @Test
    public void readStudentNotFound() {
        Long nonExistentId = 10L;

        Mockito
                .when(studentDAO.findById(nonExistentId))
                .thenThrow(new StudentNotFoundException(nonExistentId));

        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            studentService.read(nonExistentId);
        });

        Mockito
                .verify(studentDAO, Mockito.times(1))
                .findById(nonExistentId);
    }

    @Test
    public void updateStudent() {
        StudentDTO juanStudentDTO = StudentFactory.juanStudentWithScoresDTO;

        Mockito.doNothing().when(studentDAO).save(juanStudentDTO);

        studentService.update(juanStudentDTO);

        Mockito
                .verify(studentDAO, Mockito.times(1))
                .save(juanStudentDTO);
    }

    @Test
    public void deleteStudent() {
        Long juanStudentId = StudentFactory.createJuanStudentDTO().getId();

        Mockito.when(studentDAO.delete(juanStudentId)).thenReturn(true);

        studentService.delete(juanStudentId);

        Mockito
                .verify(studentDAO, Mockito.times(1))
                .delete(juanStudentId);
    }

    @Test
    public void deleteStudentNotFound() {
        Long nonExistentId = 10L;

        Mockito.when(studentDAO.delete(nonExistentId)).thenReturn(false);

        studentService.delete(nonExistentId);

        Mockito
                .verify(studentDAO, Mockito.times(1))
                .delete(nonExistentId);
    }

    @Test
    public void getAllStudents() {
        StudentDTO juanStudentDTO = StudentFactory.createJuanStudentDTO();
        StudentDTO pedroStudentDTO = StudentFactory.createPedroStudentDTO();

        Set<StudentDTO> expectedStudents = Set.of(juanStudentDTO, pedroStudentDTO);

        Mockito
                .when(studentRepository.findAll())
                .thenReturn(expectedStudents);

        Set<StudentDTO> students = studentService.getAll();

        Mockito
                .verify(studentRepository, Mockito.times(1))
                .findAll();

        Assertions.assertEquals(expectedStudents, students);
    }
}

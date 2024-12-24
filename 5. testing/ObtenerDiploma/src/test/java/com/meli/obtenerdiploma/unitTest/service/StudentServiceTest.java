package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;


    @Test
    public void createStudent() {
        // Arrange

        StudentDTO param = new StudentDTO(30L, "Rogelio",null , null,
                List.of(
                        new SubjectDTO("Matemática", 9.00),
                        new SubjectDTO("Física", 7.00)
                )
        );

        StudentDTO expected = param;

        // Act
        Mockito.when(studentDAO.save(param)).thenReturn(param);
        StudentDTO obtained =  studentService.create(param);

        // Assert
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void getStudentById() {
        // Arrange
        Long studentId = 30L;
        StudentDTO param = new StudentDTO(studentId, "Rogelio",null , null,
                List.of(
                        new SubjectDTO("Matemática", 9.00),
                        new SubjectDTO("Física", 7.00)
                )
        );

        StudentDTO expected = param;

        // Act
        Mockito.when(studentDAO.findById(studentId)).thenReturn(param);
        StudentDTO obtained =  studentService.read(studentId);

        // Assert
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void updateStudent() {
        // Arrange

        StudentDTO param = new StudentDTO(30L, "Rogelio",null , null,
                List.of(
                        new SubjectDTO("Matemática", 9.00),
                        new SubjectDTO("Física", 7.00)
                )
        );

        StudentDTO expected = param;

        // Act
        Mockito.when(studentDAO.save(param)).thenReturn(param);
        StudentDTO obtained =  studentService.update(param);

        // Assert
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void deleteStudent() {
        // Arrange
        Long studentId = 30L;

        // Act
        Mockito.when(studentDAO.delete(studentId)).thenReturn(true);
        boolean obtained =  studentService.delete(studentId);

        // Assert
        Assertions.assertTrue(obtained);
    }

    @Test
    public void getAllStudents() {
        // Arrange

        Set<StudentDTO> responseMock = Set.of(
                new StudentDTO(30L, "Rogelio",null , null,
                        List.of(
                                new SubjectDTO("Matemática", 9.00),
                                new SubjectDTO("Física", 7.00)
                        )
                ),
                new StudentDTO(31L, "Maria",null , null,
                        List.of(
                                new SubjectDTO("Biologia", 10.00),
                                new SubjectDTO("Música", 9.00)
                        )
                )
        );

        Set<StudentDTO> expected = responseMock;

        // Act
        Mockito.when(studentRepository.findAll()).thenReturn(responseMock);
        Set<StudentDTO> obtained =  studentService.getAll();

        // Assert
        Assertions.assertEquals(expected, obtained);
    }

}

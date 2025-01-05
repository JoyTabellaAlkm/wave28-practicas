package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class StudentServiceTest {
    StudentDAO studentRepository = new StudentDAO();

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Agrega un nuevo estudiante.")
    void create() {
        //Arrange
        StudentDTO stuParam = new StudentDTO(
                (long)studentRepository.getStudents().size() +1,
                "Martín",
                "",
                0.0, new ArrayList<>()
        );

        //Act
        Mockito.when(studentDAO.save(stuParam)).thenReturn(stuParam);
        StudentDTO result = studentService.create(stuParam);

        //Assert
        assertEquals(stuParam, result);
    }

    @Test
    @DisplayName("Busca el usuario de id 1.")
    void read() {
        //Arrange
        StudentDTO stuSpected = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );

        //Act
        Mockito.when(studentDAO.findById(stuSpected.getId())).thenReturn(stuSpected);
        StudentDTO result = studentService.read(stuSpected.getId());

        //Assert
        assertEquals(stuSpected, result);
    }

    @Test
    @DisplayName("Actualiza el último estudiante de la lista.")
    void update() {
        //Arrange
        StudentDTO stuSpected = new StudentDTO(
                (long) studentRepository.getStudents().size(),
                "Ricardo",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 7.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 9.0)
                )
        );

        //Act
        Mockito.when(studentDAO.save(stuSpected)).thenReturn(stuSpected);
        StudentDTO result = studentService.update(stuSpected);

        //Assert
        assertEquals(stuSpected, result);
    }

    @Test
    @DisplayName("Borrar el último elemento de la lista.")
    void delete() {
        //Arrange
        long idParam = studentRepository.getStudents().size();

        //Act
        Mockito.when(studentDAO.delete(idParam)).thenReturn(true);
        boolean result = studentService.delete(idParam);

        //Assert
        assertTrue(result);
    }
}

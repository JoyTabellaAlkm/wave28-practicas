package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {
    StudentDAO studentRepository = new StudentDAO();

    @Test
    @DisplayName("Agregar un nuevo estudiante.")
    void saveOk() {
        //Arrange
        StudentDTO stuParam = new StudentDTO(
                (long)studentRepository.getStudents().size()+1,
                "Martín",
                "",
                0.0, new ArrayList<>()
        );

        //Act
        StudentDTO stuResult = studentRepository.save(stuParam);

        //Assert
        assertEquals(stuParam, stuResult);
    }

    @Test
    @DisplayName("Borrar último estudiante de la lista.")
    void deleteOk() {
        //Arrange
        long idParam = studentRepository.getStudents().size();

        //Act
        boolean result = studentRepository.delete(idParam);

        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Eliminar alumno con id inexistente.")
    void deleteFalse(){
        //Arrange
        long idParam = studentRepository.getStudents().size() + 1;

        //Act
        boolean result = studentRepository.delete(idParam);

        //Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Verifica que exista el estudiante de id 1.")
    void exists() {
        //Arrange
        StudentDTO stuParam = new StudentDTO();
        stuParam.setId(1L);

        //Act
        boolean result = studentRepository.exists(stuParam);

        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Verifica si existe un estudiante de id inexistente.")
    void existsStudentNotFoundException(){
        //Arrange
        StudentDTO stuParam = new StudentDTO();
        stuParam.setId((long) studentRepository.getStudents().size() + 1);

        //Act + Assert
        assertThrows(StudentNotFoundException.class, ()->studentRepository.exists(stuParam));
    }

    @Test
    @DisplayName("Trae el alumno de id 1.")
    void findById() {
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
        StudentDTO result = studentRepository.findById(stuSpected.getId());

        //Assert
        assertEquals(stuSpected, result);
    }

    @Test
    @DisplayName("Busca un estudiante de id inexistente.")
    void findByIdStudentNotFoundException(){
        //Arrange
        long idParam = studentRepository.getStudents().size() + 1;

        //Act + Assert
        assertThrows(StudentNotFoundException.class, ()->studentRepository.findById(idParam));
    }
}

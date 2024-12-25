package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    @Autowired
    private IStudentDAO studentDAO;
    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO(null,
                "Dummy User",
                "",
                0.0,
                new ArrayList<>());
    }

    @AfterEach
    void cleanJson() {
        studentDAO.delete(studentDTO.getId());
    }


    @Test
    @DisplayName("Se debe guardar el usuario en el JSON")
    void save() {
        studentDAO.save(studentDTO);
        assertNotNull(studentDTO.getId());
    }

    @Test
    @DisplayName("Se debe actualizar el usuario en el JSON")
    void update() {
        studentDAO.save(studentDTO);
        studentDTO.setMessage("testing");
        studentDAO.save(studentDTO);
        StudentDTO savedStudent = studentDAO.findById(studentDTO.getId());
        assertEquals("testing", savedStudent.getMessage());
    }

    @Test
    @DisplayName("Se debe borrar el usuario del JSON")
    void delete() {
        studentDAO.save(studentDTO);
        boolean deleted = studentDAO.delete(studentDTO.getId());
        assertTrue(deleted);
    }

    @Test
    @DisplayName("No debe poder borrar un usuario inexistente del JSON")
    void deleteNonExistant() {
        boolean deleted = studentDAO.delete(500L);
        assertFalse(deleted);
    }

    @Test
    @DisplayName("Debe devolver true cuando existe el registro")
    void exists() {
        StudentDTO existingStudent = studentDAO.findById(1L);
        boolean exists = studentDAO.exists(existingStudent);
        assertTrue(exists);
    }

    @Test
    @DisplayName("Debe devolver false cuando no existe el registro")
    void notExists() {
        boolean exists = studentDAO.exists(new StudentDTO());
        assertFalse(exists);
    }

    @Test
    @DisplayName("Debe encontrar el usuario 1 en el JSON")
    void findById() {
        StudentDTO foundStudent = studentDAO.findById(1L);
        assertNotNull(foundStudent);
    }

    @Test
    @DisplayName("Debe arrojar la excepción StudentNotFoundException si no encuentra el usuario")
    void findByIdAndThrowError() {
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(1000000L);
        });
    }
}

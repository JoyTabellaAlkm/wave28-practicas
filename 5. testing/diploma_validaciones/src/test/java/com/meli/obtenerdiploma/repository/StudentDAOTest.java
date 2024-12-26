package com.meli.obtenerdiploma.repository;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

    private StudentDAO studentDAO;
    private StudentDTO student;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
        student = new StudentDTO(55L, "Juan Perez", "Mensaje", 85.0, new ArrayList<>());
        studentDAO.save(student);
    }

    @Test
    public void testSaveValidStudent() {
        StudentDTO newStudent = new StudentDTO(2L, "Mateo Lopez", "Mensaje mio", 92.0, new ArrayList<>());
        studentDAO.save(newStudent);
        assertTrue(studentDAO.exists(newStudent));
    }
//  Corregir
    @Test
    public void testSaveStudentWithExistingId() {
        // 1. Agregar un estudiante original con ID 1
        StudentDTO existingStudent = new StudentDTO(1L, "Estudiante Original", "Mensaje", 90.0, new ArrayList<>());
        studentDAO.save(existingStudent); // Guardamos el estudiante original

        // 2. Probar a guardar un nuevo estudiante con el mismo ID
        StudentDTO newStudent = new StudentDTO(1L, "Juanito", "Mensaje", 80.0, new ArrayList<>());
        studentDAO.save(newStudent); // Este debe sobrescribir el existente

        // 3. Verificamos que el nombre fue actualizado
        assertEquals("Juanito", studentDAO.findById(1L).getStudentName());
    }

    @Test
    public void testSaveNullStudent() {
        assertThrows(IllegalArgumentException.class, () -> {
            studentDAO.save(null);
        });
    }



    @Test
    public void testFindByIdNonExistentStudent() {
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(999L);
        });
    }

    @Test
    public void testDeleteExistingStudent() {
        boolean deleted = studentDAO.delete(1L);
        assertTrue(deleted);
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(1L);
        });
    }

    @Test
    public void testDeleteNonExistentStudent() {
        boolean deleted = studentDAO.delete(999L);
        assertFalse(deleted);
    }
}

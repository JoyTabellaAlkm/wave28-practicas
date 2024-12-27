package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    public void testSaveNewStudent() {
        StudentDTO student = new StudentDTO(1L, "John Doe", "Sample message", 85.0, null);
        studentDAO.save(student);
        assertTrue(studentDAO.exists(student));
    }

    @Test
    public void testSaveExistingStudent() {
        StudentDTO student = new StudentDTO(1L, "Jane Doe", "Sample message", 90.0, null);
        studentDAO.save(student);

        StudentDTO updatedStudent = new StudentDTO(student.getId(), "Jane Smith", "Updated message", 95.0, null);
        studentDAO.save(updatedStudent);

        StudentDTO retrievedStudent = studentDAO.findById(updatedStudent.getId());
        assertNotNull(retrievedStudent);
        assertEquals(updatedStudent, retrievedStudent);
    }

    @Test
    public void testDeleteStudent() {
        StudentDTO student = new StudentDTO(1L, "Delete Me", "Message", 75.0, null);
        studentDAO.save(student);
        boolean result = studentDAO.delete(student.getId());
        assertTrue(result);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }

    @Test
    public void testDeleteNonExistentStudent() {
        boolean result = studentDAO.delete(999L);
        assertFalse(result);
    }

    @Test
    public void testFindByIdStudentNotFound() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(999L));
    }
}

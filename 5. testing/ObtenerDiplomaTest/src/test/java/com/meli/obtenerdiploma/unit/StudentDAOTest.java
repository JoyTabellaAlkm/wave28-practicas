package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
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
    public void saveTest(){
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Inaki", "", 7.0,null);
        // Act
        studentDAO.save(student);
        // Assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    public void deleteTest(){
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Inaki", "", 7.0,null);
        studentDAO.save(student);
        // Act
        studentDAO.delete(student.getId());
        // Assert
        assertFalse(studentDAO.exists(student));
    }

    @Test
    public void deleteTestNotFound(){
        // Arrange
        StudentDTO student = new StudentDTO(999L, "Inaki", "", 7.0,null);
        // Act & Assert
        assertFalse(studentDAO.delete(student.getId()));
    }

    @Test
    public void findByIdTest(){
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Inaki", "", 7.0,null);
        studentDAO.save(student);
        // Act
        StudentDTO found = studentDAO.findById(student.getId());
        // Assert
        assertEquals(student, found);
    }

    @Test
    public void findByIdTestNotFound(){
        // Arrange
        StudentDTO student = new StudentDTO(999L, "Inaki", "", 7.0,null);
        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(student.getId()));
    }

    @Test
    public void existsTest(){
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Inaki", "", 7.0,null);
        studentDAO.save(student);
        // Act
        boolean exists = studentDAO.exists(student);
        // Assert
        assertTrue(exists);
    }

    @Test
    public void existsTestNotFound(){
        // Arrange
        StudentDTO student = new StudentDTO(999L, "Inaki", "", 7.0,null);
        // Act
        boolean exists = studentDAO.exists(student);
        // Assert
        assertFalse(exists);
    }
}

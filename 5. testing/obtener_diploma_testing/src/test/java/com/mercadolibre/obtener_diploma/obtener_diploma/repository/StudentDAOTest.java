package com.mercadolibre.obtener_diploma.obtener_diploma.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mercadolibre.obtener_diploma.obtener_diploma.exception.StudentNotFoundException;
import com.mercadolibre.obtener_diploma.obtener_diploma.model.StudentDTO;
import com.mercadolibre.obtener_diploma.obtener_diploma.model.SubjectDTO;

public class StudentDAOTest {

    IStudentDAO studentDAO = new StudentDAO();

    @Test
    public void testExistsWhenUserExists() {
        // Arrange
        long id = 1;
        StudentDTO findStudent = new StudentDTO();
        findStudent.setId(id);

        // Act
        boolean existsStudent = studentDAO.exists(findStudent);

        // Assert
        assertTrue(existsStudent);
    }

    @Test
    public void testExistsWhenUserNotExists() {
        // Arrange
        long id = 1000;
        StudentDTO findStudent = new StudentDTO();
        findStudent.setId(id);

        // Act
        boolean existsUser = studentDAO.exists(findStudent);

        // Assert
        assertFalse(existsUser);
    }

    @Test
    public void testSave() {
        // Arrange
        long id = 3;
        String studentName = "Andrés";
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Historia", 4.5), new SubjectDTO("Inglés", 9.7));

        StudentDTO newStudent = new StudentDTO();
        newStudent.setId(id);
        newStudent.setStudentName(studentName);
        newStudent.setSubjects(subjects);

        // Act
        studentDAO.save(newStudent);

        // Assert
        boolean existsNewStudent = studentDAO.exists(newStudent);
        assertTrue(existsNewStudent);
    }

    @Test
    public void testDeleteWhenUserExists() {
        // Arrange
        long id = 3;

        // Act
        boolean deletedStudent = studentDAO.delete(id);

        // Assert
        assertTrue(deletedStudent);
    }

    @Test
    public void testDeleteWhenUserNotExists() {
        // Arrange
        long id = 1000;

        // Act
        boolean deletedStudent = studentDAO.delete(id);

        // Assert
        assertFalse(deletedStudent);
    }

    @Test
    public void testFindByIdWhenUserExists() {
        // Arrange
        long id = 1;

        // Act
        StudentDTO findedStudent = studentDAO.findById(id);

        // Assert
        assertNotNull(findedStudent);
        assertEquals(Long.valueOf(id), findedStudent.getId());
    }

    @Test
    public void testFindByIdWhenUserNotExists() {
        // Arrange
        long id = 1000;

        // Act
        // Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

}

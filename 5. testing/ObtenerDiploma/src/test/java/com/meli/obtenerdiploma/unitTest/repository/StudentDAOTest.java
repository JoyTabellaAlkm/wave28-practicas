package com.meli.obtenerdiploma.unitTest.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    @Test
    public void createStudent() {
        // Arrange
        String studentsName = "Pepe";

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Fisica", 9.00));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName(studentsName);
        studentDTO.setSubjects(subjects);

        // Act
        StudentDTO student = studentDAO.save(studentDTO);

        // Assert
        Assertions.assertEquals(studentsName, studentDTO.getStudentName());
        Assertions.assertEquals(1, student.getSubjects().size());
    }

    @Test
    public void deleteStudent() {
        // Arrange
        Long studentId = 1L;

        // Act
        boolean studentDeleted = studentDAO.delete(studentId);

        // Assert
        Assertions.assertTrue(studentDeleted);
    }

    @Test
    public void deleteStudentBadPath() {
        // Arrange
        StudentDAO studentDAO = new StudentDAO();

        Long studentId = 10L;

        // Act
        boolean studentDeleted = studentDAO.delete(studentId);

        // Assert
        Assertions.assertFalse(studentDeleted);
    }

    @Test
    public void checkIfStudentExists() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);

        // Act
        boolean studentExists = studentDAO.exists(studentDTO);

        // Assert
        Assertions.assertTrue(studentExists);
    }

    @Test
    public void checkIfStudentExistsBadPath() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(3000L);

        // Act
        boolean studentExists = studentDAO.exists(studentDTO);

        // Assert
        Assertions.assertFalse(studentExists);
    }

    @Test
    public void findById() {
        // Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.00));
        subjects.add(new SubjectDTO("Física", 7.00));
        subjects.add(new SubjectDTO("Química", 6.00));

        Long id = 1L;
        StudentDTO expected = new StudentDTO();
        expected.setStudentName("Juan");
        expected.setId(id);
        expected.setSubjects(subjects);


        // Act
        StudentDTO obtained = studentDAO.findById(id);

        // Assert
        Assertions.assertEquals(expected,obtained);
    }

    @Test
    public void findByIdBadPath() {
        // Arrange
        Long id = 1000L;

        // Act and assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }



}

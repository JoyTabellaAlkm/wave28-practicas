package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StudentRepositoryTest {
    private IStudentDAO studentDAO = new StudentDAO();
    private IStudentRepository studentRepository = new StudentRepository();

    /*
    @Test
    public void addStudent() {
        //Arrange

        //Act

        //Assert
    }
    */

    @Test
    public void findById() {
        //Arrange
        Long id = 1L;

        StudentDTO student = new StudentDTO(id, "Juan", null, null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        //Act
        StudentDTO result = studentDAO.findById(id);

        //Assert
        Assertions.assertEquals(result, student);
    }

    @Test
    public void findByIdNotFound() {
        //Arrange
        Long id = 5L;

        //Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    public void deleteStudent() {
        //Arrange
        Long id = 1L;

        //Act
        boolean result = studentDAO.delete(id);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void deleteNotFoundStudent() {
        //Arrange
        Long id = 5L;

        //Act
        boolean result = studentDAO.delete(id);

        //Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void listStudents() {
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Juan", null, null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));

        StudentDTO student2 = new StudentDTO(2L, "Pedro", null, null,
                List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)));

        Set<StudentDTO> expectedResult = new HashSet<>();
        expectedResult.add(student);
        expectedResult.add(student2);

        //Act
        Set<StudentDTO> result = studentRepository.findAll();

        //Assert
        Assertions.assertEquals(result, expectedResult);
    }
}

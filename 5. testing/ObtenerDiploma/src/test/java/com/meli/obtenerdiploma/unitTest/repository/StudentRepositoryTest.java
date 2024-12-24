package com.meli.obtenerdiploma.unitTest.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {

    @Test
    public void findAllStudentsOk() {
        // Arrange
        StudentRepository studentRepository = new StudentRepository();
        Integer numberOfStudents = 2;

        // Act
        Set<StudentDTO> students = studentRepository.findAll();

        // Assert
        Assertions.assertEquals(numberOfStudents, students.size());
    }
}

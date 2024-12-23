package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepositoru;

    @Test
    public void findAllStudentsTest() {
        // Arrange & Act
        Set<StudentDTO> studentDTOS = studentRepositoru.findAll();
        // Assert
        Assertions.assertNotNull(studentDTOS);
    }
}

package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;

    @Test
    @DisplayName("The list must contain 2 students")
    void findAll() {
        //Arrange
        Set<StudentDTO> studentsDto;
        int sizeExpected = 2;

        //Assert
        studentsDto = studentRepository.findAll();

        //Act
        assertNotNull(studentsDto);
        assertEquals(sizeExpected, studentsDto.size());

    }
}
package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        studentRepository = new StudentRepository();
    }


    @Test
    public void findAllSuccess() {
        //Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        Set<StudentDTO> test = Set.of(new StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0))));
        Set<StudentDTO> result = studentRepository.findAll();


        //Assert
        assertEquals(test, result);
    }
}

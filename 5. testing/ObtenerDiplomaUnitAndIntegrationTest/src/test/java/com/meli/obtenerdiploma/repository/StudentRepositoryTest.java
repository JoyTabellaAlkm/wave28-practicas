package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindAll() {
        Set<StudentDTO> students = studentRepository.findAll();
        assertNotNull(students);
        assertFalse(students.isEmpty());
    }
}

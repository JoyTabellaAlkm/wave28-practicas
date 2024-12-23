package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
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

    @Test
    public void testFindAllEmpty() {
        Set<StudentDTO> students = studentRepository.findAll();

        assertNotNull(students);
        assertTrue(students.isEmpty());
    }
}

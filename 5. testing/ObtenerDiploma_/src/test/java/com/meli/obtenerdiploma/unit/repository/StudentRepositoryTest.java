package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.unit.factory.StudentFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void findAll() {
        Set<StudentDTO> students = Set.of(
                StudentFactory.createJuanStudentDTO(),
                StudentFactory.createPedroStudentDTO()
        );

        Set<StudentDTO> expected = studentRepository.findAll();

        assertEquals(students, expected);
        assertDoesNotThrow(() -> studentRepository.findAll());
    }
}
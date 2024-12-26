package com.meli.obtenerdiploma.unitTest.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;

    @Test
    @DisplayName("La lista debe contener 2 usuarios")
    void findAll() {
        Set<StudentDTO> students = studentRepository.findAll();
        assertEquals(2, students.size());
    }
}

package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class StudentRepositoryTest {

    private final IStudentRepository studentRepository;


    public StudentRepositoryTest(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    @DisplayName("Debe traer todos los usuarios desde la base de datos")
    void findAll() {
        Set<StudentDTO> students = studentRepository.findAll();
        assertEquals(2, students.size());
    }
}

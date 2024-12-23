package com.mercadolibre.obtener_diploma.obtener_diploma.repository;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.mercadolibre.obtener_diploma.obtener_diploma.model.StudentDTO;

public class StudentRepositoryTest {

    // @Autowired
    // IStudentRepository studentRepository;
    IStudentRepository studentRepository = new StudentRepository();

    @Test
    public void testFindAllStudents() {
        // Arrange
        ReflectionTestUtils.setField(studentRepository, "SCOPE", "main");

        // Act
        Set<StudentDTO> students = studentRepository.findAll();

        // Assert
        assertNotEquals(0, students.size());
    }

}

package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    @Test
    void save() {
    }

    @Test
    void delete() {

        // ARRANGE
        Long param = 1L;
        boolean expected = true;

        // ACT
        boolean actual = studentDAO.delete(param);

        // ASSERT
        assertEquals(expected, actual);

    }

    @Test
    void findById() {
        StudentDTO actual = studentDAO.findById(1L);
        assertNotNull(actual);

    }

    @Test
    void findByIdWithException() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(0L));
    }

}
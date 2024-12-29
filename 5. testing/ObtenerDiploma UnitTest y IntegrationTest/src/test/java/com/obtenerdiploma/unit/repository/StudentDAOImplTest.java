package com.obtenerdiploma.unit.repository;

import com.obtenerdiploma.entity.Student;
import com.obtenerdiploma.entity.Subject;
import com.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOImplTest {

    @Autowired
    private IStudentDAO studentDAO;

    private static final Student student1 = new Student (1L, "Juan", Set.of(
            new Subject("Matemática", 9D),
            new Subject("Física", 7D),
            new Subject("Química", 6D))
    );

    private static final Student student2 = new Student (2L, "Pedro", Set.of(
            new Subject("Matemática", 10D),
            new Subject("Física", 8D),
            new Subject("Química", 4D))
    );

    @Test
    void findAll() {
        Set<Student> studentsMock = Set.of(student1,student2);
        Set<Student> studentsResponse = studentDAO.findAll();
        Assertions.assertNotNull(studentsResponse);
        Assertions.assertEquals(studentsMock, studentsResponse);

    }

    @Test
    void save() {
        Student student3 = new Student (3L, "juan", Set.of(
                new Subject("Matemática", 10D),
                new Subject("Física", 8D),
                new Subject("Química", 4D))
        );
        boolean responseMock = true;
        boolean response = studentDAO.save(student3);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response);
        Assertions.assertEquals(response, responseMock);
    }

    @Test
    void delete() {
        Long idMocked = 1L;
        boolean response = studentDAO.delete(idMocked);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response);
        Assertions.assertEquals(response, true);

    }

    @Test
    void findById() {
        Long idMocked = 1L;
        Optional<Student> studentMock = Optional.of(student1);
        Optional<Student> studentResponse = studentDAO.findById(idMocked);

        Assertions.assertEquals(studentResponse, studentMock);

    }

    @Test
    void exists() {
        Long idMocked = 1L;
        boolean expectedResponse = true;
        boolean existResponse = studentDAO.exists(student1);

        Assertions.assertTrue(existResponse);
        Assertions.assertEquals(existResponse, expectedResponse);

    }
}
package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDaoTests {

    @Autowired
    private IStudentDAO studentDAO;

    /*
    StudentDTO findById(Long id);
     */

    @Test
    void saveNewStudent() {
        StudentDTO student = new StudentDTO(null, null, null, null, null);
        studentDAO.save(student);
        assertNotNull(student.getId());
        assertTrue(studentDAO.exists(student));
    }

    @Test
    void saveExistingStudent() {
        StudentDTO student = new StudentDTO();
        studentDAO.save(student);
        Long id = student.getId();
        studentDAO.save(student);
        assertEquals(id, student.getId());
    }

    @Test
    void deleteExistingStudent() {
        StudentDTO student = new StudentDTO();
        studentDAO.save(student);
        assertTrue(studentDAO.delete(student.getId()));
    }

    @Test
    void deleteNonExistingStudent() {
        Long id = 100000L;
        assertFalse(studentDAO.delete(id));
    }

    @Test
    void checkExistentStudentExistence() {
        StudentDTO student = new StudentDTO();
        studentDAO.save(student);

        boolean exists = studentDAO.exists(student);
        assertTrue(exists);
    }

    @Test
    void checkNonExistentStudentExistence() {
        boolean exists = studentDAO.exists(new StudentDTO());
        assertFalse(exists);
    }

    @Test
    void findExistingStudent() {
        StudentDTO student = new StudentDTO();
        studentDAO.save(student);

        StudentDTO found = studentDAO.findById(student.getId());
        assertEquals(student, found);
    }

    @Test
    void tryFindingNonExistingStudent() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(100000L));
    }

    @Test
    void tryFindingNullId() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(null));
    }

}

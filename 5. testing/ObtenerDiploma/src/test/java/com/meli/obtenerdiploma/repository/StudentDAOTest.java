package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    void save() {
        //Arrange
        StudentDTO stu = new StudentDTO(5L, "Nicolas", null, null, List.of(new SubjectDTO("Matematicas", 10.0)
                , new SubjectDTO("Español", 7.5)));
        studentDAO.save(stu);
        Assertions.assertTrue(studentDAO.exists(stu));
    }

    @Test
    void delete() {
        //Arrange
        StudentDTO stu = new StudentDTO(6L, "Nicolas", null, null, List.of(new SubjectDTO("Matematicas", 10.0)
                , new SubjectDTO("Español", 7.5)));
        studentDAO.save(stu);
        Assertions.assertTrue(studentDAO.delete(stu.getId()));
    }

    @Test
    void deleteStudentNotFound() {
        Assertions.assertFalse(studentDAO.delete(72L));
    }

    @Test
    void exists() {
    }

    @Test
    void findById() {
        //Arrange
        StudentDTO stu = new StudentDTO(5L, "Nicolas", null, null, List.of(new SubjectDTO("Matematicas", 10.0)
                , new SubjectDTO("Español", 7.5)));
        studentDAO.save(stu);
        StudentDTO resp = studentDAO.findById(stu.getId());
        Assertions.assertEquals(stu, resp);

    }
}
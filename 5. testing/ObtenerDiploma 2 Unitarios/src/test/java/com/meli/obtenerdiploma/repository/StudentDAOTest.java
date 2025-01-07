package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    @AfterEach
    void init(){
        studentDAO.save(new StudentDTO(2L, "Pedro", null, null,
                new ArrayList<>(List.of(new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)))));
    }
    @Test
    void saveStudentTest() {
        StudentDTO input = new StudentDTO(3L, "Nicolas", "", 4.2,
                new ArrayList<>(List.of(new SubjectDTO("Maths", 5.0))));

        StudentDTO expected = input;

        Assertions.assertEquals(expected, studentDAO.save(input));
    }

    @Test
    void deleteStudentTest() {
        Long input = 2L;
        boolean expected = true;

        Assertions.assertEquals(expected, studentDAO.delete(input));
    }

    @Test
    void existsStudentTest() {
        StudentDTO input = new StudentDTO(1L, "Juan", null, null,
                new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))));
        boolean expected = true;

        Assertions.assertEquals(expected, studentDAO.exists(input));
    }

    @Test
    void findStudentByIdTest() {
        Long input = 1L;
        StudentDTO expected = new StudentDTO(input, "Juan", null, null,
                new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))));

        StudentDTO response = studentDAO.findById(input);

        Assertions.assertEquals(expected, response);
    }
}
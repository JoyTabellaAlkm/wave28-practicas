package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentDaoTest {
    @Autowired
    IStudentDAO studentDAO;

    @Test
    public void successfulSaveExistentStudent() {
        Long expectedStudentId = 4L;
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Inglés", 5.0));
        StudentDTO studentDTO = new StudentDTO(expectedStudentId, "Matias", "", 0.0, subjects);

        studentDAO.save(studentDTO);

        Assertions.assertEquals(expectedStudentId, studentDTO.getId());
    }

    @Test
    public void successfulSaveNonExistentStudent() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Inglés", 5.0));
        StudentDTO studentDTO = new StudentDTO(null, "Ivan", "", 0.0, subjects);

        studentDAO.save(studentDTO);

        Assertions.assertNotNull(studentDTO.getId());
    }

    @Test
    public void successfulFindById() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Inglés", 5.0));
        StudentDTO expectedStudent = new StudentDTO(null, "Julian", "", 0.0, subjects);
        studentDAO.save(expectedStudent);

        StudentDTO studentObtained = studentDAO.findById(expectedStudent.getId());

        Assertions.assertEquals(expectedStudent, studentObtained);
    }

    @Test
    public void studentNotFoundFindById() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(-1L));
    }

    @Test
    public void successfulDelete() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Inglés", 5.0));
        StudentDTO expectedStudent = new StudentDTO(null, "Lucas", "", 0.0, subjects);
        studentDAO.save(expectedStudent);

        boolean successfulDelete = studentDAO.delete(expectedStudent.getId());

        Assertions.assertTrue(successfulDelete);
    }

    @Test
    public void unsuccessfulDelete() {
        boolean successfulDelete = studentDAO.delete(-1L);

        Assertions.assertFalse(successfulDelete);
    }

    @Test
    public void studentExists() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Inglés", 5.0));
        StudentDTO expectedStudent = new StudentDTO(null, "Julian", "", 0.0, subjects);
        studentDAO.save(expectedStudent);

        boolean studentExists = studentDAO.exists(expectedStudent);

        Assertions.assertTrue(studentExists);
    }

    @Test
    public void studentNotExists() {
        StudentDTO expectedStudent = new StudentDTO(null, "Julian", "", 0.0, null);
        boolean studentExists = studentDAO.exists(expectedStudent);

        Assertions.assertFalse(studentExists);
    }
}

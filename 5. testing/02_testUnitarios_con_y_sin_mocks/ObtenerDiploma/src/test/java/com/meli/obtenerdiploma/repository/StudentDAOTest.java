package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

   private  IStudentDAO studentDAO = new StudentDAO();
   private List<SubjectDTO> subjects = List.of(new SubjectDTO("Inglés", 5.0));
   private StudentDTO studentDTO = new StudentDTO(3L, "usuario", "creando", 5.0, subjects);

    @Test
    void save() {
        //ARRANGE
        Long expectedStudentId = 3L;

        //ACT
        studentDAO.save(studentDTO);

        //ASSERT
        assertEquals(expectedStudentId, studentDTO.getId());

    }

    @Test
    void delete() {
        //ARRANGE
        boolean expectedState = true;
        long studentId = 1L;

        //ACT
        boolean result = studentDAO.delete(studentId);

        //ASSERT
        Assertions.assertEquals(expectedState, result);
    }

    @Test
    void exists() {
        //ARRANGE
        boolean expectedState = true;

        //ACT
        boolean result = studentDAO.exists(studentDTO);

        //ASSERT
        Assertions.assertEquals(expectedState, result);
    }

    @Test
    void findById() {
        //ARRANGE
        long studentId = 3L;
        StudentDTO expectedStudent = studentDTO;

        //ACT
        StudentDTO result = studentDAO.findById(studentId);

        //ASSERT
        Assertions.assertEquals(expectedStudent.getId(), result.getId());
        Assertions.assertEquals(expectedStudent.getStudentName(), result.getStudentName());
    }
}
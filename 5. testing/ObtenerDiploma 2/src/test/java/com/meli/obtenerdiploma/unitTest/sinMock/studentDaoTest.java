package com.meli.obtenerdiploma.unitTest.sinMock;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class StudentDAOTest {

    private StudentDAO studentDAO = new StudentDAO();

    @Test
    public void contextLoads() {}

    @Test
    public void testDelete(){
        Long id = 1L;

        Assertions.assertTrue(studentDAO.delete(id));
    }

    @Test
    public void testDeleteSadPath(){
        Long id = 5L;

        Assertions.assertFalse(studentDAO.delete(id));
    }

    @Test
    public void testExists(){
        StudentDTO studentDTO = new StudentDTO(2L, "Carolina", "mensaje", 10.0,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))));

        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    public void testExistsSadPath(){
        StudentDTO studentDTO = new StudentDTO(5L, "Marian", "mensaje", 10.0,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))));

        Assertions.assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    public void testFindByID(){
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))));
        Long id = 1L;

        Assertions.assertEquals(studentDTO, studentDAO.findById(id));
    }

    @Test
    public void testFindByIDSadPath() {
        Long id = 1L;

        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(id);
        });
    }
}
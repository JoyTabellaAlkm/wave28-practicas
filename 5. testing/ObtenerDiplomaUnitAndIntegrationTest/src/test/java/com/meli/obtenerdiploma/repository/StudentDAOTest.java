package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.StudentsDtos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    public void setUp(){
        studentDAO = new StudentDAO();
    }

    @Test
    public void saveTest(){
        StudentDTO student = StudentsDtos.getStudent9();
        studentDAO.save(student);
        assertTrue(studentDAO.exists(student));
    }

    @Test
    public void updateIfExistingStudentTest(){
        StudentDTO studentSave = StudentsDtos.getStudent1();
        studentDAO.save(studentSave);

        StudentDTO studentUpdate = new StudentDTO(studentSave.getId(), "Jonh Doe", "Message Update", 77.9, null );
        studentDAO.save(studentUpdate);

        StudentDTO getStudentById = studentDAO.findById(studentUpdate.getId());
        assertNotNull(getStudentById, "Testing");
        assertEquals(studentUpdate, getStudentById);
    }

    @Test
    public void getStudentByIdTest(){
            try {
                studentDAO.findById(19L);
                fail("Expected StudentNotFoundException to be thrown");
            } catch (StudentNotFoundException e) {
                System.out.println("StudentNotFoundException caught: " + e.getMessage());
                assertTrue(true);
            }
    }

   @Test
   public void deleteStudentTest(){
        StudentDTO student = StudentsDtos.getStudent1();
        studentDAO.save(student);
        boolean result = studentDAO.delete(student.getId());
        assertTrue(result);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(student.getId()));
   }

    @Test
    public void studentNotFoundToDeleteItTest(){
        boolean result = studentDAO.delete(111L);
        assertFalse(result);
    }

    @Test
    public void findByIdStudentNotFoundTest() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(999L));
    }

}

package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.unit.factory.StudentFactory;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@SpringBootTest
@ActiveProfiles("test")
public class StudentDAOTest {
    private IStudentDAO studentDAO;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
    }

    @AfterEach
    public void tearDown() throws Exception {
        Path original = Path.of("src/test/resources/users.json");
        Path backup = Path.of("src/test/resources/users_backup.json");
        Files.copy(backup, original, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void saveNewStudent() {
        studentDAO.save(StudentFactory.sofiaStudentDTO);

        Assertions.assertTrue(studentDAO.exists(StudentFactory.sofiaStudentDTO));
    }

    @Test
    public void saveExistingStudent() {
        studentDAO.save(StudentFactory.juanStudentDTO);

        Assertions.assertTrue(studentDAO.exists(StudentFactory.juanStudentDTO));
    }

    @Test
    public void findByExistingId() {
        StudentDTO pedro = studentDAO.findById(StudentFactory.pedroStudentDTO.getId());

        Assertions.assertEquals(StudentFactory.pedroStudentDTO, pedro);
    }

    @Test
    public void findByNotExistingId() {
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentDAO.findById(StudentFactory.sofiaStudentDTO.getId())
        );
    }

    @Test
    public void deleteExistingStudent() {
        boolean deleted = studentDAO.delete(1L);

        Assertions.assertTrue(deleted);
    }

    @Test
    public void deleteNotExistingStudent() {
        boolean deleted = studentDAO.delete(3L);

        Assertions.assertFalse(deleted);
    }
}
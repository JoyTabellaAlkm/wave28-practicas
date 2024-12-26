package com.meli.obtenerdiploma.unit.repository;

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
        StudentDTO sofiaStudentDTO = StudentFactory.createSofiaStudentDTO();

        studentDAO.save(sofiaStudentDTO);

        Assertions.assertTrue(studentDAO.exists(sofiaStudentDTO));
    }

    @Test
    public void saveExistingStudent() {
        StudentDTO juanStudentDTO = StudentFactory.createJuanStudentDTO();

        studentDAO.save(juanStudentDTO);

        Assertions.assertTrue(studentDAO.exists(juanStudentDTO));
    }

    @Test
    public void findByExistingId() {
        StudentDTO pedroStudentDTO = StudentFactory.createPedroStudentDTO();

        StudentDTO pedro = studentDAO.findById(pedroStudentDTO.getId());

        Assertions.assertEquals(pedroStudentDTO, pedro);
    }

    @Test
    public void findByNotExistingId() {
        Long nonExistentId = 10L;

        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentDAO.findById(nonExistentId)
        );
    }

    @Test
    public void deleteExistingStudent() {
        Long juanStudentId = StudentFactory.createJuanStudentDTO().getId();

        boolean deleted = studentDAO.delete(juanStudentId);

        Assertions.assertTrue(deleted);
    }

    @Test
    public void deleteNotExistingStudent() {
        Long nonExistentId = 10L;

        boolean deleted = studentDAO.delete(nonExistentId);

        Assertions.assertFalse(deleted);
    }
}
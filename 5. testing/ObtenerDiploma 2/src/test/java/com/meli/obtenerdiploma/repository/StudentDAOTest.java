package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    @Autowired
    private IStudentDAO studentDao;
    private StudentDTO studentDto;

    @BeforeEach
    void setup() {
        studentDto = new StudentDTO();
    }

    @AfterEach
    void afterEach() {
        studentDao.delete(studentDto.getId());
    }

    @Test
    void save() {
        //Act
        studentDao.save(studentDto);

        //Assert
        assertNotNull(studentDto.getId());
    }

    @Test
    @DisplayName("Delete existing student")
    void testDeleteWhenTheIdExistsShouldReturnTrue() {
        //Arrange
        studentDao.save(studentDto);
        long id = studentDto.getId();
        boolean result;

        //Act
        result = studentDao.delete(id);

        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Delete non-existent student")
    void testDeleteWhenTheIdDoesNotExistShouldReturnFalse() {
        //Arrange
        long id = 1000L;
        boolean result;

        //Act
        result = studentDao.delete(id);

        //Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Validate existing student")
    void testExistsWhenTheStudentExistsShouldReturnTrue() {
        //Arrange
        studentDao.save(studentDto);
        boolean result;

        //Act
        result = studentDao.exists(studentDto);

        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Validate non-existent student")
    void testExistsWhenTheStudentDoesNotExistShouldReturnFalse() {
        //Arrange
        StudentDTO studentDto = new StudentDTO();
        studentDto.setId(1000L);
        boolean result;
        //Act
        result = studentDao.exists(studentDto);

        //Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Find user with valid Id")
    void testFindByIdWhenTheIdExistShouldReturnAStudentDto() {
        //Arrange
        long id = 1L;
        String nameExpected = "Juan";
        StudentDTO studentDTO;

        //Act
        studentDTO = studentDao.findById(id);

        //Assert
        assertNotNull(studentDTO);
        assertEquals(nameExpected, studentDTO.getStudentName());
    }

    @Test
    @DisplayName("Find user with invalid Id")
    void testFindByIdWhenTheIdDoesNotExistIdShouldLaunchStudentNotFoundException() {
        //Arrange
        long id = 1000L;

        //Act and Assert
        assertThrows(StudentNotFoundException.class, () -> studentDao.findById(id));
    }
}
package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObtenerDiplomaApplicationTests {
    static IStudentDAO studentDAO;

	static StudentDTO studentDTO1;
	static StudentDTO studentDTO2;
	static StudentDTO studentDTO3;

	@BeforeEach
	public void setup() {
	}

	@Test
	public void studentDaoSuccessfulFindById() {
		StudentDTO expectedStudent = studentDTO1;
		assertEquals(expectedStudent,studentDAO.findById(studentDTO1.getId()));
	}

	@Test
	public void studentDaoFindByIdNotFound() {
		assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(10L));
	}


}
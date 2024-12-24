package com.meli.obtenerdiploma.unitTest.repository.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class StudentDaoTest {

    StudentDAO studentDAO= new StudentDAO();

    @BeforeEach
    public void tearDown() {
        studentDAO.clear();
    }

    @Test
    public void save() {
        // Arrange
        List<SubjectDTO> subjectsPedro = new ArrayList<>();
        subjectsPedro.add(new SubjectDTO("Matemática", 9.0));
        subjectsPedro.add(new SubjectDTO("Física", 7.0));
        StudentDTO student = new StudentDTO(null, "Ana", "mensaje8", 4.0, subjectsPedro);


        // Act
        studentDAO.save(student);

        //assert
        Assertions.assertEquals(true, studentDAO.exists(student));
    }

    @Test
    public void findById(){
        //arrange
        Long id =  1L;
        List<SubjectDTO> subjectsJuan = new ArrayList<>();
        subjectsJuan.add(new SubjectDTO("Matemática", 10.0));
        subjectsJuan.add(new SubjectDTO("Física", 8.0));
        StudentDTO student = new StudentDTO(1L, "Pedro", "mensaje2", 8.0, subjectsJuan);


        //act
        StudentDTO obtenido = studentDAO.findById(id);
        //assert
        Assertions.assertEquals(student.getStudentName(), obtenido.getStudentName());

    }
    @Test
    public void delete(){
        //arrange
        Long id= 1L;

        boolean resultado;

        //act
        resultado= studentDAO.delete(id);

        //assert
        Assertions.assertTrue(resultado);
    }








}

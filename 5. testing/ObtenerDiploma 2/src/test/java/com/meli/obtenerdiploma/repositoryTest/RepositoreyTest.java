package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class RepositoreyTest {

    @Autowired
    IStudentRepository studentRepository = new StudentRepository();

    @Test
    public void findAllTest(){

        //ARRANGE
        List<SubjectDTO> subjectsJuan = new ArrayList<>();
        subjectsJuan.add(new SubjectDTO("Matemática", 9.0));
        subjectsJuan.add(new SubjectDTO("Física", 7.0));
        subjectsJuan.add(new SubjectDTO("Química", 6.0));

        StudentDTO juan = new StudentDTO(1L, "Juan", null, null, subjectsJuan);

        List<SubjectDTO> subjectsPedro = new ArrayList<>();
        subjectsPedro.add(new SubjectDTO("Matemática", 10.0));
        subjectsPedro.add(new SubjectDTO("Física", 8.0));
        subjectsPedro.add(new SubjectDTO("Química", 4.0));

        StudentDTO pedro = new StudentDTO(2L, "Pedro", null, null, subjectsPedro);

        Set<StudentDTO> studentsExpected = new HashSet<>();
        studentsExpected.add(juan);
        studentsExpected.add(pedro);

        //ACT
        Set<StudentDTO> studentsObtained = studentRepository.findAll();

        //ASSERT

        Assertions.assertEquals(studentsExpected,studentsObtained, "las conjuntos no son iguales");
        //Assertions.assertTrue(studentsObtained.containsAll(studentsExpected), "los conjuntos no son iguales");

    }
}

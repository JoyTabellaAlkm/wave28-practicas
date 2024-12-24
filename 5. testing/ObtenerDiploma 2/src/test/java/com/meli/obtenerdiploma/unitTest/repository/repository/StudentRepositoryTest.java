package com.meli.obtenerdiploma.unitTest.repository.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void findAll(){
        //arrange

        Set<StudentDTO> students = new HashSet<>();
        List<SubjectDTO> subjectsJuan = new ArrayList<>();
        subjectsJuan.add(new SubjectDTO("Matemática", 9.0));
        subjectsJuan.add(new SubjectDTO("Física", 7.0));
        subjectsJuan.add(new SubjectDTO("Química", 6.0));
        StudentDTO juan = new StudentDTO(1L, "Juan", "mensaje1",4.0,  subjectsJuan );
        students.add(juan);
        List<SubjectDTO> subjectsPedro = new ArrayList<>();
        subjectsPedro.add(new SubjectDTO("Matemática", 10.0));
        subjectsPedro.add(new SubjectDTO("Física", 8.0));
        subjectsPedro.add(new SubjectDTO("Química", 4.0));
        StudentDTO pedro = new StudentDTO(2L, "Pedro", "mensaje2", 8.0, subjectsPedro);
        students.add(pedro);
        //act
        Set<StudentDTO> expected= studentRepository.findAll();


        //assert
        assertEquals(students, expected);

    }



}

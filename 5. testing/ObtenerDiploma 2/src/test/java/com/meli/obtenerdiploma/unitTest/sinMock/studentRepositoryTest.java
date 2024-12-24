package com.meli.obtenerdiploma.unitTest.sinMock;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class studentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();

    @Test
    public void findAllTest(){
        Set<StudentDTO> students;

        students = studentRepository.findAll();

        Assertions.assertEquals(studentRepository.findAll(), students);
    }



}

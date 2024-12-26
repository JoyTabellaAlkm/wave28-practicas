package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    IStudentRepository studentRepository = new StudentRepository();

    @Test
    void findAll() {

        // ARRANGE
        Integer sizeExpected = 2;

        // ACT
        Set<StudentDTO> studentDTOList = studentRepository.findAll();
        Integer size = studentDTOList.size();

        // ASSERT

        Assertions.assertEquals(sizeExpected, size);
    }

}
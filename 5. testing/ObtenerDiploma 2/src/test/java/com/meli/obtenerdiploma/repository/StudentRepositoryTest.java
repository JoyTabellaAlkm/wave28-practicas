package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StudentRepositoryTest {

    IStudentRepository studentRepository = new StudentRepository();

    @Test
    public void studentsList(){
        Set<StudentDTO> expectedStudents = new HashSet<>();
            expectedStudents.add(new StudentDTO(1L,"Geraldo", "mensaje1",4.0,
                List.of(
                        new SubjectDTO("Ciencias", 9.0)
                )));
            expectedStudents.add(new StudentDTO(2L,"Yul", "mensaje1",4.0,
                    List.of(
                            new SubjectDTO("Fisica", 5.0)
                    )));

        Set<StudentDTO> result = studentRepository.findAll();
        Assertions.assertEquals(expectedStudents.size(),result.size());
        Assertions.assertEquals(expectedStudents, result);
    }
}

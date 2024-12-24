package com.meli.obtenerdiploma.unitTest.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class StudentRepositoryTest {

    @Autowired
    IStudentRepository studentRepository = new StudentRepository();

    private static final Set<StudentDTO> expectedList = new HashSet<>();
    StudentDTO expectedStudent2 = new StudentDTO(
            Long.parseLong("2"),
            "Pedro",
            null,
            null,
            List.of(new SubjectDTO(
                    "Matemática",
                    10.0
                    ), new SubjectDTO(
                        "Física",
                        8.0
                    ), new SubjectDTO(
                        "Química",
                        4.0
                    )
            )
    );
    StudentDTO expectedStudent1 = new StudentDTO(
            Long.parseLong("1"),
            "Juan",
            null,
            null,
            List.of(new SubjectDTO(
                    "Matemática",
                    9.0
                    ), new SubjectDTO(
                        "Física",
                        7.0
                    ), new SubjectDTO(
                        "Química",
                        6.0
                    )
            )
    );



    @Test
    @DisplayName("Test 6: FindAll OK")
    public void findAllTestOK(){

        //ARRANGE
        expectedList.add(expectedStudent1);
        expectedList.add(expectedStudent2);

        //ACT
        Set<StudentDTO> receivedList = studentRepository.findAll();

        //ASSERT
        Assertions.assertEquals(expectedList,receivedList);

    }
}

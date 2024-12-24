package com.meli.obtenerdiploma.unitTest.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class StudentDAOTest {

    @Autowired
    IStudentDAO studentDAO = new StudentDAO();

    StudentDTO expectedStudent = new StudentDTO(
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

    StudentDTO newStudent = new StudentDTO(
            Long.parseLong("3"),
            "Bobito",
            null,
            null,
            List.of(new SubjectDTO(
                            "Matemática",
                            2.0
                    ), new SubjectDTO(
                            "Física",
                            1.0
                    ), new SubjectDTO(
                            "Química",
                            1.5
                    )
            )
    );


    @Test
    @DisplayName("Test 1.1: AddStudent OK")
    public void addStudentOK(){
        //ARRANGE
        StudentDTO toAdd = newStudent;

        //ACT
        studentDAO.save(newStudent);

        //ASSERT
        StudentDTO savedStudent = studentDAO.findById(newStudent.getId()); //No idea if they want this tested in some other way, take what you can get
        Assertions.assertEquals(savedStudent, toAdd);
    }

    @Test
    @DisplayName("Test 1.2: AddStudent Bad Request (Subject List Empty)")
    public void addStudentBadRequest(){ //ToDo: This should be throwing an error due to validation tags, but it isn't. Ask to Joey.
        //ARRANGE
        StudentDTO newStudent = new StudentDTO
        (
                3L,
                "Chacho",
                null,
                null,
                new ArrayList<>()
        );
        //ACT
        studentDAO.save(newStudent);

        //ASSERT
        StudentDTO savedStudent = studentDAO.findById(newStudent.getId()); //No idea if they want this tested in some other way, take what you can get
        Assertions.assertEquals(savedStudent, newStudent);
    }

    @Test
    @DisplayName("Test 2.1: FindById OK")
    public void findByIdOK(){
        //ARRANGE
        Long expectedStudentId = Long.parseLong("1");
        //ACT
        StudentDTO receivedStudent = studentDAO.findById(expectedStudentId);
        //ASSERT
        Assertions.assertEquals(receivedStudent, expectedStudent);

    }

    @Test
    @DisplayName("Test 2.2: FindById NotFound")
    public void findByIdNotFound(){
        //ARRANGE
        Long expectedStudentId = Long.parseLong("8");
        //ACT & ASSERT
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> {studentDAO.findById(expectedStudentId);}); //Ni idea de como validar el Not Found
    }

    @Test
    @DisplayName("Test 3.1: Update OK")
    public void updateOK(){
        //ARRANGE
        StudentDTO modifiedStudent = new StudentDTO(
                1L,
                "Habsburgo",
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

        //ACT
        studentDAO.save(modifiedStudent);
        StudentDTO modifiedStudentStored = studentDAO.findById(1L);

        //ASSERT
        Assertions.assertEquals(modifiedStudent, modifiedStudentStored);


    }

    @Test
    @DisplayName("Test 3.2: Update Bad Request (StudentName empty)")
    public void updateBadRequest(){ //ToDo: This should be throwing an error due to validation tags, but it isn't. Ask to Joey.
        //ARRANGE
        StudentDTO modifiedStudent = new StudentDTO(
                1L,
                "",
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

        //ACT
        studentDAO.save(modifiedStudent);
        StudentDTO modifiedStudentStored = studentDAO.findById(1L);

        //ASSERT
        Assertions.assertEquals(modifiedStudent, modifiedStudentStored);
    }


    @Test
    @DisplayName("Test 4.1: Delete OK")
    public void deleteOK(){
        //ARRANGE
        Long studentToDeleteId = 1L;
        StudentDTO studentToDelete = studentDAO.findById(1L);
        //ACT

        boolean isDeleted = studentDAO.delete(studentToDeleteId);

        //ASSERT

        Assertions.assertEquals(isDeleted, !studentDAO.exists(studentToDelete));
        Assertions.assertThrows
                (
                    StudentNotFoundException.class,
                    () -> {studentDAO.findById(studentToDeleteId);}
                );

    }

    @Test
    @DisplayName("Test 4.2: Delete Not Found")
    public void deleteNotFound(){
        //ARRANGE
        Long studentToDeleteId = 100L;

        //ACT
        boolean isDeleted = studentDAO.delete(studentToDeleteId);
        //ASSERT
        Assertions.assertFalse(isDeleted);

    }




}

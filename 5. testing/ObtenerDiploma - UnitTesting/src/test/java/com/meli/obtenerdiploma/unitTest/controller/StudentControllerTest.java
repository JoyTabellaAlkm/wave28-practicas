package com.meli.obtenerdiploma.unitTest.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

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
    @DisplayName("1.1: RegisterStudent OK")
    public void registerStudentOK(){
        //ARRANGE
        StudentDTO testSubject = newStudent;
        //ACT
        ResponseEntity<?> receivedResponse = studentController.registerStudent(testSubject);
        //ASSERT
        Mockito.verify(studentService, Mockito.atLeastOnce()).create(testSubject);
        Assertions.assertEquals(HttpStatus.CREATED, receivedResponse.getStatusCode());
    }

    @Test
    @DisplayName("2.1: GetStudent OK")
    public void getStudentOK(){
        //ARRANGE
        Long testSubject = 1L;
        StudentDTO testStudent = expectedStudent;
        Mockito.when(studentService.read(testSubject)).thenReturn(testStudent);
        //ACT
        StudentDTO receivedResponse = studentController.getStudent(testSubject);
        //ASSERT
        Mockito.verify(studentService, Mockito.atLeastOnce()).read(testSubject);
        Assertions.assertEquals(testStudent, receivedResponse);
    }

    @Test
    @DisplayName("2.1: GetStudent NotFound")
    public void getStudentNotFound(){
        //ARRANGE
        Long testSubject = 100L;
        Mockito.when(studentService.read(testSubject)).thenThrow(StudentNotFoundException.class);
        //ACT & ASSERT
        Assertions.assertThrows
                (
                        StudentNotFoundException.class,
                        () -> {studentService.read(testSubject);}
                );
    }

    @Test
    @DisplayName("3.1: ModifyStudent OK")
    public void modifyStudentOK(){
        //ARRANGE
        StudentDTO testSubject = expectedStudent;
        //ACT
        ResponseEntity<?> receivedResponse = studentController.modifyStudent(testSubject);
        //ASSERT
        Mockito.verify(studentService, Mockito.atLeastOnce()).update(testSubject);
        Assertions.assertEquals(HttpStatus.OK, receivedResponse.getStatusCode());
    }

    @Test
    @DisplayName("4.1: DeleteStudent OK")
    public void deleteStudentOK(){
        //ARRANGE
        Long toDelete = 1L;
        //ACT
        ResponseEntity<?> receivedResponse = studentController.removeStudent(toDelete
        );
        //ASSERT
        Mockito.verify(studentService, Mockito.atLeastOnce()).delete(toDelete);
        Assertions.assertEquals(HttpStatus.OK, receivedResponse.getStatusCode());

    }

 //  @Test
 //  @DisplayName("4.1: DeleteStudent NotFound")
 //  public void deleteStudentNotFound(){
 //      //ARRANGE
 //      Long toDelete = 100000L;
 //      //ACT
 //      ResponseEntity<?> receivedResponse = studentController.removeStudent(toDelete);
 //      //ASSERT
 //      Mockito.verify(studentService, Mockito.atLeastOnce()).delete(toDelete);
 //      Assertions.assertEquals(HttpStatus.OK, receivedResponse.getStatusCode());

 //  }

    @Test
    @DisplayName("5.1: ListStudents OK")
    public void listStudentsOK(){
        //ARRANGE
        Set<StudentDTO> expectedList = new HashSet<>();
        expectedList.add(expectedStudent);
        Mockito.when(studentService.getAll()).thenReturn(expectedList);
        //ACT
        Set<StudentDTO> receivedList = studentController.listStudents();
        //ASSERT
        Mockito.verify(studentService, Mockito.atLeastOnce()).getAll();
        Assertions.assertEquals(receivedList, expectedList);

    }



}

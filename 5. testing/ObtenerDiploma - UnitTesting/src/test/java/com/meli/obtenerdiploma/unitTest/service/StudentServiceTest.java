package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    StudentDTO testStudent = new StudentDTO(
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
    ///Tests

    @Test
    @DisplayName("Test 1.1: Create OK")
    public void createOK(){
        //ARRANGE
        StudentDTO testSubject = testStudent;
        //ACT
        studentService.create(testSubject);
        //ASSERT
        Mockito.verify(studentDAO, times(1)).save(testSubject);
    }

    @Test
    @DisplayName("Test 2.1: Read OK")
    public void readOK(){
        //ARRANGE
        StudentDTO testSubject = testStudent;
        when(studentDAO.findById(1L)).thenReturn(testSubject);
        //ACT
        StudentDTO receivedStudent = studentService.read(1L);
        //ASSERT
        verify(studentDAO, times(1)).findById(1L);
        Assertions.assertEquals(receivedStudent, testSubject);
    }


    @Test
    @DisplayName("Test 3.1: Update OK")
    public void updateOK(){
        //ARRANGE
        StudentDTO testSubject = testStudent;
        //ACT
        studentService.update(testSubject);
        //ASSERT
        verify(studentDAO, times(1)).save(testSubject);
    }


    @Test
    @DisplayName("Test 4.1: Delete OK")
    public void deleteOK(){
        //ARRANGE
        Long toDelete = 1L;
        //ACT
        studentService.delete(toDelete);
        //ASSERT
        verify(studentDAO, times(1)).delete(toDelete);
    }


    @Test
    @DisplayName("Test 4.1: GetAll OK")
    public void getAll(){
        //ARRANGE
        Set<StudentDTO> expectedList = new HashSet<>();
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
        expectedList.add(expectedStudent1);
        expectedList.add(expectedStudent2);

        Long toDelete = 1L;
        Mockito.when(studentRepository.findAll()).thenReturn(expectedList);
        //ACT
        Set<StudentDTO> receivedList = studentService.getAll();
        //ASSERT
        verify(studentRepository, times(1)).findAll();
        Assertions.assertEquals(receivedList, expectedList);
    }





}

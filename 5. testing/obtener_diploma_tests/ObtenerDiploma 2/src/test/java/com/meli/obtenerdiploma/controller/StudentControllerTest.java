package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent(){
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWithThreeSubjects("Marco");

        // act
        studentController.registerStudent(stu);

        // assert
        verify(studentService, atLeastOnce()).create(stu);
    }

    @Test
    public void getStudent(){
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWithThreeSubjects("Marco");
        when(studentService.read(stu.getId())).thenReturn(stu);

        // act
        StudentDTO readStu = studentController.getStudent(stu.getId());

        // assert
        verify(studentService, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void modifyStudent(){
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWithThreeSubjects("Marco");

        // act
        studentController.modifyStudent(stu);

        // assert
        verify(studentService, atLeastOnce()).update(stu);
    }

    @Test
    public void removeStudent(){
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWithThreeSubjects("Marco");

        // act
        studentController.removeStudent(stu.getId());

        // assert
        verify(studentService, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void listStudents(){
        // arrange
        Set<StudentDTO> studentDTOS = TestUtilsGenerator.getStudentSet();
        when(studentService.getAll()).thenReturn(studentDTOS);
        // act
        Set<StudentDTO> result = studentController.listStudents();

        // assert
        verify(studentService, atLeastOnce()).getAll();
        assertEquals(result, studentDTOS);
    }
}

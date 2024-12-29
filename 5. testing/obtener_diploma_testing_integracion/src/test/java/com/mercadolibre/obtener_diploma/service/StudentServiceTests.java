package com.mercadolibre.obtener_diploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.obtener_diploma.model.StudentDTO;
import com.mercadolibre.obtener_diploma.repository.IStudentDAO;
import com.mercadolibre.obtener_diploma.repository.IStudentRepository;
import com.mercadolibre.obtener_diploma.util.TestUtilsGenerator;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepo;

    @InjectMocks
    StudentService service;

    @Test
    public void createStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        service.create(stu);

        // assert
        verify(studentDAO, atLeastOnce()).save(stu);
    }

    @Test
    public void readStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        StudentDTO readStu = service.read(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void updateStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        service.update(stu);

        // assert
        verify(studentDAO, atLeastOnce()).save(stu);
    }

    @Test
    public void deleteStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        service.delete(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void getAllStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(studentRepo.findAll()).thenReturn(students);

        // act
        Set<StudentDTO> readStudents = service.getAll();

        // assert
        verify(studentRepo, atLeastOnce()).findAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}

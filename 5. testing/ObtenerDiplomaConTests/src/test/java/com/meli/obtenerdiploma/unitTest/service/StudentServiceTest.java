package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void createStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Gabriel");

        studentService.create(studentDTO);

        verify(studentDAO, atLeast(1)).save(studentDTO);
    }

    @Test
    public void readStudentTest() {
        Long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentId);
        studentDTO.setStudentName("Gabriel");

        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        StudentDTO foundStudent = studentService.read(studentId);

        assertThat(foundStudent).isNotNull();
        assertThat(foundStudent.getId()).isEqualTo(studentId);
        assertThat(foundStudent.getStudentName()).isEqualTo("Gabriel");
    }

    @Test
    public void updateStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Gabriel");

        studentService.update(studentDTO);

        verify(studentDAO, atLeast(1)).save(studentDTO);
    }

    @Test
    public void getAllStudentsTest() {
        Set<StudentDTO> students = new HashSet<>();
        StudentDTO student1 = new StudentDTO();
        student1.setStudentName("Gabriel");
        students.add(student1);

        when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> returnedStudents = studentService.getAll();

        assertThat(returnedStudents).isNotNull();
        assertThat(returnedStudents.size()).isEqualTo(1);
        assertThat(returnedStudents).contains(student1);
    }

}

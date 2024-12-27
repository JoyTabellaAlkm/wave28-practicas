package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testCreateStudent() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("John Doe");

        doNothing().when(studentDAO).save(studentDTO);

        studentService.create(studentDTO);

        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    public void testReadStudent() {
        Long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentId);
        studentDTO.setStudentName("John Doe");

        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        StudentDTO result = studentService.read(studentId);

        assertNotNull(result);
        assertEquals(studentId, result.getId());
        assertEquals("John Doe", result.getStudentName());
    }

    @Test
    public void testUpdateStudent() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("John Doe");

        doNothing().when(studentDAO).save(studentDTO);

        studentService.update(studentDTO);

        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    public void testDeleteStudent() {
        Long studentId = 1L;
        doNothing().when(studentDAO).delete(studentId);

        studentService.delete(studentId);

        verify(studentDAO, times(1)).delete(studentId);
    }

    @Test
    public void testGetAllStudents() {
        Set<StudentDTO> students = Set.of(
                new StudentDTO(1L, null, "John Doe",null,null),
                new StudentDTO(2L, null, "Jane Doe", null, null));

        when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> result = studentService.getAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}

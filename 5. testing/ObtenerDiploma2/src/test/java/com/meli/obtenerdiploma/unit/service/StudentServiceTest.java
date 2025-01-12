package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;
    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    private StudentDTO studentDTO;

    @BeforeEach
    public void setStudentDTO() {
        studentDTO = new StudentDTO(1L,
                "Dummy User",
                "",
                0.0,
                new ArrayList<>(){
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 8.93));
                        add(new SubjectDTO("Química", 9.0));
                    }
                }
        );
    }

    @Test
    @DisplayName("Debe crear un student DTO")
    void create() {
        StudentDTO expectedStudent = studentDTO;
        when(studentDAO.save(expectedStudent)).thenReturn(expectedStudent);

        StudentDTO currentStudent = studentService.create(expectedStudent);

        assertEquals(expectedStudent, currentStudent);
    }

    @Test
    @DisplayName("Debe retornar el StudentDTO correcto por id")
    void read() {
        StudentDTO expectedStudent = studentDTO;
        when(studentDAO.findById(expectedStudent.getId())).thenReturn(expectedStudent);

        StudentDTO currentStudent = studentService.read(expectedStudent.getId());

        assertEquals(expectedStudent, currentStudent);
    }

    @Test
    @DisplayName("Debe updatear correctamente al mensaje del Student")
    void update() {
        String expectedMessage = "testing";
        StudentDTO expectedStudent = studentDTO;
        expectedStudent.setMessage(expectedMessage);

        when(studentDAO.save(expectedStudent)).thenReturn(expectedStudent);
        when(studentDAO.findById(expectedStudent.getId())).thenReturn(expectedStudent);
        studentService.update(expectedStudent);
        StudentDTO currentStudent = studentService.read(expectedStudent.getId());

        assertEquals(expectedMessage, currentStudent.getMessage());
    }

    @Test
    @DisplayName("Debe eliminar correctamente el Student")
    void delete() {
        boolean expectedResult = true;

        when(studentDAO.delete(studentDTO.getId())).thenReturn(true);
        boolean currentResult = studentService.delete(studentDTO.getId());

        assertEquals(expectedResult, currentResult);
    }

    @Test
    @DisplayName("Debe retornar una lista de usuarios DTO")
    void getAll() {
        Set<StudentDTO> expectedStudents = new HashSet<>();

        when(studentRepository.findAll()).thenReturn(expectedStudents);
        Set<StudentDTO> currentStudents = studentService.getAll();

        assertEquals(expectedStudents.size(), currentStudents.size());
    }
}
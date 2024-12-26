package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiploServiceTestMock {
    @Mock
    private StudentDTO studentDTO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void getAll() {
        StudentDTO studentDTO = new StudentDTO("Nombre","Mensaje",1.0, List.of(new SubjectDTO("Subject",1.0)));

        obtenerDiplomaService.addStudent(studentDTO);

        when(obtenerDiplomaService.getAll()).thenReturn(List.of(studentDTO));

        StudentDTO addedStudent = obtenerDiplomaService.addStudent(studentDTO);
        assertNotNull(addedStudent.getStudentName());
        assertEquals(studentDTO.getStudentName(),addedStudent.getStudentName());
        assertEquals(studentDTO.getSubjects(),addedStudent.getSubjects());
    }
}

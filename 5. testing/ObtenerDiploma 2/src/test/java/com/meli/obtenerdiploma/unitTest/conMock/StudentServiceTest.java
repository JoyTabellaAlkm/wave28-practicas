package com.meli.obtenerdiploma.unitTest.conMock;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void readTest(){

        Long id = 1L;
        StudentDTO esperado = new StudentDTO(1L, "Juan", null, null,
                new ArrayList<>(List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0))));

        StudentDTO studentMock = esperado;

        Mockito.when(studentDAO.findById(id)).thenReturn(studentMock);

        StudentDTO obtenido = studentService.read(id);

        Assertions.assertEquals(esperado, obtenido);
    }

    @Test
    public void readTestBadPath(){

        Long id = 2L;
        StudentDTO esperado = new StudentDTO(1L, "Juan", null, null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))));

        StudentDTO studentMock = new StudentDTO(2L, "Pedro", null, null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0))));


        Mockito.when(studentDAO.findById(id)).thenReturn(studentMock);

        StudentDTO obtenido = studentService.read(id);

        Assertions.assertNotEquals(esperado, obtenido);
    }


    @Test
    public void getAllTest(){

        StudentDTO estudiante1 = new StudentDTO(1L, "Juan", null, null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))));

        StudentDTO estudiante2 = new StudentDTO(2L, "Pedro", null, null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0))));

        Set<StudentDTO> esperado = new HashSet<>();
        esperado.add(estudiante1);
        esperado.add(estudiante2);

        Mockito.when(this.studentRepository.findAll()).thenReturn(esperado);

        Set<StudentDTO> obtenido = studentService.getAll();

        Assertions.assertEquals(esperado, obtenido);
    }


    @Test
    public void getAllTestBadPath(){

        StudentDTO estudiante1 = new StudentDTO(1L, "Juan", null, null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0))));

        StudentDTO estudiante2 = new StudentDTO(2L, "Pedro", null, null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0))));

        Set<StudentDTO> esperado = new HashSet<>();
        esperado.add(estudiante1);
        esperado.add(estudiante2);

        Set<StudentDTO> listaMock = new HashSet<>();
        esperado.add(estudiante2);
        esperado.add(estudiante2);

        Mockito.when(this.studentRepository.findAll()).thenReturn(listaMock);

        Set<StudentDTO> obtenido = studentService.getAll();

        Assertions.assertNotEquals(esperado, obtenido);
    }

}

package com.meli.ejercicio_diploma.unit.service;

import com.meli.ejercicio_diploma.model.StudentDTO;
import com.meli.ejercicio_diploma.model.SubjectDTO;
import com.meli.ejercicio_diploma.repository.IStudentDAO;
import com.meli.ejercicio_diploma.repository.IStudentRepository;
import com.meli.ejercicio_diploma.service.impl.StudentService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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
        StudentDTO stu = new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                );

        // act
        Mockito.when(studentDAO.save(stu)).thenReturn(true);
        boolean obtenido =service.create(stu);

        // assert
        verify(studentDAO, atLeastOnce()).save(stu);
        Assertions.assertTrue(obtenido);
    }

    @Test
    public void readStudent() {
        // arrange
        StudentDTO stu = new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                );

        // act
        when(studentDAO.findById(stu.getId())).thenReturn(stu);
        StudentDTO readStu = service.read(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void updateStudent() {
        // arrange
        StudentDTO stu = new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                );

        // act
        service.update(stu);

        // act
        Mockito.when(studentDAO.save(stu)).thenReturn(true);
        boolean obtenido = service.update(stu);

        // assert
        verify(studentDAO, atLeastOnce()).save(stu);
        Assertions.assertTrue(obtenido);
    }

    @Test
    public void deleteStudent() {
        // arrange
        StudentDTO stu = new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                );

        // assert

        Mockito.when(studentDAO.delete(stu.getId())).thenReturn(true);
        boolean obtenido = service.delete(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).delete(stu.getId());
        Assertions.assertTrue(obtenido);
    }

    @Test
    public void getAllStudents() {
        // arrange
        Set<StudentDTO> students = Set.of(
                new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                ),
                new StudentDTO(2L,
                        "Pedro",
                        List.of(
                                new SubjectDTO("Matemática", 10.0),
                                new SubjectDTO("Física", 8.0),
                                new SubjectDTO("Química", 4.0)
                        )
                )
        );

        // act
        when(studentRepo.findAll()).thenReturn(students);
        Set<StudentDTO> readStudents = service.getAll();

        // assert
        verify(studentRepo, atLeastOnce()).findAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}

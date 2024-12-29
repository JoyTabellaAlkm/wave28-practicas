package com.obtenerdiploma.unit.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.obtenerdiploma.dto.StudentDTO;
import com.obtenerdiploma.dto.SubjectDTO;
import com.obtenerdiploma.entity.Student;
import com.obtenerdiploma.entity.Subject;
import com.obtenerdiploma.repository.StudentRepository;
import com.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    ObjectMapper mapper = new ObjectMapper();

    private static final Student student1 = new Student (1L, "Juan", Set.of(
            new Subject("Matemática", 9D),
            new Subject("Física", 7D),
            new Subject("Química", 6D))
    );

    private static final StudentDTO studentDTO1 = new StudentDTO(1L, "Juan", Set.of(
            new SubjectDTO("Matemática", 9D),
            new SubjectDTO("Física", 7D),
            new SubjectDTO("Química", 6D))
    );

    private static final Student student2 = new Student (2L, "Pedro", Set.of(
            new Subject("Matemática", 10D),
            new Subject("Física", 8D),
            new Subject("Química", 4D))
    );



    // public boolean create(StudentDTO stu)
    @Test
    @DisplayName("Crear Student OK")
    public void createTestOK() {
        //ARRANGE
        boolean studentCreadoEsperado = true;

        //ACT
        Mockito.when(studentRepository.save(student1)).thenReturn(studentCreadoEsperado);
        boolean studentCreadoObtenido = studentService.create(studentDTO1);

        //ASSERT
        Assertions.assertEquals(studentCreadoEsperado, studentCreadoObtenido, "El Student es distinto");
        Assertions.assertDoesNotThrow(() -> studentService.create(studentDTO1));
    }

    @Test
    @DisplayName("GET student")
    public void getStudent(){
        Student student1 = new Student (1L, "Juan", Set.of(
                new Subject("Matemática", 9D),
                new Subject("Física", 7D),
                new Subject("Química", 6D))
        );
        StudentDTO studentExpected = mapper.convertValue(student1, StudentDTO.class);
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));

        Optional<StudentDTO> studentResponse = studentService.getStudentById(studentDTO1.getId());

        Assertions.assertNotNull(studentResponse);
        Assertions.assertEquals(studentResponse,Optional.of(studentExpected));
    }

    @Test
    @DisplayName("save student")
    public void test_createStudent(){
        Student student4 = new Student (1L, "Juan", Set.of(
                new Subject("Matemática", 9D),
                new Subject("Física", 7D),
                new Subject("Química", 6D))
        );
        StudentDTO studentToCreate =mapper.convertValue(student4,StudentDTO.class);
        Mockito.when(studentRepository.save(student4)).thenReturn(true);

        boolean response = studentService.create(studentToCreate);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response);

    }


}

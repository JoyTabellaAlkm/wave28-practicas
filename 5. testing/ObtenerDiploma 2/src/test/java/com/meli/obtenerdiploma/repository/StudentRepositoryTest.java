package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
//@TestPropertySource("classpath:application-test.properties")
public class StudentRepositoryTest {

    IStudentRepository studentRepository = new StudentRepository();

    private static final Set<StudentDTO> expectedList = new HashSet<>();
    StudentDTO expectedStudent1 = new StudentDTO(
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
    StudentDTO expectedStudent2 = new StudentDTO(
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

//    Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de repositorio StudentDAO y StudentRepository. Tener en cuenta múltiples escenarios y “casos borde” de cada comportamiento.
//
//    Casos nulos, vacíos, inválidos.
//    Agregar un alumno.
//    Buscar un alumno por Id.
//    Modificar los datos de un alumno.
//    Eliminar un alumno.
//    Listar todos los alumnos


    @Test
    @DisplayName("Test 1: FindAll OK")
    public void findAllTestOK(){
        //ARRANGE
        expectedList.add(expectedStudent2);
        expectedList.add(expectedStudent1);
        //ACT
        Set<StudentDTO> receivedList = studentRepository.findAll();
        //ASSERT
        Assertions.assertArrayEquals(expectedList.toArray(),receivedList.toArray());
    }

    @Test
    @DisplayName("Test 2: AddAlumno OK")
    public void AddAlumnoOK(){
        //ARRANGE
        StudentDTO newStudent = new StudentDTO(
                Long.parseLong("3"),
                "Cami",
                null,
                null,
                List.of(new SubjectDTO(
                                "Matemática",
                                10.0
                        ), new SubjectDTO(
                                "Física",
                                9.0
                        ), new SubjectDTO(
                                "Química",
                                8.0
                        )
                )
        );
        //ACT
        Set<StudentDTO> receivedList = studentRepository.findAll();
        //ASSERT
        Assertions.assertArrayEquals(expectedList.toArray(),receivedList.toArray());
    }
}

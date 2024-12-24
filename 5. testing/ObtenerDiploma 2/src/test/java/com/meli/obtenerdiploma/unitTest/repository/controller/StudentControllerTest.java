package com.meli.obtenerdiploma.unitTest.repository.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    Set<StudentDTO> listaEstudiantes= new HashSet<>(){{add(alumnoAna); add(alumnoJuan);}};
    // creo alumnos de prueba
    private static final StudentDTO alumnoJuan =
            new StudentDTO(1L, "Juan", "", 0.0,
                    List.of(new SubjectDTO("Matemáticas", 10.0),
                            new SubjectDTO("Historia", 8.0)));
    private static final StudentDTO alumnoAna =
            new StudentDTO( 1L, "Ana", "mensaje2",9.0,
                    List.of(new SubjectDTO( "Matemáticas", 9.0),
                            new SubjectDTO( "Fisica", 7.0)));
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    @DisplayName(" 01- llamada al controllador registrar estudiante ")
    public void registerStudent() {
        //arrange
        StudentDTO alumno = alumnoJuan;
        //act
        controller.registerStudent(alumno);
        //assert
        Mockito.verify(service, Mockito.atLeastOnce()).create(alumno);
    }

    @Test
    @DisplayName(" 02- devolver un estudiante  ")
    public void getStudent() {
        //arrange
        Long parametro = 1L;

        //act
        controller.getStudent(parametro);

        //assert
        Mockito.verify(service, Mockito.atLeastOnce()).read(parametro);
    }

    @Test
    @DisplayName("03- modificar estudiante")
    public  void modifyStudent() {
       StudentDTO parametro= alumnoJuan;

       //act
        controller.modifyStudent(parametro);

        //assert
        Mockito.verify(service, Mockito.atLeastOnce()).update(parametro);
    }

    @Test
    @DisplayName("04- eliminar estudiante")
    public void removeStudent(){
        //arrange
        Long parametro = 1L;

        //act
        controller.removeStudent(parametro);

        //assert
        Mockito.verify(service, Mockito.atLeastOnce()).delete(parametro);

    }

    @Test
    @DisplayName("05 - mostrar lista de estudiantes")
    public void listStudents(){
        //arrange

       Mockito.when(service.getAll()).thenReturn(listaEstudiantes);
       Set<StudentDTO> esperado= listaEstudiantes;
        //act
        Set<StudentDTO> obtenido= controller.listStudents();
        //asseert
        Mockito.verify(service, Mockito.atLeastOnce()).getAll();
        Assertions.assertEquals(esperado, obtenido);
    }

}

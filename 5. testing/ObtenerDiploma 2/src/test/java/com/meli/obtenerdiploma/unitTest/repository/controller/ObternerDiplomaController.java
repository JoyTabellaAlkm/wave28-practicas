package com.meli.obtenerdiploma.unitTest.repository.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObternerDiplomaController {
    // creo alumnos de prueba
    private static final StudentDTO alumnoJuan=
            new StudentDTO( 1L, "Juan", "",0.0,
                    List.of(new SubjectDTO( "Matemáticas", 10.0),
                            new SubjectDTO( "Historia", 8.0)));
    private static final StudentDTO alumnoAna =
            new StudentDTO( 1L, "Ana", "mensaje2",9.0,
                    List.of(new SubjectDTO( "Matemáticas", 9.0),
                            new SubjectDTO( "Fisica", 7.0)));

    @Mock
    IObtenerDiplomaService studentService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("01 - Controller test ok")
    public void analyzeScores(){
        // arrange
        StudentDTO stu = alumnoJuan;

        // act
        obtenerDiplomaController.analyzeScores(stu.getId());

        // assert
        verify(studentService, atLeastOnce()).analyzeScores(stu.getId());
    }





}

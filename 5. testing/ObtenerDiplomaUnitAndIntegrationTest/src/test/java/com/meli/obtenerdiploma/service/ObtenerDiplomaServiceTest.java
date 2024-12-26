package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*
Ejercicio 2:

Pasos del test Unitario con Mocks

Crear el mock IStudentDAO.
Inyectarlo en ObtenerDiplomaService.
Configurar su comportamiento (setup) con el método when.
Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.*/

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    /*
        Crear el mock IStudentDAO.
     */
    @Mock
    IStudentDAO studentDAO;

    /*
        Inyectarlo en ObtenerDiplomaService.
     */
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    /*
        @BeforeEach
        Esta annotation se usa para inicializar settings necesarios para cada prueba de manera individual
        Cada prueba comienza con un contexto limpio y todas las dependencias simuladas configuradas

        MockitoAnnotations.openMocks(this)
        Este method inicializa los objetos anotados con Mockito, como @Mock y @InjectMocks.

        Si no se incluye esta línea y se intenta usar un mock, obtendrás un NullPointerException
        porque el mock no se habrá inicializado correctamente.
     */
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("-Datos validos- Verifica el calculo correcto del promedio y el mensaje de felicitaciones")
    @Test
    public void analyzeScores_WithValidStudent_ReturnsExpectedResults(){
        //Arrange
        Long studentId = 1L;

        List<SubjectDTO> subjects = List.of(
                    new SubjectDTO("Math", 9.0),
                    new SubjectDTO("English", 8.5),
                    new SubjectDTO("Science", 10.0)
                );

        StudentDTO student = new StudentDTO(studentId, "Pepe", null, null,  subjects );

        when(studentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertNotNull(result);
        assertEquals("Pepe", result.getStudentName());
        assertEquals(9.166666666666666, result.getAverageScore());
        assertTrue(result.getMessage().contains("Felicitaciones"));
    }

    @DisplayName("-Datos validos- Verifica se genere un mensaje motivacional cuando el promedio es bajo")
    @Test
    public void analyzeScores_WithLowAverage_ReturnsMotivationMessage(){
        //Arrage

        Long studentID = 2L;

        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Math", 5.5),
                new SubjectDTO("English", 5.5),
                new SubjectDTO("Science", 5.5)
                );
        StudentDTO student = new StudentDTO(studentID, "Pepe", null, null, subjects);

        when(studentDAO.findById(studentID)).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentID);

        //Assert
        assertNotNull(result);
        assertEquals(5.5, result.getAverageScore());
        assertEquals("Pepe", result.getStudentName());
        assertTrue(result.getMessage().contains("Puedes mejorar"));
    }

/*    @Test
    void analyzeScores_WithNullStudent_ThrowsExceptions(){
        //Arrage
        Long studentId = 3L;
        StudentDTO student = new StudentDTO(studentId, "Pepe", "Empty List Of subject", null, Collections.emptyList());
        when(studentDAO.findById(studentId)).thenReturn(null);

        //Art && Assert
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(studentId));
    }*/


}

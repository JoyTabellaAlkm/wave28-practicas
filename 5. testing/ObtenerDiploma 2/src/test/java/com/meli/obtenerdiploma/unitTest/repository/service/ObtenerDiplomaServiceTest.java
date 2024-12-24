package com.meli.obtenerdiploma.unitTest.repository.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    // creo alumnos de prueba
    private static final StudentDTO alumnoJuan=
            new StudentDTO( 1L, "Juan", "",0.0,
                    List.of(new SubjectDTO( "Matemáticas", 10.0),
                            new SubjectDTO( "Historia", 8.0)));
    private static final StudentDTO alumnoAna =
            new StudentDTO( 1L, "Ana", "mensaje2",9.0,
                    List.of(new SubjectDTO( "Matemáticas", 9.0),
                            new SubjectDTO( "Fisica", 7.0)));


    @Mock // importo el repository.
    IStudentDAO studentRepositoryImpl;

    @Mock
    ModelMapper modelMapper= new ModelMapper();

    @InjectMocks //Siempre es la clase ya que tine el constructor
    ObtenerDiplomaService studentService;


    @Test
    @DisplayName("01 - Test Service : score OK")
    public void analyzeScores() {
        //arrange
        Long parametro = 1L;


        StudentDTO esperado =new StudentDTO( 1L, "Juan", "El alumno Juan ha obtenido un promedio de 9. Puedes mejorar.",9.0,
                List.of(new SubjectDTO( "Matemáticas", 10.0),
                        new SubjectDTO( "Historia", 8.0)));

        //act
        when(studentRepositoryImpl.findById(parametro)).thenReturn(alumnoJuan);
        StudentDTO  scores = studentService.analyzeScores(parametro);

        //assert
        Assertions.assertEquals(scores, esperado);


    }

    @Test
    @DisplayName("02 -  Test service: scored bad")
    public void analyzeScoresBad() {
        //arrange
        Long parametro = 5L;


        //act
        when(studentRepositoryImpl.findById(parametro)).thenReturn(null);

        //ASSERT
        assertThrows(RuntimeException.class,
                () -> studentService.analyzeScores(parametro));
    }

    @Test
    @DisplayName("03 - Test promedio ok")
    public void calculateAverage(){
        //arrange
        List<SubjectDTO> parametro = new ArrayList<>();
        List<SubjectDTO> juanSubjects= alumnoJuan.getSubjects();

        for(SubjectDTO subject : juanSubjects){
            parametro.add(subject);
        }


        double esperado= 9.0;

        //act
        double obtenido= studentService.calculateAverage(parametro);

        //assert
        Assertions.assertEquals(esperado, obtenido);

    }

    @Test
    @DisplayName("04 - Mensaje felicitaciones ok")
    public void getGreetingMessage(){
        //arrange
        String studentName="Juan";
        Double average=9.0;

        String esperado="El alumno Juan ha obtenido un promedio de 9. Puedes mejorar.";

        //act
        String obtenido= studentService.getGreetingMessage(studentName,average);

        //assert
        Assertions.assertEquals(esperado, obtenido);

    }




}

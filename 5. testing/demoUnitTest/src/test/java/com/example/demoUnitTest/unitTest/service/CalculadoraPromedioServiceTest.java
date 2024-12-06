package com.example.demoUnitTest.unitTest.service;

import com.example.demoUnitTest.dto.AlumnoDTO;
import com.example.demoUnitTest.dto.CursoDTO;
import com.example.demoUnitTest.dto.ResponseDTO;
import com.example.demoUnitTest.model.Alumno;
import com.example.demoUnitTest.model.Curso;
import com.example.demoUnitTest.repository.AlumnoRepositoryImpl;
import com.example.demoUnitTest.service.CalculadoraPromedioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculadoraPromedioServiceTest {

    private static final Alumno alumnoDeEntrada = new Alumno(1, "Juan", "Martinez",
            List.of(new Curso(101, "Matemáticas", 10.0),
                    new Curso(102, "Historia", 10.0)
            ));

    private static final Alumno alumnoDeEntrada2 = new Alumno(2, "María", "González",
            List.of(new Curso(102, "Historia", 1.0),
                    new Curso(105, "Ciencias Naturales", 1.0)
            ));

    @Mock //Puede ser la clase o la Interface, es lo mismo lo que importa es q los metodos esten declarados.
    AlumnoRepositoryImpl AlumnoRepositoryImpl;

    @Mock
    ModelMapper modelMapper = new ModelMapper();

    @InjectMocks //Siempre es la clase ya que tiene el constructor
    CalculadoraPromedioServiceImpl calculadoraPromedioService;


    @Test
    @DisplayName("01 - Test Service : promedio de Alumno OK")
    public void promedioDeAlumnoTestOK() {
        //ARRANGE
        Integer idDeEntrada = 1;
        Double promedioEsperado = 10.0;

        //ACT
        when(AlumnoRepositoryImpl.findById(idDeEntrada)).thenReturn(alumnoDeEntrada);
        //Mockito.when(AlumnoRepositoryImpl.findById(15)).thenReturn(alumnoDeEntrada2);
        Double promedioObtenido = calculadoraPromedioService.promedioDeAlumno(idDeEntrada);


        //ASSERT
        Assertions.assertEquals(promedioEsperado, promedioObtenido, "El promedio no es el esperado");
    }


    /* Double promedioDeAlumno(Integer id) -> Metodo a testear que provee información de que parametro entra y que devuelve.
     * RuntimeException("Alumno no encontrado") -> Excepcion que genera en caso de fallar */

    @Test
    @DisplayName("02 - Test Service : promedio de Alumno Fail")
    public void promedioDeAlumnoTestException() {
        //ARRANGE
        Integer idDeEntrada = 4;

        //ACT
        Mockito.when(AlumnoRepositoryImpl.findById(idDeEntrada)).thenReturn(null);

        //ASSERT
        Assertions.assertThrows(RuntimeException.class,
                () -> calculadoraPromedioService.promedioDeAlumno(idDeEntrada));

    }

    @Test
    @DisplayName("03 - Test Service:  Agregar alumno OK")
    public void addAlumnoTestOk() {
        //ARRANGE
        AlumnoDTO alumnoDto = new AlumnoDTO(1, "Juan", "Martinez",
                List.of(new CursoDTO(101, "Matemáticas", 10.0),
                        new CursoDTO(102, "Historia", 10.0)
                ));
        ResponseDTO responseEsperada = new ResponseDTO("Alumno guardado");
        Alumno alumnoDeEntrada = modelMapper.map(alumnoDto, Alumno.class);

        //ACT
        when(AlumnoRepositoryImpl.save(alumnoDeEntrada)).thenReturn(alumnoDeEntrada);
        ResponseDTO responseObtenida = calculadoraPromedioService.addAlumno(alumnoDto);

        //ASSERT
        Assertions.assertEquals(responseEsperada, responseObtenida);
    }


}

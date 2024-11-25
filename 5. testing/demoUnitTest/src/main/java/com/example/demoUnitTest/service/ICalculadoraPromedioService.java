package com.example.demoUnitTest.service;

import com.example.demoUnitTest.dto.AlumnoDTO;
import com.example.demoUnitTest.dto.ResponseDTO;

public interface ICalculadoraPromedioService {

    Double promedioDeAlumno(Integer id);

    Double promedio(Double n1, Double n2);

    Double sumar(Double n1, Double n2);

    ResponseDTO addAlumno(AlumnoDTO alumnoDto);

}

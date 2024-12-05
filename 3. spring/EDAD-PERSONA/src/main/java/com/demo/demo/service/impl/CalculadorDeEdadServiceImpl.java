package com.demo.demo.service.impl;

import com.demo.demo.service.ICalculadorDeEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculadorDeEdadServiceImpl implements ICalculadorDeEdadService {

    @Override
    public int calcularEdad(LocalDate fechaDeNacimiento) {
        Period edad = Period.between(fechaDeNacimiento, LocalDate.now());
        return edad.getYears();
    }
}
package com.example.edad.services.impl;

import com.example.edad.services.ICalcularEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalcularEdadServiceImpl implements ICalcularEdadService {

    @Override
    public int calcularEdad(int day, int month, int year){
        LocalDate fechaInicio = LocalDate.of(year, month, day);

        LocalDate fechaFin = LocalDate.now();

        int diferenciaAnios = Period.between(fechaInicio, fechaFin).getYears();

        return diferenciaAnios;
    }
}

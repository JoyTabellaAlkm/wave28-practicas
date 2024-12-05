package com.spring.ejercicios.Services.impl;

import com.spring.ejercicios.Services.iCalculadoraEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculadoraEdadServiceImpl implements iCalculadoraEdadService {

    public int calcularEdad(int dia, int mes, int anio){
        LocalDate fechaHoy = LocalDate.now();
        try {
            LocalDate fechaelegida = LocalDate.of(anio, mes, dia);
            Period period = Period.between(fechaelegida, fechaHoy);
            return period.getYears();
        }
        catch (Exception e){
            return -1;
        }
    }
}

package com.spring.ejercicios.Services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculadoraEdadService {

    public int calcularEdad(int dia, int mes, int anio){
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaelegida = LocalDate.of(anio,mes,dia);
        Period period = Period.between(fechaelegida, fechaHoy);
        return period.getYears();
    }
}

package com.mercadolibre.edadpersona.Services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService {
    public Integer calcularEdad(int dia, int mes, int ano){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(ano,mes,dia);

        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}

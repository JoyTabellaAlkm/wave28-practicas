package com.bootcamp.calculoedad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.temporal.TemporalUnit;

@Service
public class EdadService {

    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        int edadCalculada;

        try {
            LocalDate fechaIngresada = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();
            edadCalculada = Period.between(fechaIngresada, fechaActual).getYears();

        } catch (Exception e) {
            throw new IllegalArgumentException("Ingrese una fecha valida");
        }

        return  edadCalculada;
    }
}

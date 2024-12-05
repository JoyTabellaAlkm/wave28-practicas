package com.calcularedad.calcularedad.service;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EdadService {
    public static int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate nacimiento = LocalDate.of(anio,mes,dia);
        return (int) ChronoUnit.YEARS.between(nacimiento, fechaActual);
    }
}

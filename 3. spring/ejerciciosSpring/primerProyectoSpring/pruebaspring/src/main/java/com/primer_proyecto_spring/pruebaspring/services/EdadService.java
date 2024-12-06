package com.primer_proyecto_spring.pruebaspring.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class EdadService {

    // Método para calcular la edad a partir de la fecha de nacimiento (día, mes, año)
    public static int calcularEdad(String dia, String mes, String año) {

        int diaInt = Integer.parseInt(dia);
        int mesInt = Integer.parseInt(mes);
        int añoInt = Integer.parseInt(año);

        LocalDate fechaNacimiento = LocalDate.of(añoInt, mesInt, diaInt);

        LocalDate fechaActual = LocalDate.now();

        int edad = (int) ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);

        if (fechaActual.isBefore(fechaNacimiento.plusYears(edad))) {
            edad--;
        }

        return edad;
    }
}

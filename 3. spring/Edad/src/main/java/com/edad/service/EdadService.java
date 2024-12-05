package com.edad.service;

import java.time.LocalDate;
import java.time.Period;

public class EdadService {
    public static int CalcularEdad(int dia, int mes, int anio) {
        LocalDate localTime = LocalDate.now();
        LocalDate birthdayTime = LocalDate.of(anio, mes, dia);

        if (birthdayTime.isAfter(localTime)) {
            return -1;
        }

        Period edad = Period.between(birthdayTime, localTime);
        return edad.getYears();
    }
}
package com.mercadolibre.person_age.services;

import java.time.LocalDate;
import java.time.Period;

public class CalculateService {

    public static int calculateAge(int day, int month, int year){
        int result = 0;
        LocalDate fecha = LocalDate.of(year,month,day);
        LocalDate fechaActual = LocalDate.now();

        Period diferencia = Period.between(fecha, fechaActual);
        return diferencia.getYears();

    }

}

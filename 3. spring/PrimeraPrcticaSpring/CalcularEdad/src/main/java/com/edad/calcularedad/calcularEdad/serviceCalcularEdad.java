package com.edad.calcularedad.calcularEdad;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class serviceCalcularEdad {

    public String calcularEdad(String fecha){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fecha, fmt);
        LocalDate actual = LocalDate.now();

        Period diferencia = Period.between(fechaNacimiento, actual);

        return "Usted tiene: " + diferencia.getYears() + " años, con: " + diferencia.getMonths() + " meses y " + diferencia.getDays() + " días.";
    }
}

package com.example.calcularedad.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


@Service
public class CalcularEdadService {

    public int calcularEdad(LocalDate fecha){

        Period intervalPeriod = Period.between(fecha, LocalDate.now());
        return intervalPeriod.getYears();

    }

    public int formatear(String dia, String mes, String anio){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<String> vars = Arrays.asList(dia, mes, anio);
        String date = String.join("/", vars);
        return calcularEdad(LocalDate.parse(date,formatter));
    }
}

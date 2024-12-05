package com.example.edad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
@Service
public class EdadService {

    private static LocalDate fechaActual = LocalDate.now();
    public int calcularEdad(int dia, int mes, int anio){
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        return edad;
    }
}

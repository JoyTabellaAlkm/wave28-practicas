package com.miprimerproyecto.proyectospring.ejCalculoEdad.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadServiceImpl {

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
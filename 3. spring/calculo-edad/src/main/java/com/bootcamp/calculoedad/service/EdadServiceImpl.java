package com.bootcamp.calculoedad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadServiceImpl implements IEdadService{

    public String calcularEdad(Integer dia, Integer mes, Integer anio) {
        int edadCalculada;

        try {
            LocalDate fechaIngresada = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();

            if (fechaIngresada.isAfter(fechaActual)) {
                throw new IllegalArgumentException("No se puede ingresar una fecha posterior a la actual");
            }
            edadCalculada = Period.between(fechaIngresada, fechaActual).getYears();

        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            throw new IllegalArgumentException("Ingrese una fecha valida");
        }

        return String.valueOf(edadCalculada);
    }
}

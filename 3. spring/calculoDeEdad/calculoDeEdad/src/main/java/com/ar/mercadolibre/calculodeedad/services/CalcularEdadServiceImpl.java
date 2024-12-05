package com.ar.mercadolibre.calculodeedad.services;

import java.time.LocalDate;
import java.time.Period;

public class CalcularEdadServiceImpl implements ICalcularEdadService{

    public CalcularEdadServiceImpl() {
    }

    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaDeNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaDeNacimiento, fechaActual);

        return periodo.getYears();
    }
}

package com.ar.mercadolibre.calculodeedad.services;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class CalcularEdadServiceImpl implements ICalcularEdadService{

    public CalcularEdadServiceImpl() {}

    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        int years = -1;
        try{
            LocalDate fechaDeNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();

            Period periodo = Period.between(fechaDeNacimiento, fechaActual);

            years = periodo.getYears();
            if(years < 1) {
                throw new DateTimeException("Fecha invalida");
            }
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
            return -1;
        }

        return years;

    }
}

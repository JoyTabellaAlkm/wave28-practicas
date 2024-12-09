package com.mercadolibre.edadpersona.service.impl;

import com.mercadolibre.edadpersona.service.IEdadPersonaService;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadPersonaServiceImpl implements IEdadPersonaService {

    @Override
    public String calcularEdadPersona(int dia, int mes, int anio) {

        if (dia>31 || dia<1){
            return "El valor del dia esta fuera los normales.";
        }
        if (mes>12 || mes <1){
            return "El valor del mes esta fuera de los normales.";
        }

        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimiento,fechaActual).getYears();

        return String.valueOf(edad);
    }

    @Override
    public Integer calcularEdadPersona1(int dia, int mes, int anio) {
        LocalDate fechaNacimiento;
        LocalDate fechaActual;

        try{
            fechaNacimiento =LocalDate.of(anio,mes,dia);
            fechaActual = LocalDate.now();
            if (fechaNacimiento.isAfter(fechaActual)){
                throw new DateTimeException("Error: Fecha superior a la actual.");
            }
        }catch (DateTimeException dateTimeException){
            return -1;
        }

        int edad = Period.between(fechaNacimiento,fechaActual).getYears();

        return edad;
    }
}

package com.ejercicioedaddeunapersona.calcularedad.services.impl;

import com.ejercicioedaddeunapersona.calcularedad.services.IEdadService;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class EdadServiceImpl implements IEdadService {
    public Integer calcularEdad(int dia, int mes, int ano){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento;
        try{
            fechaNacimiento = LocalDate.of(ano, mes, dia);

        }catch (DateTimeException e){
            return -1;
        }
        long years = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);

        return Math.toIntExact(years);
    }
}

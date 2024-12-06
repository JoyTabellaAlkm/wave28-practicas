package com.example.edad_persona.Service.impl;

import com.example.edad_persona.Service.IEdadService;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class EdadServiceImpl implements IEdadService {
    @Override
    public long calcularEdad(int day, int month, int year) {
        LocalDate fecha = LocalDate.of(year, month, day);
            LocalDate fechaActual = LocalDate.now();

            if(fecha.isAfter(fechaActual)) {
                return -1;
            }
            long añosRestantes = ChronoUnit.YEARS.between(fecha,fechaActual);


       //return añosRestantes;
        return añosRestantes;
    }
}

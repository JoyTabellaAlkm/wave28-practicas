package com.calcularedad.calcularedad.service.impl;

import com.calcularedad.calcularedad.service.IEdadService;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class EdadService implements IEdadService {
    public int calcularEdad(int dia, int mes, int anio) {
        if (anioValido(anio) && mesValido(mes) && diaValido(dia)){
            LocalDate fechaActual = LocalDate.now();
            LocalDate nacimiento = LocalDate.of(anio,mes,dia);
            return (int) ChronoUnit.YEARS.between(nacimiento, fechaActual);
        }
        return -1;
    }

    private boolean anioValido(int anio) {
        return !LocalDate.now().isBefore(LocalDate.of(1,1,anio));
    }

    private boolean mesValido(int mes) {
        return mes <= 12 && mes > 0;
    }

    private boolean diaValido(int dia){
        return dia <= 31 && dia > 0;
    }
}

package com.mercadolibre.edadpersona.services.impl;

import com.mercadolibre.edadpersona.services.IEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadServiceImpl implements IEdadService {

    public Integer calcularEdad(int dia, int mes, int ano){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(ano,mes,dia);

        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}

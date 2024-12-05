package com.edad.service.impl;

import com.edad.service.IEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService implements IEdadService {

    @Override
    public int calcularEdad(int dia, int mes, int anio) {

        // Aqui irian validaciones de dia, mes y anio

        LocalDate localTime = LocalDate.now();
        LocalDate birthdayTime = LocalDate.of(anio, mes, dia);

        if (birthdayTime.isAfter(localTime)) {
            return -1;
        }

        Period edad = Period.between(birthdayTime, localTime);
        return edad.getYears();
    }
}
package com.example.Ejercicios_EdadPersonas.Service.impl;

import com.example.Ejercicios_EdadPersonas.Service.IEdadService;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class EdadServiceImpl implements IEdadService {


    public String calcularEdad(int dia, int mes, int anio){

            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            if (fechaNacimiento.isAfter(LocalDate.now())){
                throw new DateTimeException("Se ingreso una fecha a futuro");
            }
            String edad = String.valueOf(fechaNacimiento.until(LocalDate.now()).getYears());
            return edad;

    }
}

package com.example.calcularedad.service;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

@Service
public class EdadService {
    public  String calcularEdad(Integer dia, Integer mes, Integer anio){

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento;

        Boolean cumplioAnios = false;

        try{
            fechaNacimiento = LocalDate.of(anio, mes, dia);
        }catch (DateTimeException e){
            return "Fecha invalida";
        }

        if(fechaActual.getDayOfMonth() > fechaNacimiento.getDayOfMonth()){
            cumplioAnios = true;
        }else if(fechaActual.getDayOfMonth() == fechaNacimiento.getDayOfMonth()){
            if(fechaActual.getDayOfMonth() >= fechaNacimiento.getDayOfMonth()){
                cumplioAnios = true;
            }
        }

        Integer edad = cumplioAnios ? fechaActual.getYear() - fechaNacimiento.getYear() : (fechaActual.getYear() - fechaNacimiento.getYear()) -1;

        return "Su edad actual es: " + edad;
    }
}

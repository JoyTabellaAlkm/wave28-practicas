package com.bootcamp.edadPersona.service.impl;

import com.bootcamp.edadPersona.service.IEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EdadServiceImpl implements IEdadService {
    @Override
    public String calcularEdad(int dia, int mes, int anio) {

        try{
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);
            int edadActual = fechaActual.getYear() - fechaNacimiento.getYear();

            return "La edad de la persona es: " + edadActual;
        } catch (Exception e) {
            return "fecha invalida";
        }
    }
}

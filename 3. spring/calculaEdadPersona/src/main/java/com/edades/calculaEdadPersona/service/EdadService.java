package com.edades.calculaEdadPersona.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EdadService {
    public String calculaEdad(int dia, int mes, int ano) {
        //System.out.println(fechaNacimiento);
        LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
        LocalDate fechaHoy = LocalDate.now();

        int anos = fechaHoy.compareTo(fechaNacimiento);

        return "La edad de la persona es de " + anos + " años.";
    }
}

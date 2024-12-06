package com.mercadolibre.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;
}

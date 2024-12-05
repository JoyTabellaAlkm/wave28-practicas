package com.melibootcamp.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<String> sintomas;

    public Persona(){
        sintomas = new ArrayList<>();
    }

    public Persona(int id, String nombre, String apellido, int edad, List<String> sintomas){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }
}

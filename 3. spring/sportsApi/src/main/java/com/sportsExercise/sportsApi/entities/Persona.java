package com.sportsExercise.sportsApi.entities;

import lombok.Getter;

public class Persona {
    // Getters y Setters
    @Getter
    private String nombre;
    @Getter
    private String apellido;
    @Getter
    private int edad;
    @Getter
    private Deporte deporte;

    // Constructor
    public Persona(String nombre, String apellido, int edad, Deporte deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }

}

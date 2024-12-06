package com.sportsExercise.sportsApi.entities;

import lombok.Getter;

public class Deporte {
    @Getter
    private String nombre;
    @Getter
    private String nivel;

    // Constructor
    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}

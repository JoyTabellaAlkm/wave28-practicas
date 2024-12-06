package com.deportistas.model;

import lombok.Data;

@Data
public class Deportista {
    private String nombre;
    private String nivel;

    public Deportista(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

}
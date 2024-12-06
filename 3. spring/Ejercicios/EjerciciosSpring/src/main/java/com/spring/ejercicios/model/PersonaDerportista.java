package com.spring.ejercicios.model;

import lombok.Data;

@Data

public class PersonaDerportista {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

    public PersonaDerportista(String nombre, String apellido, int edad, Deporte deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }
}

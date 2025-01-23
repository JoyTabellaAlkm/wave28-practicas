package com.bootcamp.deportes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private String name;
    private String apellido;
    private int edad;
    private Deporte deporte;

    public String getDeporteName() {
        return deporte.getName();
    }

    public String getFullName() {
        return name + " " + apellido;
    }
}

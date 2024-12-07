package com.meli.deportista.dto;

public class PersonaDto {
    private String Nombre;
    private String Apellido;
    private String Edad;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String edad) {
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }
}
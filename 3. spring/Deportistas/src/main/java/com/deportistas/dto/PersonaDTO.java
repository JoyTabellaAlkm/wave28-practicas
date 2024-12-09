package com.deportistas.model;

import java.util.List;

public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Deportista> deportes;

    public PersonaDTO(String nombre, String apellido, int edad, List<Deportista> deportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deportes = deportes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Deportista> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deportista> deportes) {
        this.deportes = deportes;
    }
}
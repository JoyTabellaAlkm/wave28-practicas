package com.example.covid.DTO;

public class SintomaDTO {
    int nivelDeGravedad;
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SintomaDTO(int nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
    public SintomaDTO(int nivelDeGravedad, String nombre) {
        this.nivelDeGravedad = nivelDeGravedad;
        this.nombre = nombre;
    }

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(int nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}

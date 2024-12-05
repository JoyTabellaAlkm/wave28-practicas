package com.bootcamp.ejerciciocovid19.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

public class SintomaDto {
    public String nombre;
    public int nivelDeGravedad;

    public SintomaDto(String nombre, int nivelDeGravedad) {
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    @Override
    public String toString() {
        return "SintomaDto{" +
                "nombre='" + nombre + '\'' +
                ", nivelDeGravedad=" + nivelDeGravedad +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(int nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}

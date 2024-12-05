package com.bootcamp.ejerciciocovid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class Sintoma {
    private String codigo;
    private String nombre;
    private int nivelDeGravedad;


    public Sintoma(String codigo, String nombre, int nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nivelDeGravedad=" + nivelDeGravedad +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

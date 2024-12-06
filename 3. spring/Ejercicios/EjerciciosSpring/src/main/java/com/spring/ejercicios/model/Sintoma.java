package com.spring.ejercicios.model;

public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivelGravedad;

    public Sintoma(int codigo, String nombre, int nivelGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelGravedad() {
        return nivelGravedad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivelGravedad(int nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }

    @Override
    public String toString() {
        return "Sintoma " + codigo +
                ", nombre= " + nombre + '\'' +
                ", nivelGravedad= " + nivelGravedad;
    }
}

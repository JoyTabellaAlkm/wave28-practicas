package com.ejercicios.covid19.models;

public class Sintoma {
    private Integer codigo;
    private String nombre;
    private Integer nivelDeGravedad;

    public Sintoma(Integer codigo, String nombre, Integer nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(Integer nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}

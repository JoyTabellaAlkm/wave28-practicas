package com.demo.demo.entity;

public class Sintoma {
    int codigo;
    String nombre;
    int nivel_de_gravedad;

    public Sintoma(int codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(int nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}

package com.bootcamp.ejercicio_deportistas.Models;

public class Deporte {
    private Integer id;
    private String nombre;
    private String nivel;

    public Deporte(Integer id, String nombre, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}

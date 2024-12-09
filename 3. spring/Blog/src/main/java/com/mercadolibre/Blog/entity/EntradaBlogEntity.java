package com.mercadolibre.Blog.entity;

import java.time.LocalDate;
import java.util.Date;

public class EntradaBlogEntity {

    private int id;
    private String titulo;
    private String nombre;
    private LocalDate fechaPublicacion;

    public EntradaBlogEntity(int id, String titulo, String nombre, LocalDate fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
    }

    public EntradaBlogEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}

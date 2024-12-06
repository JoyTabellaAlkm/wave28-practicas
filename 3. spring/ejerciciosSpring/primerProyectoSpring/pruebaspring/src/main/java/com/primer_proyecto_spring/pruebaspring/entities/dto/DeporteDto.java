package com.primer_proyecto_spring.pruebaspring.entities.dto;

import lombok.*;

@ToString
public class DeporteDto {
    private String nombre;
    private String nivel;

    public DeporteDto(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
    public DeporteDto() {
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

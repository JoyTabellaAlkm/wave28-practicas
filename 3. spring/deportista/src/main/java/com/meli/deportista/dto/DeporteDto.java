package com.meli.deportista.dto;



public class DeporteDto {
    private String nombre;
    private String nivel;

    public DeporteDto() {
    }

    public DeporteDto(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
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
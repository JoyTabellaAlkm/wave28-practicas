package com.example.empleadoselasticsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class EmpleadoDto {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EmpleadoDto(String nombre) {
        this.nombre = nombre;
    }

    public EmpleadoDto() {
    }
}

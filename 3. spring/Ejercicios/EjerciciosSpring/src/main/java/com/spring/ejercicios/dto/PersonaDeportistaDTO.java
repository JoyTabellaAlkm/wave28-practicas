package com.spring.ejercicios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class PersonaDeportistaDTO {
    private String nombrePersona;
    private String apellido;
    private String nombreDeporte;

    public PersonaDeportistaDTO(String nombrePersona, String apellido, String nombreDeporte) {
        this.nombrePersona = nombrePersona;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }
}

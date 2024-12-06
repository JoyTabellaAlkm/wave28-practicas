package com.example.ejerciciocovod.Clases;

public class PersonaDeportistaDTO {
    private String nombreCompleto;
    private String nombreDeporte;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public PersonaDeportistaDTO(String nombreCompleto, String nombreDeporte) {
        this.nombreCompleto = nombreCompleto;
        this.nombreDeporte = nombreDeporte;
    }
}

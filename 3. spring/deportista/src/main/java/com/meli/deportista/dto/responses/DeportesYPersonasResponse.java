package com.meli.deportista.dto.responses;

public class DeportesYPersonasResponse {
    private String nombre;
    private String apellido;
    private String deporte;

    public DeportesYPersonasResponse() {
    }

    public DeportesYPersonasResponse(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
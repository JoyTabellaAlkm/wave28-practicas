package org.example.models;

abstract public class Reserva {

    String tipo;

    public Reserva(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
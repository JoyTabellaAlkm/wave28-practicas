package com.mercadolibre.reservas;

public abstract class Reserva {

    protected double precio;

    public Reserva(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}

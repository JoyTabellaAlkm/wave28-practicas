package com.mercadolibre.reservas;

public class ReservaComida extends Reserva {

    public ReservaComida(double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "ReservaComida{" +
                "precio=" + precio +
                '}';
    }

}

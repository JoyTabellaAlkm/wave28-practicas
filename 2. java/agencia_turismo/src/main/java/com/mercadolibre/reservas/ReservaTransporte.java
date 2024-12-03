package com.mercadolibre.reservas;

public class ReservaTransporte extends Reserva {

    public ReservaTransporte(double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "ReservaTransporte{" +
                "precio=" + precio +
                '}';
    }

}

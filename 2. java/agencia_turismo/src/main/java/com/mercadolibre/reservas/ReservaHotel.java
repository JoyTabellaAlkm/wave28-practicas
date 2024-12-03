package com.mercadolibre.reservas;

public class ReservaHotel extends Reserva {

    public ReservaHotel(double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "precio=" + precio +
                '}';
    }

}

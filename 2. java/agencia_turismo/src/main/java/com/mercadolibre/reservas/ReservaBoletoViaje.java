package com.mercadolibre.reservas;

public class ReservaBoletoViaje extends Reserva {

    public ReservaBoletoViaje(double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "ReservaBoletoViaje{" +
                "precio=" + precio +
                '}';
    }

}

package com.mercadolibre;

import com.mercadolibre.clientes.Cliente;
import com.mercadolibre.clientes.ClienteRepositorio;
import com.mercadolibre.localizadores.Localizador;
import com.mercadolibre.reservas.ReservaBoletoViaje;
import com.mercadolibre.reservas.ReservaComida;
import com.mercadolibre.reservas.ReservaHotel;
import com.mercadolibre.reservas.ReservaTransporte;

public class Main {
    public static void main(String[] args) {
        ClienteRepositorio repo = new ClienteRepositorio();

        Cliente cliente1 = new Cliente("12345", "Nicolás", "Albarracin", 23);
        Localizador compra1 = new Localizador(cliente1);
        compra1.agregarReserva(new ReservaHotel(2400));
        compra1.agregarReserva(new ReservaHotel(3000));
        compra1.agregarReserva(new ReservaBoletoViaje(2400));
        compra1.agregarReserva(new ReservaBoletoViaje(3000));
        repo.crearLocalizador(cliente1, compra1);

        Localizador compra2 = new Localizador(cliente1);
        compra2.agregarReserva(new ReservaHotel(3000));
        compra2.agregarReserva(new ReservaComida(4000));
        compra2.agregarReserva(new ReservaBoletoViaje(1500));
        compra2.agregarReserva(new ReservaTransporte(1000));
        repo.crearLocalizador(cliente1, compra2);

        Localizador compra3 = new Localizador(cliente1);
        compra3.agregarReserva(new ReservaHotel(2500));
        repo.crearLocalizador(cliente1, compra3);

        Localizador compra4 = new Localizador(cliente1);
        compra4.agregarReserva(new ReservaComida(1000));
        repo.crearLocalizador(cliente1, compra4);
    }
}

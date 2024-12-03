package com.mercadolibre.localizadores;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.clientes.Cliente;
import com.mercadolibre.reservas.Reserva;
import com.mercadolibre.reservas.ReservaBoletoViaje;
import com.mercadolibre.reservas.ReservaComida;
import com.mercadolibre.reservas.ReservaHotel;
import com.mercadolibre.reservas.ReservaTransporte;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;

        reservas = new ArrayList<>();
        total = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean esPaqueteCompleto() {
        if (reservas.size() < 4) {
            return false;
        }

        boolean hayReservaHotel = reservas.stream()
                .anyMatch(reserva -> {
                    return reserva instanceof ReservaHotel;
                });

        boolean hayReservaComida = reservas.stream()
                .anyMatch(reserva -> {
                    return reserva instanceof ReservaComida;
                });

        boolean hayReservaBoletoViaje = reservas.stream()
                .anyMatch(reserva -> {
                    return reserva instanceof ReservaBoletoViaje;
                });

        boolean hayReservaTransporte = reservas.stream()
                .anyMatch(reserva -> {
                    return reserva instanceof ReservaTransporte;
                });

        return hayReservaHotel && hayReservaComida && hayReservaBoletoViaje && hayReservaTransporte;
    }

    public boolean esPaqueteDobleHotel() {
        if (reservas.size() < 2) {
            return false;
        }

        boolean hayDobleReservaHotel = reservas.stream()
                .filter(reserva -> {
                    return reserva instanceof ReservaHotel;
                }).count() >= 2;

        return hayDobleReservaHotel;
    }

    public boolean esPaqueteDobleBoletoViaje() {
        if (reservas.size() < 2) {
            return false;
        }

        boolean hayDobleReservaBoletoViaje = reservas.stream()
                .filter(reserva -> {
                    return reserva instanceof ReservaBoletoViaje;
                }).count() >= 2;

        return hayDobleReservaBoletoViaje;
    }

    public void calcularTotal() {
        total = reservas.stream()
                .mapToDouble(reserva -> reserva.getPrecio())
                .sum();

        if (esPaqueteCompleto()) {
            // System.out.println("El localizador " + this + " es paquete completo.");
            total = total * 0.9;
        } else if (esPaqueteDobleHotel()) {
            // System.out.println("El localizador " + this + " es paquete doble de hotel.");
            total = reservas.stream()
                    .mapToDouble(reserva -> {
                        if (reserva instanceof ReservaHotel) {
                            return reserva.getPrecio() * 0.95;
                        }

                        return reserva.getPrecio();
                    }).sum();
        } else if (esPaqueteDobleBoletoViaje()) {
            // System.out.println("El localizador " + this + " es paquete doble de boleto
            // viaje.");
            total = reservas.stream()
                    .mapToDouble(reserva -> {
                        if (reserva instanceof ReservaBoletoViaje) {
                            return reserva.getPrecio() * 0.95;
                        }

                        return reserva.getPrecio();
                    }).sum();
        } else {
            // System.out.println("El localizador " + this + " es normal.");
        }
    }

    @Override
    public String toString() {
        return "Localizador [cliente=" + cliente + ", reservas=" + reservas + ", total=" + total + "]";
    }

}

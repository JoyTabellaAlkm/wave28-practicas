package com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.domain;

import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.domain.reserva.Reservable;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Integer id;
    private Cliente cliente;
    private Double total;
    private List<Reservable> reservas;
    private static Integer TOTAL_LOCALIZADORES = 0;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.total = 0.0;
        this.reservas = new ArrayList<>();
        this.id = TOTAL_LOCALIZADORES;
        TOTAL_LOCALIZADORES++;
    }

    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Double getTotal() {
        double total = reservas.stream().mapToDouble(Reservable::calcularPrecio).sum();
        boolean isPaqueteCompleto = reservas.stream().map(Reservable::getTipo).distinct().count() == 4;
        if(isPaqueteCompleto) {
            total *= 0.90;
        }
        return total;
    }

    public List<Reservable> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reservable reservable) {
        this.reservas.add(reservable);
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", id=" + id +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }
}

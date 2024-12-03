package org.example;

import java.util.List;

public class Localizador {

    private List<Reserva> listaReservas;
    private Cliente cliente;
    private int total;

    public Localizador(List<Reserva> listaReservas, Cliente cliente) {
        this.listaReservas = listaReservas;
        this.cliente = cliente;
        this.total=listaReservas.stream().mapToInt(r-> r.getPrecio()).sum();
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "listaReservas=" + listaReservas +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }
}

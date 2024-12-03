package Modelo;

import Modelo.Reserva.Reserva;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private Double total;
    private boolean esPaqueteCompleto;
    private List<Reserva> reservas;

    public Localizador() {
    }

    public Localizador(Cliente cliente, Double total, List<Reserva> reservas, boolean esPaqueteCompleto) {
        this.cliente = cliente;
        this.total = total;
        this.reservas = reservas;
        this.esPaqueteCompleto = esPaqueteCompleto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void calcularTotal(Double descuento) {
        this.total = reservas.stream().mapToDouble(r -> r.getCosto()).sum();
        this.total = this.total - (this.total * descuento);
    }

    public boolean isEsPaqueteCompleto() {
        return esPaqueteCompleto;
    }

    public void setEsPaqueteCompleto(boolean esPaqueteCompleto) {
        this.esPaqueteCompleto = esPaqueteCompleto;
    }


    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }

    public String detalle(){
        return "Cliente: "+ cliente.getNombre() +" DNI: "+ cliente.getDni() + " Reservas: " + reservas.size() +" Total:" + total +(esPaqueteCompleto ? " Es Paquete Completo": "");
    }
}

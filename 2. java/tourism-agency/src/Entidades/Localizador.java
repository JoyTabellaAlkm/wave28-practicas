package Entidades;

import java.util.List;

public class Localizador {
    // ATTRIBUTES
    private int uid;
    private Cliente cliente;
    private double costeTotal;
    private List<Reserva> reservas;

    // CONSTRUCTOR
    public Localizador(int uid, Cliente cliente, List<Reserva> reservas) {
        this.uid = uid;
        this.cliente = cliente;
        this.costeTotal = reservas.stream()
                .mapToDouble(x -> x.obtenerCostoTotal())
                .sum();
        this.reservas = reservas;
    }

    public Localizador(int uid, Cliente cliente, Reserva reserva) {
        this.uid = uid;
        this.cliente = cliente;
        this.costeTotal = reserva.obtenerCostoTotal();
        this.reservas = reservas;
    }

    public Localizador(){

    }

    // METHOD
    public void agregarReservas(Reserva reserva){
        this.reservas.add(reserva);
    }

    // TO STRING


    @Override
    public String toString() {
        return "[Localizador] " +
                "Uid: " + uid +
                ", Cliente: " + cliente +
                ", Coste Total: " + costeTotal +
                ", Reservas: " + reservas.stream()
                .map(x -> x.toString());
    }

    // GETS & SETS
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}

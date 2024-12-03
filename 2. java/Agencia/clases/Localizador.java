package clases;

import java.util.List;

public class Localizador {
    private int id;
    private int clienteId;
    private List<Reserva> reservas;

    private double price;

    public Localizador(int id, int clienteId, List<Reserva> reservas){
        this.id = id;
        this.clienteId = clienteId;
        this.reservas = reservas;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public int getId() {
        return id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", clienteId" + this.clienteId + ", Reservas: " + this.reservas;
    }
}

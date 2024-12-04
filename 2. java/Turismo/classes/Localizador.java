package classes;

import repositories.LocalizadorRepo;

import java.util.List;

public class Localizador {
    private LocalizadorRepo repo;
    private int id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    private boolean paquete;


    public Localizador(Cliente cliente, List<Reserva> reservas, boolean paquete, LocalizadorRepo repo) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.paquete = paquete;
        this.repo = repo;
        this.total = calcularTotalConDescuento();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double calcularTotalConDescuento() {
        double total = reservas.stream().mapToDouble(Reserva::getPrecio).sum();

        if (repo.buscarCantidadPorCliente(cliente)>= 2){
            total = total * 0.95;
        }

        if (paquete) {
            total = total * 0.9;
        } else {
            long hoteles = reservas.stream().filter(r -> r.getTipo().equals("Hotel")).count();
            long boletos = reservas.stream().filter(r -> r.getTipo().equals("Boleto")).count();
            if (hoteles>=2||boletos>=2){
                total = total * 0.95;
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "repo=" + repo +
                ", id=" + id +
                ", cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                ", paquete=" + paquete +
                '}';
    }
}

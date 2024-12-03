import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private double total;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public Localizador setCliente(Cliente cliente) {

        return this;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Localizador setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
        return this;
    }

    public double getTotal() {
        return total;
    }

    public Localizador setTotal(double total) {
        this.total = total;
        return this;
    }
}

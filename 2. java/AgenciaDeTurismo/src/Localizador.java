import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private String id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;
    private double descuento;

    public Localizador(String id, Cliente cliente, List<Reserva> reservas, double total, double descuento) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = total;
        this.descuento = descuento;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double getTotal() {
        return total;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public String toString(){
        return "Localizador{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente.getNombre() +
                ", reservas=" + reservas.stream().map(Reserva::getTipo).collect(Collectors.joining(", ")) +
                ", total=" + total +
                ", descuento=" + descuento +
                '}';
    }
}

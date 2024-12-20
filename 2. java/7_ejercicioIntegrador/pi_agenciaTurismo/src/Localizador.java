import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;
    private double descuento;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.total = 0;
        this.descuento = 0;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        total += reserva.getCosto();
    }

    public void aplicarDescuento(double porcentaje) {
        descuento += total * porcentaje / 100;
        total -= descuento;
    }

    public double getTotal() {
        return total;
    }

    public double getDescuento() {
        return descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void imprimirLocalizador() {
        System.out.println("----- Detalles del Localizador -----");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("- " + reserva.getTipo() + ": $" + reserva.getCosto());
        }
        System.out.println("Descuento aplicado: $" + descuento);
        System.out.println("Total final: $" + total);
        System.out.println("------------------------------------");
    }
}


import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
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

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                '}';
    }

    public boolean esPaqueteCompleto() {
        boolean tieneHotel = false;
        boolean tieneComida = false;
        boolean tieneBoleto = false;
        boolean tieneTransporte = false;

        for (Reserva reserva : reservas) {
            switch (reserva.getTipo()) {
                case HOTEL -> tieneHotel = true;
                case COMIDA -> tieneComida = true;
                case TRANSPORTE -> tieneTransporte = true;
                case BOLETO_VIAJE -> tieneBoleto = true;
            }
        }

        return tieneHotel && tieneBoleto &&  tieneComida && tieneTransporte;
    }

    public boolean tieneNTipoReservas(int n, TiposReserva tipo) {
        return reservas.
                stream().
                filter(r -> r.getTipo().equals(tipo)).
                count() == n;
    }
}

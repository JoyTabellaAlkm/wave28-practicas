import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;
    private double precioTotal;

    public Localizador(List<Reserva> reservas, Cliente cliente, double precioTotal) {
        this.reservas = reservas;
        this.cliente = cliente;
        this.precioTotal = precioTotal;
    }

    public boolean esPaquete(){
        for (ReservaEnum e : ReservaEnum.values()) {
            if (reservas.stream().anyMatch(r -> r.tipoReserva.equals(e))){
                return true;
            }
        }
        return true;
    }

    


}

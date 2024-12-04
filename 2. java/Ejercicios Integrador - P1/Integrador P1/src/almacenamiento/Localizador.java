package almacenamiento;

import cliente.Cliente;
import reservas.Reserva;
import reservas.ReservaBoletos;
import reservas.ReservaHotel;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        total = 0;
        reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva){
        validarPromocion();
        this.reservas.add(reserva);
        calcularTotal();
    }

    public void validarPromocion(){
        if(reservas.stream().filter(ReservaHotel.class::isInstance).count() > 1){
            for(Reserva reserva : reservas){
                if(reserva.getClass().isInstance(ReservaHotel.class)) reserva.setPrecio(reserva.getPrecio()*0.95);
            }
            calcularTotal();
        }
        if(reservas.stream().filter(ReservaBoletos.class::isInstance).count() > 1){
            for(Reserva reserva : reservas){
                if(reserva.getClass().isInstance(ReservaBoletos.class)) reserva.setPrecio(reserva.getPrecio()*0.95);
            }
            calcularTotal();
        }
    }

    public void calcularTotal(){
        this.total = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }
}

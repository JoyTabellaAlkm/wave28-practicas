package agenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private Double precio;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, Double precio, List<Reserva> reservas) {
        this.cliente = cliente;
        this.precio = precio;
        this.reservas = reservas;
    }

    public Localizador() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", precio=" + precio +
                ", reservas=" + reservas +
                '}';
    }

    public void calcularDescuento(){
        Double total;
        if(reservas.stream().anyMatch(x->x.getClases()== 1) &&
                reservas.stream().anyMatch(x->x.getClases()== 2) &&
                reservas.stream().anyMatch(x->x.getClases()== 3) &&
                reservas.stream().anyMatch(x->x.getClases()== 4)
        ){
            total = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
            total = total * 0.9 ;
            this.precio = total;


        }
        else {

            reservas.forEach();



        }


    }
}

package Clases;

import java.lang.reflect.Type;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double montoTotal = 0.0;

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

    public double getMontoTotal() {
        return montoTotal;
    }

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.montoTotal = calcularMonto(reservas);
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                ", montoTotal=" + montoTotal +
                '}';
    }

    public double calcularMonto(List<Reserva> reservas){
        boolean transporte = false;
        boolean comida= false;
        boolean vuelos = false;
        boolean hotel = false;
        boolean paqueteCompleto = false;

        if (reservas.size() >= 4) {
            for (Reserva r : reservas) {
                if (ReservaBoletosViaje.class.equals(r.getClass())) {
                    vuelos = true;
                } else if (ReservaTransporte.class.equals(r.getClass())) {
                    transporte = true;
                } else if (ReservaComida.class.equals(r.getClass())) {
                    comida = true;
                } else if (ReservaHotel.class.equals(r.getClass())) {
                    hotel = true;
                }
            }
        }

        paqueteCompleto = hotel && comida && transporte && vuelos;
        int i = 0;

        if ((reservas.stream().filter(x->ReservaBoletosViaje.class.equals(x.getClass())).count() >= 2) || (reservas.stream().filter(x->ReservaHotel.class.equals(x.getClass())).count() >= 2))
        {
            for (Reserva r:reservas) {
                if(ReservaBoletosViaje.class.equals(r.getClass()) || ReservaHotel.class.equals(r.getClass())){
                    r.setCosto(r.getCosto()*0.95);
                    System.out.println(r.getCosto() + "hola" + i);
                    i++;
                }
            }
        }

        reservas.forEach(x->montoTotal+=x.getCosto());
        montoTotal = cliente.getLocalizadores().stream().count() >= 2 ? montoTotal * 0.95 : montoTotal;
        montoTotal = paqueteCompleto ? montoTotal * 0.90 : montoTotal;
        return montoTotal;
    }
}

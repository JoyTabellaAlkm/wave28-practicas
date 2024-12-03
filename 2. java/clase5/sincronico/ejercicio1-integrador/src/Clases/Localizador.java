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

        System.out.println(reservas.size());

        if (reservas.size() >= 4) {
            System.out.println("Entre al switch");
            for (Reserva r : reservas) {

                System.out.println("Entre al for");
                System.out.println(r.getClass().getName());
                switch (r.getClass().getName()) {
                    case "ReservaBoletoViaje":
                        System.out.println("Hay un vuelo");
                        vuelos = true;
                        break;
                    case "ReservaTransporte":
                        transporte = true;
                        System.out.println("Hay un transporte");
                        break;
                    case "ReservaComida":
                        System.out.println("Hay comida");
                        comida = true;
                        break;
                    case "ReservaHotel":
                        System.out.println("Hay hotel");
                        hotel = true;
                    default:
                        break;
                }
            }
        }
        paqueteCompleto = hotel && comida && transporte && vuelos;

        if ((reservas.stream().filter(x->x.getClass().getName() == "ReservaBoletosViaje").count() >= 2) || (reservas.stream().filter(x->x.getClass().getName() == "ReservaHotel").count() >= 2))
        {
            for (Reserva r:reservas) {
                if(r.getClass().getName() == "ReservaBoletosViaje"){
                    r.setCosto(r.getCosto()*0.95);
                }
                if(r.getClass().getName() == "ReservaHotel"){
                    r.setCosto(r.getCosto()*0.95);
                }
            }
        }

        reservas.forEach(x->montoTotal+=x.getCosto());
        montoTotal = cliente.getLocalizadores().stream().count() >= 2 ? montoTotal * 0.95 : montoTotal;
        montoTotal = paqueteCompleto ? montoTotal * 0.90 : montoTotal;
        return montoTotal;
    }
}

package agenciaTurismo;

import java.util.Arrays;
import java.util.List;

public class Localizador {
    Cliente cliente;
    List<Reserva> reservaciones;
    double descuento;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservaciones = reservas;
        this.descuento = realizarDescuento();
    }

    public double getDescuento() {
        return descuento;
    }

    public int cantidadReservas(){
        return reservaciones.size();
    }

    public double realizarDescuento() {
        double descuento = 0;
        List<Localizador> localizadoresCliente = cliente.obtenerLocalizadores();

        // 5% de descuento si tiene al menos dos localizadores
        if (localizadoresCliente.size() >= 2)
            descuento += 5;

        // 10% de descuento si tiene paquete completo
        List<Class<?>> reservaPaqueteCompleto = Arrays.asList(
                ReservaBoleto.class,
                ReservaComida.class,
                ReservaHotel.class,
                ReservaTransporte.class);

        if (reservaPaqueteCompleto.stream()
                .allMatch(tipoReserva -> reservaciones.stream()
                        .anyMatch(tipoReserva::isInstance))) {
            descuento += 10;
        }

        // 5% Si tiene 2 reservas de hotel

        if (reservaciones.stream().filter(ReservaHotel.class::isInstance).count() >= 2) {
            descuento += 5;
        }

        // 5% Si tiene 2 reservas de boletos de viaje

        if (reservaciones.stream().filter(ReservaBoleto.class::isInstance).count() >= 2) {
            descuento += 5;
        }

        return descuento;

    }

    public void listarReservas() {
        for (Reserva reserva : reservaciones) {
            System.out.println("Se hizo una reservación de: " + reserva.getTipo());
        }
    }

}

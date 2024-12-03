package org.example;

import java.util.List;

public class Agencia {
    private RepositorioCliente repositorioCliente;
    private RepositorioLocalizador repositorioLocalizador;

    public Agencia() {
        this.repositorioCliente = new RepositorioCliente();
        this.repositorioLocalizador = new RepositorioLocalizador();
    }

    public void procesarReserva(Cliente cliente) {
        Reserva reservaHotel = new Reserva(TipoReserva.HOTEL, 1000);
        Reserva reservaViaje = new Reserva(TipoReserva.VIAJE, 1000);
        Reserva reservaComida = new Reserva(TipoReserva.COMIDA, 1000);
        Reserva reservaTransporte = new Reserva(TipoReserva.TRANSPORTE, 1000);

        List<Reserva> reservas = List.of(reservaViaje, reservaHotel, reservaComida, reservaTransporte);
        List<Reserva> segundaReserva = List.of(reservaViaje, reservaComida);

        Localizador paqueteCompleto = new Localizador(cliente, reservas);
        Localizador otroPaquete = new Localizador(cliente, segundaReserva);

        repositorioCliente.agregar(cliente);
        repositorioLocalizador.agregar(paqueteCompleto);

        paqueteCompleto.setTotal(calcularTotal(paqueteCompleto)) ;
        double primerDescuentoReserva = calcularDescuento(cliente, paqueteCompleto);

        repositorioLocalizador.agregar(otroPaquete);

        otroPaquete.setTotal(calcularTotal(otroPaquete)) ;
        double segundoDescuentoReserva = calcularDescuento(cliente, otroPaquete);

        System.out.println("--------------- Primer localizador ------------------------");
        System.out.println(paqueteCompleto);

        double totalConDescuentoPrimer = paqueteCompleto.getTotal() * (primerDescuentoReserva/ 100);
        System.out.println("TOTAL SIN DESCUENTO: " + paqueteCompleto.getTotal());
        System.out.println("PORCENTAJE DESCUENTO: " +primerDescuentoReserva);
        System.out.println("TOTAL CON DESCUENTO: " + totalConDescuentoPrimer);

        System.out.println("--------------- Segundo localizador ------------------------");

        System.out.println(otroPaquete);


        double totalConDescuento = otroPaquete.getTotal() * (segundoDescuentoReserva / 100);
        System.out.println("TOTAL SIN DESCUENTO: " + otroPaquete.getTotal());
        System.out.println("PORCENTAJE DESCUENTO: " +segundoDescuentoReserva);

        System.out.println("TOTAL CON DESCUENTO: " + totalConDescuento);
    }

    public double calcularDescuento(Cliente cliente, Localizador localizador) {
        double descuento = 100;
        List<Localizador> localizadores = repositorioLocalizador.buscarLocalizador(cliente);

        if(localizadores.size() >= 2) {
            descuento -= 5;
        }

        long tipoReservasUnicas = localizador.getReservas().stream()
                .map(Reserva::getTipo)
                .distinct()
                .count();

        if(tipoReservasUnicas == 4) {
            descuento -= 10;
        }

        long cantidadReservaHotel = localizador.getReservas().stream()
                .map(Reserva::getTipo)
                .filter(r -> r == TipoReserva.HOTEL).count();

        long cantidadReservaViaje = localizador.getReservas().stream()
                .map(Reserva::getTipo)
                .filter(r -> r == TipoReserva.VIAJE).count();

        if(cantidadReservaViaje >= 2 || cantidadReservaHotel >= 2) {
            descuento -= 10;
        }

        return descuento;
    }

    public double calcularTotal(Localizador localizador) {
        double total = 0;
        for(Reserva res : localizador.getReservas()) {
            total += res.getCosto();
        }

        return total;
    }
}
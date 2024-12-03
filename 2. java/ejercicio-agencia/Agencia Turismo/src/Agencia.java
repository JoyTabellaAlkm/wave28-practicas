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
        List<Reserva> segundaReserva = List.of(reservaViaje, reservaViaje, reservaComida);

        Localizador paqueteCompleto = new Localizador(cliente, reservas);
        Localizador otroPaquete = new Localizador(cliente, segundaReserva);

        repositorioCliente.agregar(cliente);
        repositorioLocalizador.agregar(paqueteCompleto);

        double primerTotalReserva = calcularTotal(paqueteCompleto);
        double primerDescuentoReserva = calcularDescuento(cliente, paqueteCompleto);

        repositorioLocalizador.agregar(otroPaquete);

        double totalReserva = calcularTotal(otroPaquete);
        double descuentoReserva = calcularDescuento(cliente, otroPaquete);

        System.out.println("--------------- Primer localizador ------------------------");
        double totalConDescuentoPrimer = primerTotalReserva - primerTotalReserva * primerDescuentoReserva;
        System.out.println(primerTotalReserva);
        System.out.println(primerDescuentoReserva);
        System.out.println("total con descuento" + totalConDescuentoPrimer);

        System.out.println("--------------- Segundo localizador ------------------------");
        double totalConDescuento = totalReserva - totalReserva * descuentoReserva;
        System.out.println(totalReserva);
        System.out.println(descuentoReserva);

        System.out.println("Total con descuento:" + totalConDescuento);
    }

    public double calcularDescuento(Cliente cliente, Localizador localizador) {
        double descuento = 0;
        List<Localizador> localizadores = repositorioLocalizador.buscarLocalizador(cliente);

        if(localizadores.size() >= 2) {
            descuento = 0.05;
        }

        long tipoReservasUnicas = localizador.getReservas().stream()
                .map(Reserva::getTipo)
                .distinct()
                .count();

        if(tipoReservasUnicas == 4) {
            descuento += 0.1;
        }

        long cantidadReservaHotel = localizador.getReservas().stream()
                .map(Reserva::getTipo)
                .filter(r -> r == TipoReserva.HOTEL).count();

        long cantidadReservaViaje = localizador.getReservas().stream()
                .map(Reserva::getTipo)
                .filter(r -> r == TipoReserva.VIAJE).count();

        if(cantidadReservaViaje >= 2 || cantidadReservaHotel >= 2) {
            descuento += 0.05;
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

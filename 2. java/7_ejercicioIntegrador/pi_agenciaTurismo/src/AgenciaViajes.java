import java.util.List;

public class AgenciaViajes {
    private ClienteRepositorio repositorioClientes;

    public AgenciaViajes() {
        this.repositorioClientes = new ClienteRepositorio();
    }

    public Localizador crearLocalizador(Cliente cliente, List<Reserva> reservas) {
        Cliente buscarCliente = repositorioClientes.buscarCliente(cliente.getDni());
        if (buscarCliente == null) {
            buscarCliente = repositorioClientes.agregarCliente(cliente.getDni(), cliente.getNombre());
        }

        Localizador localizador = new Localizador(buscarCliente);
        for (Reserva reserva : reservas) {
            localizador.agregarReserva(reserva);
        }

        aplicarDescuentos(buscarCliente, localizador);
        buscarCliente.agregarLocalizador(localizador);
        return localizador;
    }

    private void aplicarDescuentos(Cliente cliente, Localizador localizador) {
        // Descuento por 2 localizadores anteriores
        if (cliente.getLocalizadores().size() >= 2) {
            localizador.aplicarDescuento(5);
        }

        // Descuento por paquete completo
        boolean paqueteCompleto = localizador.getReservas().stream().map(Reserva::getTipo).distinct()
                                             .filter(tipo -> tipo.equals("Hotel") || tipo.equals("Comida") || tipo.equals("Boleto") || tipo.equals("Transporte"))
                                             .count() == 4;

        if (paqueteCompleto) {
            localizador.aplicarDescuento(10);
        }

        // Descuento por 2 reservas de hotel o boletos
        long hoteles = localizador.getReservas().stream().filter(reserva -> reserva.getTipo().equals("Hotel")).count();
        long boletos = localizador.getReservas().stream().filter(reserva -> reserva.getTipo().equals("Boleto")).count();

        if (hoteles >= 2 || boletos >= 2) {
            localizador.aplicarDescuento(5);
        }
    }
}

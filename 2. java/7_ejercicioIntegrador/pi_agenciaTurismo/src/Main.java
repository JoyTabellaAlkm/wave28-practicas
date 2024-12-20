import java.util.List;

public class Main {
    public static void main(String[] args) {
        AgenciaViajes agencia = new AgenciaViajes();

        // Cliente y localizador 1: Paquete completo
        List<Reserva> reservasPaquete = List.of(
                new Reserva("Hotel", 200),
                new Reserva("Comida", 100),
                new Reserva("Boleto", 150),
                new Reserva("Transporte", 50)
                                               );
        Cliente cliente1 = new Cliente(123456,"Juan Pérez");
        Localizador localizador1 = agencia.crearLocalizador(cliente1, reservasPaquete);
        localizador1.imprimirLocalizador();

        // Cliente y localizador 2: 2 hoteles y 2 boletos
        List<Reserva> reservas2 = List.of(
                new Reserva("Hotel", 200),
                new Reserva("Hotel", 200),
                new Reserva("Boleto", 150),
                new Reserva("Boleto", 150)
                                         );
        Localizador localizador2 = agencia.crearLocalizador(cliente1, reservas2);
        localizador2.imprimirLocalizador();

        // Cliente y localizador 3: Una sola reserva
        List<Reserva> reservas3 = List.of(
                new Reserva("Comida", 100)
                                         );
        Localizador localizador3 = agencia.crearLocalizador(cliente1, reservas3);
        localizador3.imprimirLocalizador();
    }
}
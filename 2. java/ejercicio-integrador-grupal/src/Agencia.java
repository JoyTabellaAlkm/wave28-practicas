import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Agencia {
    private RepositorioCliente repositorio;

    public Agencia() {
        this.repositorio = new RepositorioCliente();
    }

    public RepositorioCliente getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioCliente repositorio) {
        this.repositorio = repositorio;
    }

    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        Cliente cliente1 = new Cliente("123", "Jose", "Perez");
        Reserva hotel = new Reserva(TiposReserva.HOTEL, 1000.0);
        Reserva boleto = new Reserva(TiposReserva.BOLETO_VIAJE, 500.0);
        Reserva transporte = new Reserva(TiposReserva.TRANSPORTE, 500.0);
        Reserva comida = new Reserva(TiposReserva.COMIDA, 200.0);
        List<Reserva> paqueteCompletoCliente1 = new ArrayList<>(List.of(hotel, boleto, transporte, comida));

        Localizador localizador1 = new Localizador(cliente1, paqueteCompletoCliente1);

        System.out.println("\nReserva paquete completo \n" + localizador1);
        System.out.println(localizador1);
        agencia.getRepositorio().almacenar(localizador1);
        System.out.println(agencia.getRepositorio().buscarReservas(cliente1.getDni()));

        Reserva hotel1 = new Reserva(TiposReserva.HOTEL, 1500.0);
        Reserva hotel2 = new Reserva(TiposReserva.HOTEL, 1500.0);

        Reserva boleto1 = new Reserva(TiposReserva.BOLETO_VIAJE, 500.0);
        Reserva boleto2 = new Reserva(TiposReserva.BOLETO_VIAJE, 500.0);

        List<Reserva> paqueteHotelBoleto = new ArrayList<>(List.of(hotel1, hotel2, boleto1, boleto2));

        Localizador localizador2 = new Localizador(cliente1, paqueteHotelBoleto);

        System.out.println("\nReserva 2 hoteles y 2 boletos: \n" + localizador2);
        agencia.getRepositorio().almacenar(localizador2);
        System.out.println(agencia.getRepositorio().buscarReservas(cliente1.getDni()));

        Reserva comida1 = new Reserva(TiposReserva.COMIDA, 100.0);
        List<Reserva> paqueteSoloComida = new ArrayList<>(List.of(comida1));
        Localizador localizador3 = new Localizador(cliente1, paqueteSoloComida);

        System.out.println("\nReserva solo comida: \n" + localizador3);
        agencia.getRepositorio().almacenar(localizador3);
        System.out.println(agencia.getRepositorio().buscarReservas(cliente1.getDni()));


    }
}
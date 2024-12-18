package practica_agencia_turismo.src.meli.practica;

import java.util.ArrayList;
import java.util.List;

import practica_agencia_turismo.src.meli.practica.models.Cliente;
import practica_agencia_turismo.src.meli.practica.models.Localizador;
import practica_agencia_turismo.src.meli.practica.models.RepositorioClientes;
import practica_agencia_turismo.src.meli.practica.models.Reserva;
import practica_agencia_turismo.src.meli.practica.models.ReservaBoleto;
import practica_agencia_turismo.src.meli.practica.models.ReservaComida;
import practica_agencia_turismo.src.meli.practica.models.ReservaHotel;
import practica_agencia_turismo.src.meli.practica.models.ReservaTransporte;
import practica_agencia_turismo.src.meli.practica.services.ServicioEstadisticas;

public class Main {
    public static void main(String[] args) {

        RepositorioClientes repositorioClientes = new RepositorioClientes();

        // Primer caso parte I

        Cliente cliente1 = new Cliente("1", "Santiago");
        repositorioClientes.agregarCliente(cliente1);

        List<Reserva> reservasClienteCasoI = new ArrayList<>();
        Reserva reservaHotelCasoI = new ReservaHotel();
        Reserva reservaBoletoCasoI = new ReservaBoleto();
        Reserva reservaComidaCasoI = new ReservaComida();
        Reserva reservaTransporteCasoI = new ReservaTransporte();
        reservasClienteCasoI.add(reservaTransporteCasoI);
        reservasClienteCasoI.add(reservaComidaCasoI);
        reservasClienteCasoI.add(reservaBoletoCasoI);
        reservasClienteCasoI.add(reservaHotelCasoI);
        
        Localizador localizadorCasoI = new Localizador(cliente1, reservasClienteCasoI);
        cliente1.agregarLocalizador(localizadorCasoI);


        // Segundo caso parte I
        List<Reserva> reservasClienteCasoII = new ArrayList<>();
        Reserva reservaHotelCasoII = new ReservaHotel();
        Reserva reservaHotel2CasoII = new ReservaHotel();
        Reserva reservaBoletoCasoII = new ReservaBoleto();
        Reserva reservaBoleto2CasoII = new ReservaBoleto();
        reservasClienteCasoII.add(reservaBoletoCasoII);
        reservasClienteCasoII.add(reservaBoleto2CasoII);
        reservasClienteCasoII.add(reservaHotelCasoII);
        reservasClienteCasoII.add(reservaHotel2CasoII);

        Localizador localizadorCasoII = new Localizador(cliente1, reservasClienteCasoII);
        cliente1.agregarLocalizador(localizadorCasoII);

        // Tercer caso parte I

        List<Reserva> reservasClienteCasoIII = new ArrayList<>();
        Reserva reservaComidaCasoIII = new ReservaComida();
        reservasClienteCasoIII.add(reservaComidaCasoIII);

        Localizador localizadorCasoIII = new Localizador(cliente1, reservasClienteCasoIII);
        cliente1.agregarLocalizador(localizadorCasoIII);

        repositorioClientes.listarClientes();

        System.out.println("Estadisticas de la agencia");

        ServicioEstadisticas estadisticas = new ServicioEstadisticas(repositorioClientes.getClientes());

        System.out.println("Cantidad de localizadores vendidos: " + estadisticas.cantidadLocalizadoresVendidos());
        System.out.println("Cantidad de reservas realizadas: " + estadisticas.cantidadReservas());

    }

}
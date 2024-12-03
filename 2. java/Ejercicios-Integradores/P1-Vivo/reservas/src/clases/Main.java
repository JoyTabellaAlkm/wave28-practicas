package clases;

import repositorios.RepositorioLocalizador;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        RepositorioLocalizador localizadorRepo = new RepositorioLocalizador();
        Cliente cliente1 = new Cliente("Nico", "Dias", 123456);
        Reserva hotel = new Reserva("Hotel", 1000);
        Reserva comida = new Reserva("Comida", 1000);
        Reserva boletos = new Reserva("Boletos", 1000);
        Reserva viaje = new Reserva("Viajes", 1000);
        Reserva transporte = new Reserva("Transporte", 1000);
        Localizador localizador1 = new Localizador(cliente1, List.of(hotel, comida, boletos, viaje,
                transporte), true, localizadorRepo);


        System.out.println(localizador1);
        localizadorRepo.guardar(localizador1);

        Localizador localizador2 = new Localizador(cliente1, List.of(hotel, hotel), false,
                localizadorRepo);
        System.out.println(localizador2);
        localizadorRepo.guardar(localizador2);

        Localizador localizador3 = new Localizador(cliente1, List.of(boletos), false,
                localizadorRepo);
        System.out.println(localizador3);
    }
}
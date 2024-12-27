package ar.com.mercadolibre.mundial.util;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.ArrayList;
import java.util.List;

public class JugadorFactory {
    public static List<Jugador> crearJugadoresMock(){
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador(1, "Lionel Messi", "Argentina", 91));
        jugadores.add(new Jugador(2, "Cristiano Ronaldo", "Portugal", 85));
        jugadores.add(new Jugador(3, "Neymar Jr", "Brasil", 77));
        jugadores.add(new Jugador(4, "Kylian Mbappé", "Francia", 52));
        jugadores.add(new Jugador(5, "Luis Suárez", "Uruguay", 68));
        jugadores.add(new Jugador(6, "Robert Lewandowski", "Polonia", 72));
        jugadores.add(new Jugador(7, "Karim Benzema", "Francia", 59));
        jugadores.add(new Jugador(8, "Mohamed Salah", "Egipto", 51));
        jugadores.add(new Jugador(9, "Harry Kane", "Inglaterra", 68));
        jugadores.add(new Jugador(10, "Sergio Agüero", "Argentina", 41));
        jugadores.add(new Jugador(11, "Eden Hazard", "Bélgica", 33));
        jugadores.add(new Jugador(12, "Gareth Bale", "Gales", 38));
        jugadores.add(new Jugador(13, "Antoine Griezmann", "Francia", 47));
        jugadores.add(new Jugador(14, "Paul Pogba", "Francia", 20));
        jugadores.add(new Jugador(15, "Dusan Tadic", "Serbia", 25));
        jugadores.add(new Jugador(16, "Luka Modric", "Croacia", 17));
        jugadores.add(new Jugador(17, "Sadio Mané", "Senegal", 44));
        jugadores.add(new Jugador(18, "Romelu Lukaku", "Bélgica", 68));
        jugadores.add(new Jugador(19, "Zlatan Ibrahimović", "Suecia", 62));
        jugadores.add(new Jugador(20, "Edinson Cavani", "Uruguay", 56));
        return jugadores;
    }

    public static Jugador jugadorNoExistenteMock(){
        return new Jugador(0, "Julián Alvarez", "Argentina", 40);
    }

    public static Jugador jugadorExistenteMock(){
        return new Jugador(1, "Lionel Messi", "Argentina", 91);
    }
}

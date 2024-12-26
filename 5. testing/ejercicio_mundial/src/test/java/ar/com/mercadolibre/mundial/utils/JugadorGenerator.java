package ar.com.mercadolibre.mundial.utils;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.Arrays;
import java.util.List;

public class JugadorGenerator {
    static List<Jugador> jugadoresMock = Arrays.asList(
            new Jugador(1, "Lionel Messi", "Argentina", 91),
            new Jugador(2, "Cristiano Ronaldo", "Portugal", 85),
            new Jugador(3, "Neymar Jr", "Brasil", 77),
            new Jugador(4, "Kylian Mbappé", "Francia", 52),
            new Jugador(5, "Luis Suárez", "Uruguay", 68),
            new Jugador(6, "Robert Lewandowski", "Polonia", 72),
            new Jugador(7, "Karim Benzema", "Francia", 59),
            new Jugador(8, "Mohamed Salah", "Egipto", 51),
            new Jugador(9, "Harry Kane", "Inglaterra", 68),
            new Jugador(10, "Sergio Agüero", "Argentina", 41),
            new Jugador(11, "Eden Hazard", "Bélgica", 33),
            new Jugador(12, "Gareth Bale", "Gales", 38),
            new Jugador(13, "Antoine Griezmann", "Francia", 47),
            new Jugador(14, "Paul Pogba", "Francia", 20),
            new Jugador(15, "Dusan Tadic", "Serbia", 25),
            new Jugador(16, "Luka Modric", "Croacia", 17),
            new Jugador(17, "Sadio Mané", "Senegal", 44),
            new Jugador(18, "Romelu Lukaku", "Bélgica", 68),
            new Jugador(19, "Zlatan Ibrahimović", "Suecia", 62),
            new Jugador(20, "Edinson Cavani", "Uruguay", 56)
    );

    public static List<Jugador> findAll(){
        return jugadoresMock;
    }
}

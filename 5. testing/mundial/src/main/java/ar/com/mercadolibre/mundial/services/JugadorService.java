package ar.com.mercadolibre.mundial.services;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;

public interface JugadorService {
    Jugador obtenerJugadorPorId(int id);
    List<Jugador> obtenerJugadoresOrdenadosPorGoles();
    List<Jugador> obtenerJugadores();
    boolean borrarJugador(int id);
    boolean crearJugador(Jugador jugador);
    boolean modificarJugador(Jugador jugador);
}

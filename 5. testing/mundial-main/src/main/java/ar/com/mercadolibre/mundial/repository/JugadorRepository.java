package ar.com.mercadolibre.mundial.repository;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;

public interface JugadorRepository {
    List<Jugador> cargarJugadores();
    Jugador agregarJugador(Jugador jugador);
    Jugador actualizarJugador (Jugador jugador);
    boolean eliminarJugador(int id);
    Jugador buscarJugadorPorId(int id);
    List<Jugador> obtenerJugadores();
}
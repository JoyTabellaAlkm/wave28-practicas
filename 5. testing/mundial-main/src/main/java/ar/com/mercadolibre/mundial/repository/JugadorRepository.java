package ar.com.mercadolibre.mundial.repository;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;

public interface JugadorRepository {
    List<Jugador> cargarJugadores();

    int agregarNuevoJugador(Jugador j);

    boolean eliminarJugador(Jugador j);
}
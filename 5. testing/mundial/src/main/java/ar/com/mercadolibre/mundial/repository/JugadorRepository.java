package ar.com.mercadolibre.mundial.repository;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;

public interface JugadorRepository {
    List<Jugador> obtenerJugadores();
    void borrar(Jugador jugador);
    void crear(Jugador jugador);
}

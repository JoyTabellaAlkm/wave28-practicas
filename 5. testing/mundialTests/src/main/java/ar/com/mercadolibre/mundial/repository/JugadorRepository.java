package ar.com.mercadolibre.mundial.repository;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;

public interface JugadorRepository {
    List<Jugador> cargarJugadores();
    List<Jugador> getAll();

    boolean create(Jugador jugador);
    Jugador find(int id);

    boolean remove(Jugador jugador);
}
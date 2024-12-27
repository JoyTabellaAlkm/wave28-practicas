package ar.com.mercadolibre.mundial.repository;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;

public interface JugadorRepository {
    List<Jugador> cargarJugadores();

//    List<Jugador> findAll();

    Jugador findById(int id);

    List<Jugador> loadData();

    boolean exist(int id);

    Jugador save(Jugador jugador);
}

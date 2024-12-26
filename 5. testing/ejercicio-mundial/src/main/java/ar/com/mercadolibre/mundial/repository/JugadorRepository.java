package ar.com.mercadolibre.mundial.repository;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;
import java.util.Optional;

public interface JugadorRepository {
    List<Jugador> getAll();

    boolean save(Jugador jugador);

    boolean update(Jugador jugador);

    boolean delete(int id);

    Optional<Jugador> findById(int id);
}
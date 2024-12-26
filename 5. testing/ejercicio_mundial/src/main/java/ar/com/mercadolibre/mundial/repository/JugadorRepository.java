package ar.com.mercadolibre.mundial.repository;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;

public interface JugadorRepository {
    List<Jugador> findAll();
    Jugador findById(int id);
    Boolean create(Jugador jugador);
    Boolean update(Jugador jugador);
    Boolean delete(Jugador jugador);
}
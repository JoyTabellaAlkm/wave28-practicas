package ar.com.mercadolibre.mundial.repository;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;
import java.util.Optional;

public interface JugadorRepository {
    List<Jugador> cargarJugadores();

    boolean agregar(Jugador jugador);

    boolean borrar(Jugador jugador);
}
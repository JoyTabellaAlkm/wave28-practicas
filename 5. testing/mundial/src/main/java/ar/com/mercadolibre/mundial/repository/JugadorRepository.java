package ar.com.mercadolibre.mundial.repository;

import ar.com.mercadolibre.mundial.model.Jugador;

import java.util.List;

public interface JugadorRepository {
    List<Jugador> cargarJugadores();
    List<Jugador> traerTodos();
    Jugador encontrarPorId(int id);
    Jugador guardar(Jugador jugador);
    Jugador editar(Jugador jugador);
    Boolean eliminar(Jugador jugador);

}
package ar.com.mercadolibre.mundial.services;

import ar.com.mercadolibre.mundial.models.Jugador;

import java.util.List;

public interface JugadorService {
    /**
     * Obtiene un jugador por su ID.
     *
     * @param id Identificador del jugador.
     * @return Jugador correspondiente o null si no existe.
     */
    Jugador obtenerJugadorPorId(int id);

    /**
     * Obtiene la lista de jugadores ordenados por cantidad de goles.
     *
     * @return Lista ordenada de jugadores.
     */
    List<Jugador> obtenerJugadoresOrdenadosPorGoles();


    Jugador crearJugador(Jugador jugadorACrear);
}
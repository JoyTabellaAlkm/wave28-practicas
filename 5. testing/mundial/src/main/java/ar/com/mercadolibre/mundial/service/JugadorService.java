package ar.com.mercadolibre.mundial.service;

import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.model.Jugador;

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

    /**
     * Obtiene la lista de jugadores
     *
     * @return Lista de jugadores
     */
    List<JugadorDTO> obtenerJugadores();

    /**
     * Guarda un jugador en la lista
     *
     * @return devuelve el jugador guardado en caso de no guardado devuelve null
     */
    JugadorDTO guardar(JugadorDTO jugadorDto);

    /**
     * Edita un jugador si existe
     *
     * @return devuelve el jugador editado en caso de no existir lanza una exception de tipo
     * NotFoundJugadorException
     */
    JugadorDTO editar(JugadorDTO jugadorDto);

    /**
     * Eliminar un jugador
     *
     * @return devuelve un boolean dependiendo si se elimina
     */

    Boolean eliminar(int jugadorId);

}
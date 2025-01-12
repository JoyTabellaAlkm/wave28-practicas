package ar.com.mercadolibre.mundial.services.impl;
import ar.com.mercadolibre.mundial.exceptions.ConflictException;
import ar.com.mercadolibre.mundial.exceptions.NotFoundException;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    JugadorRepository jugadorRepository;

    @Override
    public Jugador obtenerJugadorPorId(int id) {
        return jugadorRepository.cargarJugadores().stream()
                .filter(jugador -> jugador.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Jugador> obtenerJugadoresOrdenadosPorGoles() {
        List<Jugador> jugadores = jugadorRepository.cargarJugadores();
        jugadores.sort(Comparator.comparingInt(Jugador::getGoles).reversed());
        return jugadores;
    }

    @Override
    public Jugador crearJugador(Jugador jugador) {
        List<Jugador> jugadores = jugadorRepository.cargarJugadores();
        Jugador jugadorACrear = obtenerJugadorPorId(jugador.getId());
        if(jugadorACrear != null) {
            throw new ConflictException("Ya existe un jugador creado con ese id");
        }
        jugadores.add(jugador);
        return jugador;
    }

    @Override
    public Jugador eliminarJugador(int id) {
        Jugador jugadorAEliminar = obtenerJugadorPorId(id);
        if(jugadorAEliminar == null) {
            throw new NotFoundException("No se encontro un jugador con ese id");
        }
        List<Jugador> jugadores = jugadorRepository.cargarJugadores();
        jugadores.remove(jugadorAEliminar);

        return jugadorAEliminar;
    }

    @Override
    public Jugador actualizarJugador(Jugador jugador) {
        Jugador jugadorAModificar = obtenerJugadorPorId(jugador.getId());
        if(jugadorAModificar == null) {
            throw new NotFoundException("No se encontro un jugador con ese id");
        }
        List<Jugador> jugadores = jugadorRepository.cargarJugadores();
        jugadores.remove(jugadorAModificar);
        jugadores.add(jugador);

        return jugador;
    }
}

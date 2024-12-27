package ar.com.mercadolibre.mundial.services.impl;
import ar.com.mercadolibre.mundial.excception.NotFoundException;
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
        return jugadorRepository.obtenerJugadores().stream()
                .filter(jugador -> jugador.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("no se ha encontrado jugador por ese id."));
    }

    @Override
    public List<Jugador> obtenerJugadoresOrdenadosPorGoles() {
        List<Jugador> jugadores = jugadorRepository.obtenerJugadores();
        jugadores.sort(Comparator.comparingInt(Jugador::getGoles).reversed());
        return jugadores;
    }

    @Override
    public List<Jugador> obtenerJugadores() {
        return jugadorRepository.obtenerJugadores();
    }

    @Override
    public boolean borrarJugador(int id) {
        Jugador jugador = obtenerJugadorPorId(id);
        jugadorRepository.borrar(jugador);
        return true;
    }

    @Override
    public boolean crearJugador(Jugador jugador) {
        jugadorRepository.crear(jugador);
        return true;
    }

    @Override
    public boolean modificarJugador(Jugador jugador) {
        Jugador jugadorExistente = obtenerJugadorPorId(jugador.getId());
        jugadorExistente = jugador;
        return true;
    }
}

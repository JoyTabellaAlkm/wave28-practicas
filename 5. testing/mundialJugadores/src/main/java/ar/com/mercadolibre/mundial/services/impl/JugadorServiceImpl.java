package ar.com.mercadolibre.mundial.services.impl;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
    public boolean agregarJugador(Jugador jugador) {
        return jugadorRepository.agregar(jugador);
    }

    @Override
    public boolean eliminarJugador(int jugadorId) {
        Jugador jugador = jugadorById(jugadorId).orElseThrow(()-> new Error("Jugador no existente"));

        return jugadorRepository.borrar(jugador);
    }

    private Optional<Jugador> jugadorById(int jugadorId) {
        return jugadorRepository.cargarJugadores().stream()
                .filter(jugador -> jugador.getId() == jugadorId)
                .findAny();
    }
}

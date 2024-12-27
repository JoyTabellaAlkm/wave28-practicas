package ar.com.mercadolibre.mundial.services.impl;
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
    public Jugador create(Jugador jugador) {
        return jugadorRepository.crearUnJugador(jugador);
    }

    @Override
    public void update(Jugador jugador) {

    }

    @Override
    public boolean delete(Jugador jugador) {
        return false;
    }

    @Override
    public Jugador read(Long jugadorId) {
        return null;
    }
}

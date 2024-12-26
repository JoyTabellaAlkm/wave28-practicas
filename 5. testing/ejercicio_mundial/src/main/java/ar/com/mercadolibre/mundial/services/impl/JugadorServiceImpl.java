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
        return jugadorRepository.findById(id);
    }

    @Override
    public List<Jugador> obtenerJugadoresOrdenadosPorGoles() {
        List<Jugador> jugadores = jugadorRepository.findAll();
        jugadores.sort(Comparator.comparingInt(Jugador::getGoles).reversed());
        return jugadores;
    }

    @Override
    public Boolean save(Jugador jugador) {
        return jugadorRepository.create(jugador);
    }

    @Override
    public Boolean update(Jugador jugador) {
        return jugadorRepository.update(jugador);
    }

    @Override
    public Boolean delete(Jugador jugador) {
        return jugadorRepository.delete(jugador);
    }
}

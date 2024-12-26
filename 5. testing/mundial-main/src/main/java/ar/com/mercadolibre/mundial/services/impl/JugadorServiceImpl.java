package ar.com.mercadolibre.mundial.services.impl;
import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.JugadorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    JugadorRepository jugadorRepository;

    private ObjectMapper objectMapper;

    public JugadorServiceImpl() {
        objectMapper= new ObjectMapper();
    }

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
    public JugadorDTO crearJugador(JugadorDTO jugador) {
        return objectMapper.convertValue(
                jugadorRepository
                        .agregarJugador(objectMapper
                                .convertValue(jugador,Jugador.class))
                ,JugadorDTO.class);
    }

    @Override
    public JugadorDTO actualizarJugador(JugadorDTO jugador) {
        return objectMapper.convertValue(
                jugadorRepository
                        .actualizarJugador(objectMapper
                                .convertValue(jugador,Jugador.class))
                ,JugadorDTO.class);
    }

    @Override
    public boolean eliminarJugador(int id) {
        return jugadorRepository.eliminarJugador(id);
    }

    @Override
    public JugadorDTO buscarJugadorPorId(int id) {
        return objectMapper.convertValue(jugadorRepository.buscarJugadorPorId(id),JugadorDTO.class);
    }

    @Override
    public List<JugadorDTO> obtenerJugadores() {
        return jugadorRepository.obtenerJugadores()
                .stream()
                .map(j->objectMapper.convertValue(j,JugadorDTO.class)).toList();
    }
}

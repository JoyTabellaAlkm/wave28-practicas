package ar.com.mercadolibre.mundial.service.impl;

import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.model.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.service.JugadorService;
import ar.com.mercadolibre.mundial.util.Utils;
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
        return jugadorRepository.cargarJugadores().stream().filter(jugador -> jugador.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Jugador> obtenerJugadoresOrdenadosPorGoles() {
        List<Jugador> jugadores = jugadorRepository.cargarJugadores();
        jugadores.sort(Comparator.comparingInt(Jugador::getGoles).reversed());
        return jugadores;
    }

    @Override
    public List<JugadorDTO> obtenerJugadores() {
        return jugadorRepository.traerTodos().stream().map(jugador -> Utils.mapper.convertValue(jugador, JugadorDTO.class)).toList();
    }

    @Override
    public JugadorDTO guardar(JugadorDTO jugadorDto) {
        return Utils.mapper.convertValue(jugadorRepository.guardar(Utils.mapper.convertValue(jugadorDto, Jugador.class)), JugadorDTO.class);
    }

    @Override
    public JugadorDTO editar(JugadorDTO jugadorDto) {
        return Utils.mapper.convertValue(jugadorRepository.editar(Utils.mapper.convertValue(jugadorDto, Jugador.class)), JugadorDTO.class);
    }

    @Override
    public Boolean eliminar(int jugadorId) {
        Jugador jugador = jugadorRepository.encontrarPorId(jugadorId);
        return jugadorRepository.eliminar(jugador);
    }
}

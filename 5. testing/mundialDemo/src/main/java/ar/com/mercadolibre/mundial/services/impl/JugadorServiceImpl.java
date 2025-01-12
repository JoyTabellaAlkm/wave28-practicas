package ar.com.mercadolibre.mundial.services.impl;
import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.dto.MensajeDTO;
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

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public JugadorDTO obtenerJugadorPorId(int id) {
        Jugador jugadorEncontrado = jugadorRepository.findById(id);

        JugadorDTO jugadorDTO = mapper.convertValue(jugadorEncontrado, JugadorDTO.class);
        if (jugadorEncontrado != null) {
            return jugadorDTO;
        }
        else {
            throw new IllegalArgumentException("Jugador no encontrado");
        }
    }

    @Override
    public List<JugadorDTO> obtenerJugadoresOrdenadosPorGoles() {
        List<Jugador> jugadores = jugadorRepository.cargarJugadores();

        List<JugadorDTO> jugadoresDTO = jugadores.stream()
                .map(j -> mapper.convertValue(j, JugadorDTO.class))
                .sorted(Comparator.comparing(JugadorDTO::getGoles)
                        .reversed())
                .toList();

        return jugadoresDTO;
    }

    @Override
    public JugadorDTO obtenerJugadorPorNombre(String nombre) {
        List<Jugador> jugadores = jugadorRepository.cargarJugadores();

        Jugador jugador = jugadores.stream()
                .filter(j -> j.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Jugador no encontrado"));

        return mapper.convertValue(jugador, JugadorDTO.class);
    }

    @Override
    public MensajeDTO registrarJugador(JugadorDTO jugadorDTO) {
        int id = jugadorDTO.getId();

        if (!jugadorRepository.exist(id)) {
            Jugador jugador = mapper.convertValue(jugadorDTO, Jugador.class);
            jugadorRepository.save(jugador);
            return new MensajeDTO("Jugador registrado");
        } else {
            throw new IllegalArgumentException("Ya existe un jugador con este ID");
        }
    }
}

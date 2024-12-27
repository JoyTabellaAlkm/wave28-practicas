package ar.com.mercadolibre.mundial.services.impl;
import ar.com.mercadolibre.mundial.dto.RequestJugadorDTO;
import ar.com.mercadolibre.mundial.dto.ResponseDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.JugadorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @Override
    public Jugador obtenerJugadorPorId(int id) {
        return jugadorRepository.getAll().stream()
                .filter(jugador -> jugador.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Jugador> obtenerJugadoresOrdenadosPorGoles() {
        List<Jugador> jugadores = jugadorRepository.getAll();
        jugadores.sort(Comparator.comparingInt(Jugador::getGoles).reversed());
        return jugadores;
    }

    @Override
    public List<Jugador> getAll() {
        return jugadorRepository.getAll();
    }

    @Override
    public Jugador show(int id) {
        return jugadorRepository.getAll()
                .stream()
                .filter(j -> j.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontro el jugador"));
    }

    @Override
    public ResponseDTO create(RequestJugadorDTO requestJugador) {
        Jugador jugadorEncontrado = findPlayer(requestJugador);
        if (jugadorEncontrado != null) {
            throw new RuntimeException("El jugador ya existe.");
        }

        boolean creado = jugadorRepository.create(objectMapper.convertValue(requestJugador, Jugador.class));

        if (!creado){
            throw new RuntimeException("No se pudo agregar el jugador.");
        }

        return new ResponseDTO("Jugador creado con exito.");
    }

    @Override
    public Jugador update(int id, RequestJugadorDTO requestJugador) {
        Jugador jugadorEncontrado = jugadorRepository.find(id);

        jugadorEncontrado.setGoles(requestJugador.getGoles());
        jugadorEncontrado.setNombre(requestJugador.getNombre());
        jugadorEncontrado.setPais(requestJugador.getPais());

        return jugadorEncontrado;
    }

    @Override
    public ResponseDTO delete(int id) {
        Jugador jugadorEncontrado = jugadorRepository.find(id);

        boolean result = jugadorRepository.remove(jugadorEncontrado);

        if (!result){
            throw new RuntimeException("No se pudo eliminar el jugador");
        }

        return new ResponseDTO("Se elimino el jugador con exito.");
    }

    private Jugador findPlayer(RequestJugadorDTO requestJugadorDTO) {
        Jugador jugadorResult = null;
        Optional<Jugador> jugadorEncontrado = jugadorRepository.getAll()
                .stream()
                .filter(j ->
                        j.getNombre().equals(requestJugadorDTO.getNombre()) &&
                                j.getGoles() == requestJugadorDTO.getGoles() &&
                                j.getPais().equals(requestJugadorDTO.getPais()))
                .findFirst();

        if (jugadorEncontrado.isPresent()) {
            jugadorResult = jugadorEncontrado.get();
        }

        return jugadorResult;
    }
}

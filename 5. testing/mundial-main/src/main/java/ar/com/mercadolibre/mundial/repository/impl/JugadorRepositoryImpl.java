package ar.com.mercadolibre.mundial.repository.impl;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Repository
public class JugadorRepositoryImpl implements JugadorRepository {

    private final ObjectMapper objectMapper;

    private List<Jugador> jugadores;

    public JugadorRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        jugadores = cargarJugadores();
    }

    @Value("${jugadores.json.path}")
    private String jugadoresJsonPath;

    @Override
    public List<Jugador> cargarJugadores() {
        try (InputStream inputStream = getClass().getResourceAsStream(jugadoresJsonPath)) {
            if (inputStream == null) {
                throw new IOException("El archivo JSON no se encontró: " + jugadoresJsonPath);
            }
            return objectMapper.readValue(inputStream, new TypeReference<List<Jugador>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Jugador agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
        return jugador;
    }

    @Override
    public Jugador actualizarJugador(Jugador jugador) {
        Jugador jugadorExistente = buscarJugadorPorId(jugador.getId());
        jugadorExistente=jugador;
        return jugadorExistente;
    }

    @Override
    public boolean eliminarJugador(int id) {
        return jugadores.remove(buscarJugadorPorId(id));
    }

    @Override
    public Jugador buscarJugadorPorId(int id) {
        return jugadores.stream().filter(j->j.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<Jugador> obtenerJugadores() {
        return jugadores;
    }
}
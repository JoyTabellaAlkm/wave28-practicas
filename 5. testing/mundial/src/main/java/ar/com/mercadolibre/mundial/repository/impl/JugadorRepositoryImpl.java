package ar.com.mercadolibre.mundial.repository.impl;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JugadorRepositoryImpl implements JugadorRepository {

    private final ObjectMapper objectMapper;

    List<Jugador> listaJugadores = new ArrayList<>();

    public JugadorRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        listaJugadores =  cargarJugadores();
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
    public Jugador crearUnJugador(Jugador jugador) {
        listaJugadores.add(jugador);
        return jugador;
    }

    @Override
    public Jugador getById(int id) {
        return listaJugadores.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
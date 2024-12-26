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
import java.util.Optional;

@Repository
public class JugadorRepositoryImpl implements JugadorRepository {

    private final ObjectMapper objectMapper;
    private List<Jugador> jugadores;

    public JugadorRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Value("${jugadores.json.path}")
    private String jugadoresJsonPath;

    @Override
    public List<Jugador> cargarJugadores() {
        try (InputStream inputStream = getClass().getResourceAsStream(jugadoresJsonPath)) {
            if (inputStream == null) {
                throw new IOException("El archivo JSON no se encontró: " + jugadoresJsonPath);
            }
            jugadores = objectMapper.readValue(inputStream, new TypeReference<List<Jugador>>() {});
            return jugadores;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public boolean agregar(Jugador jugador) {
        return jugadores.add(jugador);
    }

    @Override
    public boolean borrar(Jugador jugador) {
        return jugadores.remove(jugador);
    }
}
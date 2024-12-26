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
    private List<Jugador> jugadores = cargarJugadores();

    private final ObjectMapper objectMapper;

    public JugadorRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Value("${jugadores.json.path}")
    private String jugadoresJsonPath;



    private List<Jugador> cargarJugadores() {
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
    public boolean save(Jugador jugador) {
        return jugadores.add(jugador);
    }

    @Override
    public boolean update(Jugador jugador) {
        int position = jugadores.indexOf(jugador);
        if(position != -1) {
            jugadores.set(position, jugador);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        if(findById(id).isPresent()) {
            return jugadores.remove(findById(id).get());
        }
        return false;
    }

    @Override
    public Optional<Jugador> findById(int id) {
        return jugadores.stream()
                .filter(j ->j.getId() == id)
                .findFirst();
    }

    @Override
    public List<Jugador> getAll() {
        return jugadores;
    }
}
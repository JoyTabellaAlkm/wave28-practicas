package ar.com.mercadolibre.mundial.repository.impl;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class JugadorRepositoryImpl implements JugadorRepository {

    private List<Jugador> jugadores;

    public JugadorRepositoryImpl() {
        this.jugadores = cargarJugadores();
    }

    @Value("${jugadores.json.path}")
    private String jugadoresJsonPath;

    @Override
    public List<Jugador> findAll() {
        return jugadores;
    }

    @Override
    public Jugador findById(int id) {
        Optional<Jugador> jugadorOptional = jugadores.stream()
                .filter(jugador -> jugador.getId() == id)
                .findFirst();
        return jugadorOptional.orElse(null);
    }

    @Override
    public Boolean create(Jugador jugador) {
        return jugadores.add(jugador);
    }

    @Override
    public Boolean update(Jugador jugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador existingJugador = jugadores.get(i);
            if (existingJugador.getId() == jugador.getId()) {
                jugadores.set(i, jugador);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean delete(Jugador jugador) {
        return jugadores.removeIf(j -> j.getId() == jugador.getId());
    }

    public List<Jugador> cargarJugadores() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Usar la ruta relativa adecuada para cargar el archivo de recursos
        try (InputStream inputStream = getClass().getResourceAsStream("/jugadores.json")) {
            if (inputStream == null) {
                throw new IOException("El archivo JSON no se encontró: /jugadores.json");
            }
            this.jugadores = objectMapper.readValue(inputStream, new TypeReference<List<Jugador>>() {});
            return this.jugadores;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
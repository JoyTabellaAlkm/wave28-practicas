package ar.com.mercadolibre.mundial.repository.impl;
import ar.com.mercadolibre.mundial.exception.NotFoundJugadorException;
import ar.com.mercadolibre.mundial.model.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Repository
public class JugadorRepositoryImpl implements JugadorRepository {

    private final ObjectMapper objectMapper;
    private List<Jugador> jugadores;

    public JugadorRepositoryImpl(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
        this.jugadores = cargarJugadores();
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
    public List<Jugador> traerTodos() {
        return jugadores;
    }

    @Override
    public Jugador guardar(Jugador jugador) {
        jugadores.add(jugador);
        return jugador;
    }

    @Override
    public Jugador editar(Jugador jugador) {
        OptionalInt indexOptional = IntStream.range(0, jugadores.size())
                .filter(j -> jugadores.get(j).getId() == jugador.getId())
                .findFirst();
        if (indexOptional.isEmpty()) throw new NotFoundJugadorException("Jugador no encontrado.");
        int index = indexOptional.getAsInt();
        Jugador j = jugadores.get(index);
        j = jugador;
        return j;
    }

    @Override
    public Boolean eliminar(Jugador jugador) {
        return jugadores.remove(jugador);
    }

    @Override
    public Jugador encontrarPorId(int id) {
        return jugadores.stream().filter(jugador -> jugador.getId() == id).findFirst().orElseThrow(() -> new NotFoundJugadorException("Jugador no encontrado."));
    }
}
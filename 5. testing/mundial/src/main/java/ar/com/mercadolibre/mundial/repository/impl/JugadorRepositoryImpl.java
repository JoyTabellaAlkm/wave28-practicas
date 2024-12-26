package ar.com.mercadolibre.mundial.repository.impl;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Repository
public class JugadorRepositoryImpl implements JugadorRepository {

    private final ObjectMapper objectMapper;

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
            return objectMapper.readValue(inputStream, new TypeReference<List<Jugador>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Jugador crearJugador(Jugador jugadorACrear) {
        savePlayer(jugadorACrear);
        return jugadorACrear;
    }

    private void savePlayer(Jugador jugador) {
        List<Jugador> jugadores = this.cargarJugadores();
        jugadores.add(jugador);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(jugadoresJsonPath);
            objectMapper.writeValue(file, jugadores);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
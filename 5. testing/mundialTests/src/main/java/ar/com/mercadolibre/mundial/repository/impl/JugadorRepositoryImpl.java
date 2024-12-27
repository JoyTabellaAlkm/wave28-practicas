package ar.com.mercadolibre.mundial.repository.impl;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Repository
public class JugadorRepositoryImpl implements JugadorRepository {
    List<Jugador> jugadores;

    int counter;

    public JugadorRepositoryImpl() {
        this.jugadores = cargarJugadores();
        this.counter = jugadores.size();
    }

    @Override
    public List<Jugador> cargarJugadores() {
        List<Jugador> jugadores = new ArrayList<>();
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            file = ResourceUtils.getFile("classpath:jugadores.json");
            jugadores = objectMapper.readValue(file, new TypeReference<List<Jugador>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return jugadores;
    }

    @Override
    public List<Jugador> getAll() {
        return jugadores;
    }

    @Override
    public boolean create(Jugador jugador) {
        jugador.setId(counter++);
        return jugadores.add(jugador);
    }

    @Override
    public Jugador find(int id) {
        return jugadores.stream()
                .filter(j -> j.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    @Override
    public boolean remove(Jugador jugador) {
        return jugadores.remove(jugador);
    }
}
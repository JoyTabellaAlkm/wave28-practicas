package ar.com.mercadolibre.mundial.repository.impl;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class JugadorRepositoryImpl implements JugadorRepository {

    List<Jugador> jugadoresList;

    public JugadorRepositoryImpl() {
        this.jugadoresList = loadData();
    }


    public List<Jugador> cargarJugadores() { // NUESTRO FindAll()
        return this.jugadoresList;
    }

    @Override
    public Jugador findById(int id) {
        return jugadoresList.stream()
                .filter(jugador -> jugador.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Value("${jugadores.json.path}")
    private String jugadoresJsonPath;



    @Override
    public boolean exist(int id) {
        return jugadoresList.stream()
                .filter(jugador -> jugador.getId() == id)
                .anyMatch(jugador -> true);
    }

    @Override
    public Jugador save(Jugador jugador) {
        jugadoresList.add(jugador);
        return jugador;
    }

    @Override
    public List<Jugador> loadData() {
        List<Jugador> loadedData = null;
        File file;

        ObjectMapper objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .registerModule(new JavaTimeModule());

        TypeReference<List<Jugador>> typeRef = new TypeReference<>() {};

        try {
            file = ResourceUtils.getFile("classpath:jugadores.json");
            loadedData = objectMapper.readValue(file, typeRef);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }

}
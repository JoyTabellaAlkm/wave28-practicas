package ar.com.mercadolibre.mundial.repository.impl;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Repository
public class JugadorRepositoryImpl implements JugadorRepository {
    List<Jugador> jugadores;
    private String SCOPE;

    public JugadorRepositoryImpl() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }
        cargarJugadores();
    }

    public void cargarJugadores() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/jugadores.json");
            jugadores = objectMapper.readValue(file, new TypeReference<List<Jugador>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
    }

    @Override
    public List<Jugador> obtenerJugadores() {
        return jugadores;
    }

    @Override
    public void borrar(Jugador jugador) {
        jugadores.remove(jugador);
    }

    @Override
    public void crear(Jugador jugador) {
        jugadores.add(jugador);
    }
}

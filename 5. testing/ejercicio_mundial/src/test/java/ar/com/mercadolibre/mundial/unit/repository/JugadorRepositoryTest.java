package ar.com.mercadolibre.mundial.unit.repository;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.repository.impl.JugadorRepositoryImpl;
import ar.com.mercadolibre.mundial.utils.JugadorGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JugadorRepositoryTest {

    private JugadorRepository repository= new JugadorRepositoryImpl();
    @Test
    public void findAllExistentJugadores() {
        // arrange
        List<Jugador> expectedJugadores = JugadorGenerator.findAll();

        // act
        List<Jugador> foundJugadores = repository.findAll();

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(expectedJugadores, foundJugadores));
    }

    @Test
    public void findByIdExistingJugador() {
        // arrange
        Jugador expectedJugador = new Jugador(1, "Lionel Messi", "Argentina", 91);

        // act
        Jugador foundJugador = repository.findById(1);

        // assert
        Assertions.assertEquals(expectedJugador, foundJugador);
    }

    @Test
    public void findByIdNonExistingJugador() {
        // act
        Jugador foundJugador = repository.findById(999);
        // assert
        Assertions.assertNull(foundJugador);
    }

    @Test
    public void createNewJugador() {
        // arrange
        Jugador newJugador =new Jugador(21, "Julian Alvarez", "Argentina", 32);

        // act
        Boolean result = repository.create(newJugador);

        // assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(newJugador, repository.findById(21));
    }

    @Test
    public void updateExistingJugador() {
        // arrange
        Jugador existingJugador = repository.findById(1);
        existingJugador.setGoles(350);

        // act
        Boolean result = repository.update(existingJugador);

        // assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(existingJugador, repository.findById(1));
    }

    @Test
    public void updateNonExistingJugador() {
        // arrange
        Jugador nonExistingJugador = new Jugador(999, "Inexistente","Nada", 0);

        // act
        Boolean result = repository.update(nonExistingJugador);

        // assert
        Assertions.assertFalse(result);
    }

    @Test
    public void deleteExistingJugador() {
        // arrange
        Jugador existingJugador = repository.findById(1);

        // act
        Boolean result = repository.delete(existingJugador);

        // assert
        Assertions.assertTrue(result);
        Assertions.assertNull(repository.findById(1));
    }

    @Test
    public void deleteNonExistingJugador() {
        // arrange
        Jugador nonExistingJugador = new Jugador(999, "Inexistente","Nada", 0);

        // act
        Boolean result = repository.delete(nonExistingJugador);

        // assert
        Assertions.assertFalse(result);
    }
}
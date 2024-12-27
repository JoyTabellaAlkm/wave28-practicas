package ar.com.mercadolibre.mundial.unit.repository;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JugadorRepositoryTest {

    @Autowired
    JugadorRepository jugadorRepository;

    @Mock
    ObjectMapper objectMapper;

    private static final Jugador jugador1 = new Jugador(1, "Lionel Messi", "Argentina", 91);
    private static final Jugador jugador2 = new Jugador(2, "Cristiano Ronaldo", "Portugal", 85);

    @Test
    @DisplayName("getAll OK")
    public void getAllOk () {
        //ACT
        List<Jugador> allJugadores = jugadorRepository.getAll();

        //ASSERT
        assertNotNull(allJugadores, "La lista no deberia estar vacia");
    }

    @Test
    @DisplayName("create OK")
    public void createOk () {
        //ACT
        boolean created = jugadorRepository.create(jugador1);

        //ASSERT
        assertTrue(created, "Deberia crear el jugador sin problemas");
    }

    @Test
    @DisplayName("find OK")
    public void findOk () {
        //ACT
        Jugador jugadorEncontrado = jugadorRepository.find(1);

        //ASSERT
        assertNotNull(jugadorEncontrado, "Deberia encontrar el jugador con ID 1");
    }

    @Test
    @DisplayName("find Not found")
    public void findNotFound () {
        //ASSERT
        assertThrows(RuntimeException.class,
                () -> jugadorRepository.find(100));
    }

    @Test
    @DisplayName("remove Ok")
    public void removeOk () {
        //ACT
        boolean jugadorEliminado = jugadorRepository.remove(jugador1);

        //ASSERT
        assertTrue(jugadorEliminado, "Deberia eliminar el jugador encontrado");
    }

    @Test
    @DisplayName("remove Not Found")
    public void removeNotFound () {
        //ACT
        boolean jugadorEliminado = jugadorRepository.remove(new Jugador(123, "Pedro", "Argentina", 12));

        //ASSERT
        assertFalse(jugadorEliminado, "No deberia eliminar el jugador inexistente");
    }
}

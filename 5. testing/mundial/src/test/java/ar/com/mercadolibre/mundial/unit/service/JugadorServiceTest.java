package ar.com.mercadolibre.mundial.unit.service;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.impl.JugadorServiceImpl;
import ar.com.mercadolibre.mundial.utils.JugadorGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JugadorServiceTest {

    @Mock
    private JugadorRepository jugadorRepository;

    @InjectMocks
    private JugadorServiceImpl jugadorService;

    @Test
    @DisplayName("Validar que Messi tenga 91 goles")
    void validarGolesDeMessi() {
        when(jugadorRepository.findById(1)).thenReturn(new Jugador(1, "Lionel Messi", "Argentina"
                , 91));
        Jugador messi = jugadorService.obtenerJugadorPorId(1);
        assertNotNull(messi, "El jugador Messi no debería ser null");
        assertEquals(91, messi.getGoles(), "Messi debería tener 91 goles");
    }

    @Test
    @DisplayName("Validar que la lista contenga 20 jugadores")
    void validarCantidadDeJugadores() {
        when(jugadorRepository.findAll()).thenReturn(JugadorGenerator.findAll());
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        assertNotNull(jugadores, "La lista de jugadores no debería ser null");
        assertEquals(20, jugadores.size(), "Deberían haber 20 jugadores en la lista");
    }

    @Test
    @DisplayName("Validar que los jugadores estén ordenados por goles de mayor a menor")
    void validarOrdenDeJugadoresPorGoles() {
        when(jugadorRepository.findAll()).thenReturn(JugadorGenerator.findAll());
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        assertNotNull(jugadores, "La lista de jugadores no debería ser null");
        assertEquals(91, jugadores.get(0).getGoles(), "El primer jugador debe tener 91 goles");
        assertEquals(85, jugadores.get(1).getGoles(), "El segundo jugador debe tener 85 goles");
        assertEquals(77, jugadores.get(2).getGoles(), "El tercer jugador debe tener 77 goles");
    }

    @Test
    @DisplayName("Validar que Cristiano Ronaldo tiene 85 goles")
    void validarGolesDeCristianoRonaldo() {
        when(jugadorRepository.findById(2)).thenReturn(new Jugador(2, "Cristiano Ronaldo", "Portugal", 85));
        Jugador cristianoRonaldo = jugadorService.obtenerJugadorPorId(2);
        assertNotNull(cristianoRonaldo, "El jugador Cristiano Ronaldo no debería ser null");
        assertEquals(85, cristianoRonaldo.getGoles(), "Cristiano Ronaldo debería tener 85 goles");
    }

    @Test
    @DisplayName("Validar que no existe jugador con ID 100")
    void validarJugadorInexistente() {
        when(jugadorRepository.findById(100)).thenReturn(null);
        Jugador jugadorInexistente = jugadorService.obtenerJugadorPorId(100);
        assertNull(jugadorInexistente, "El jugador con ID 100 debería ser null");
    }

    @Test
    @DisplayName("Validar que el jugador con ID 10 es Sergio Agüero y tiene 41 goles")
    void validarJugadorPorId() {
        when(jugadorRepository.findById(10)).thenReturn(new Jugador(10, "Sergio Agüero", "Argentina", 41));
        Jugador aguero = jugadorService.obtenerJugadorPorId(10);
        assertNotNull(aguero, "El jugador Agüero no debería ser null");
        assertEquals("Sergio Agüero", aguero.getNombre(), "El jugador debería ser Sergio Agüero");
        assertEquals(41, aguero.getGoles(), "Sergio Agüero debería tener 41 goles");
    }

    @Test
    @DisplayName("Validar que la lista de jugadores contiene a Kylian Mbappé")
    void validarJugadorKylianMbappe() {
        when(jugadorRepository.findAll()).thenReturn(JugadorGenerator.findAll());
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        assertNotNull(jugadores, "La lista de jugadores no debería ser null");
        assertTrue(jugadores.stream().anyMatch(j -> j.getNombre().equals("Kylian Mbappé")),
                "La lista debería contener a Kylian Mbappé");
    }

    @Test
    public void crearJugador() {
        // arrange
        Jugador newJugador =new Jugador(21, "Julian Alvarez", "Argentina", 32);

        // act
        Mockito.when(jugadorRepository.create(newJugador)).thenReturn(true);
        boolean obtenido =jugadorService.save(newJugador);

        // assert
        verify(jugadorRepository, atLeastOnce()).create(newJugador);
        Assertions.assertTrue(obtenido);
    }
    @Test
    public void actualizarJugador() {
        // arrange
        Jugador newJugador =new Jugador(21, "Julian Alvarez", "Argentina", 32);

        // act
        Mockito.when(jugadorRepository.update(newJugador)).thenReturn(true);
        boolean obtenido = jugadorService.update(newJugador);

        // assert
        verify(jugadorRepository, atLeastOnce()).update(newJugador);
        Assertions.assertTrue(obtenido);
    }
    @Test
    public void borrarJugador() {
        // arrange
        Jugador juagador =new Jugador(21, "Julian Alvarez", "Argentina", 32);

        // act
        Mockito.when(jugadorRepository.delete(juagador)).thenReturn(true);
        boolean obtenido = jugadorService.delete(juagador);

        // assert
        verify(jugadorRepository, atLeastOnce()).delete(juagador);
        Assertions.assertTrue(obtenido);
    }
}

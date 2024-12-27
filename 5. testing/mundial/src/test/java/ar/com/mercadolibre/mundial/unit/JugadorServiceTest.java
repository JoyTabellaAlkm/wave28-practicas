package ar.com.mercadolibre.mundial.unit;

import ar.com.mercadolibre.mundial.excception.NotFoundException;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.impl.JugadorServiceImpl;
import ar.com.mercadolibre.mundial.util.JugadorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JugadorServiceTest {
    private final List<Jugador> jugadoresMock = JugadorFactory.crearJugadoresMock();

    @Mock
    private JugadorRepository jugadorRepository;

    @InjectMocks
    private JugadorServiceImpl jugadorService;

    @BeforeEach
    void setUp() {
        when(jugadorRepository.obtenerJugadores()).thenReturn(jugadoresMock);
    }

    @Test
    @DisplayName("Validar que Messi tenga 91 goles")
    void validarGolesDeMessi() {
        Jugador messi = jugadorService.obtenerJugadorPorId(1);
        assertNotNull(messi, "El jugador Messi no debería ser null");
        assertEquals(91, messi.getGoles(), "Messi debería tener 91 goles");
    }

    @Test
    @DisplayName("Validar que la lista contenga 20 jugadores")
    void validarCantidadDeJugadores() {
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        assertNotNull(jugadores, "La lista de jugadores no debería ser null");
        assertEquals(20, jugadores.size(), "Deberían haber 20 jugadores en la lista");
    }

    @Test
    @DisplayName("Validar que los jugadores estén ordenados por goles de mayor a menor")
    void validarOrdenDeJugadoresPorGoles() {
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        assertNotNull(jugadores, "La lista de jugadores no debería ser null");
        assertEquals(91, jugadores.get(0).getGoles(), "El primer jugador debe tener 91 goles");
        assertEquals(85, jugadores.get(1).getGoles(), "El segundo jugador debe tener 85 goles");
        assertEquals(77, jugadores.get(2).getGoles(), "El tercer jugador debe tener 77 goles");
    }

    @Test
    @DisplayName("Validar que Cristiano Ronaldo tiene 85 goles")
    void validarGolesDeCristianoRonaldo() {
        Jugador cristianoRonaldo = jugadorService.obtenerJugadorPorId(2);
        assertNotNull(cristianoRonaldo, "El jugador Cristiano Ronaldo no debería ser null");
        assertEquals(85, cristianoRonaldo.getGoles(), "Cristiano Ronaldo debería tener 85 goles");
    }

    @Test
    @DisplayName("Validar que no existe jugador con ID 100")
    void validarJugadorInexistente() {
        assertThrows(NotFoundException.class, () -> jugadorService.obtenerJugadorPorId(100));
    }

    @Test
    @DisplayName("Validar que el jugador con ID 10 es Sergio Agüero y tiene 41 goles")
    void validarJugadorPorId() {
        Jugador aguero = jugadorService.obtenerJugadorPorId(10);
        assertNotNull(aguero, "El jugador Agüero no debería ser null");
        assertEquals("Sergio Agüero", aguero.getNombre(), "El jugador debería ser Sergio Agüero");
        assertEquals(41, aguero.getGoles(), "Sergio Agüero debería tener 41 goles");
    }

    @Test
    @DisplayName("Validar que la lista de jugadores contiene a Kylian Mbappé")
    void validarJugadorKylianMbappe() {
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        assertNotNull(jugadores, "La lista de jugadores no debería ser null");
        assertTrue(jugadores.stream().anyMatch(j -> j.getNombre().equals("Kylian Mbappé")),
                "La lista debería contener a Kylian Mbappé");
    }

    @Test
    @DisplayName("Validar que se cree un jugador")
    void validarCreacionJugador() {
        Jugador nuevoJugador = JugadorFactory.jugadorNoExistenteMock();

        jugadorService.crearJugador(nuevoJugador);
        jugadoresMock.add(nuevoJugador);

        Jugador result = jugadorService.obtenerJugadorPorId(nuevoJugador.getId());

        assertNotNull(result);
        assertEquals(result,nuevoJugador);
    }

    @Test
    @DisplayName("Validar que se borra el segundo jugador")
    void validarBorrarJugador() {
        jugadorService.borrarJugador(2);
        jugadoresMock.remove(1);

        assertThrows(NotFoundException.class, () -> jugadorService.obtenerJugadorPorId(2));
    }

    @Test
    @DisplayName("Validar que se intenta borrar jugador que no existe")
    void validarBorrarJugadorNoExistente() {
        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        assertThrows(NotFoundException.class, () -> jugadorService.borrarJugador(jugador.getId()));
    }

    @Test
    @DisplayName("Validar que se modifica jugador")
    void validarEdicionJugador() {
        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        jugadoresMock.add(jugador);
        jugador.setNombre("Araña");

        jugadorService.modificarJugador(jugador);

        Jugador result = jugadorService.obtenerJugadorPorId(jugador.getId());
        assertEquals(jugador,result);
    }

    @Test
    @DisplayName("Se intenta modificar jugador que no existe")
    void validarEdicionJugadorNoExistente() {
        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        assertThrows(NotFoundException.class, () -> jugadorService.modificarJugador(jugador));
    }
}

package ar.com.mercadolibre.mundial.unit;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.impl.JugadorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JugadorServiceTest {

    @Mock
    private JugadorRepository jugadorRepository;

    @InjectMocks
    private JugadorServiceImpl jugadorService;

    @BeforeEach
    void setUp() {
        List<Jugador> jugadoresMock = Arrays.asList(
                new Jugador(1, "Lionel Messi", "Argentina", 91),
                new Jugador(2, "Cristiano Ronaldo", "Portugal", 85),
                new Jugador(3, "Neymar Jr", "Brasil", 77),
                new Jugador(4, "Kylian Mbappé", "Francia", 52),
                new Jugador(5, "Luis Suárez", "Uruguay", 68),
                new Jugador(6, "Robert Lewandowski", "Polonia", 72),
                new Jugador(7, "Karim Benzema", "Francia", 59),
                new Jugador(8, "Mohamed Salah", "Egipto", 51),
                new Jugador(9, "Harry Kane", "Inglaterra", 68),
                new Jugador(10, "Sergio Agüero", "Argentina", 41),
                new Jugador(11, "Eden Hazard", "Bélgica", 33),
                new Jugador(12, "Gareth Bale", "Gales", 38),
                new Jugador(13, "Antoine Griezmann", "Francia", 47),
                new Jugador(14, "Paul Pogba", "Francia", 20),
                new Jugador(15, "Dusan Tadic", "Serbia", 25),
                new Jugador(16, "Luka Modric", "Croacia", 17),
                new Jugador(17, "Sadio Mané", "Senegal", 44),
                new Jugador(18, "Romelu Lukaku", "Bélgica", 68),
                new Jugador(19, "Zlatan Ibrahimović", "Suecia", 62),
                new Jugador(20, "Edinson Cavani", "Uruguay", 56)
        );
        when(jugadorRepository.cargarJugadores()).thenReturn(jugadoresMock);
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
        Jugador jugadorInexistente = jugadorService.obtenerJugadorPorId(100);
        assertNull(jugadorInexistente, "El jugador con ID 100 debería ser null");
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
    @MockitoSettings(strictness = Strictness.LENIENT)
    @DisplayName("Validar creacion de nuevo jugador")
    void validarCreacionDeNuevoJugador(){
        Jugador nuevoJugador = new Jugador(1, "Lionel Messi", "Argentina", 91);
        when(jugadorRepository.crearNuevojugador(nuevoJugador)).thenReturn(nuevoJugador);
        Jugador jugadorCreado = jugadorService.createJugador(nuevoJugador);
        assertNotNull(jugadorCreado, "el jugador no deberia ser nulo");
        assertEquals(nuevoJugador, jugadorCreado, "el jugador deberia ser igual");
    }

    @Test
    @DisplayName("Validar traer toda la lista de jugadores")
    void validarTraerTodaLista (){
        List<Jugador> jugadores = jugadorService.todosLosJugadores();

        assertNotNull(jugadores, "verificamos que la lista no sea nula");
        assertFalse(jugadores.isEmpty(), "verificamos que la lista no este vacia");
    }
}

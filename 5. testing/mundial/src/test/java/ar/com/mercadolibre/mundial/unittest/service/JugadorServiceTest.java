package ar.com.mercadolibre.mundial.unittest.service;

import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.model.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.service.impl.JugadorServiceImpl;
import ar.com.mercadolibre.mundial.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;

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
    @DisplayName("Validar que se cree un nuevo jugador")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void validarJugadorNuevo() {
        // Arrange
        JugadorDTO param = new JugadorDTO(200, "Andres Balero", "Colombia", 5);
        JugadorDTO jugadorEsperado = param;
        Jugador paramMock = Utils.mapper.convertValue(param, Jugador.class);
        // Act
        Mockito.when(jugadorRepository.guardar(paramMock)).thenReturn(paramMock);
        JugadorDTO jugadorObtenido = jugadorService.guardar(param);

        // Assert
        Assertions.assertEquals(jugadorObtenido, jugadorEsperado);
    }

    @Test
    @DisplayName("Validar que un jugador se pueda editar")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void validarPoderEditarJugador(){
        // arrange
        JugadorDTO param = new JugadorDTO(201, "Felipe Martinez", "Venezuela", 7);
        JugadorDTO jugadorEsperado = param;
        Jugador paramMock = Utils.mapper.convertValue(param, Jugador.class);
        // act
        Mockito.when(jugadorRepository.editar(paramMock)).thenReturn(paramMock);
        JugadorDTO jugadorObtenido = jugadorService.editar(param);
        // assert
        assertEquals(jugadorEsperado, jugadorObtenido);
    }

    @Test
    @DisplayName("Validar que se elimine un jugador")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void validarEliminarJugador(){
        // arrange
        Boolean valorEsperado = true;
        JugadorDTO param = new JugadorDTO(203, "Juana Arco", "Chile", 10);
        Jugador paramMock = Utils.mapper.convertValue(param, Jugador.class);
        // act
        Mockito.when(jugadorRepository.eliminar(paramMock)).thenReturn(valorEsperado);
        Mockito.when(jugadorRepository.encontrarPorId(param.getId())).thenReturn(paramMock);
        Boolean valorObtenido = jugadorService.eliminar(param.getId());
        // assert
        assertTrue(valorObtenido);
    }

    @Test
    @DisplayName("Validar que se obtengan todos los jugadores")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void validarQueSeObtenganJugadores(){
        // arrange
        List<JugadorDTO> jugadoresEsperados = List.of(
          new JugadorDTO(12, "Messi", "Argentina", 33),
          new JugadorDTO(13, "Cristian Rios", "Brasil", 22)
        );
        List<Jugador> paramMock = jugadoresEsperados.stream()
                .map(j -> Utils.mapper.convertValue(j, Jugador.class)).toList();
        // act
        Mockito.when(jugadorRepository.traerTodos()).thenReturn(paramMock);
        List<JugadorDTO> jugadoresObtenidos = jugadorService.obtenerJugadores();
        // assert
        assertIterableEquals(jugadoresEsperados, jugadoresObtenidos);
    }
}

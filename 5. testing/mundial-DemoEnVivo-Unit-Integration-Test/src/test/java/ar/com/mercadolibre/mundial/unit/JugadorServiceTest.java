package ar.com.mercadolibre.mundial.unit;

import ar.com.mercadolibre.mundial.dto.ErrorDTO;
import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.impl.JugadorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
       // when(jugadorRepository.cargarJugadores()).thenReturn(jugadoresMock);
    }
    ObjectMapper objectMapper = new ObjectMapper();


    //Arrange - Act - Assert

    @Test
    @DisplayName("1- Validar que el método de obtener un jugador por su ID sea correcto")
    @Order(1)
    // Tiene un nombre de Test que se podría usar por convención "WHEN pasa X cosa, THEN return X cosa"
    void whenIdExists_thenReturnJugador() {
        //ARRANGE
        int idEnviado = 1;
        Jugador jugadorEsperado = new Jugador(1, "Lionel Messi", "Argentina", 91);
        //ACT
        when(jugadorRepository.findById(idEnviado)).thenReturn(jugadorEsperado); // Mockeo para decirle a Mockito que devuelva el jugador que yo quiero
        JugadorDTO jugadorObtenido = jugadorService.obtenerJugadorPorId(idEnviado); // Ejecuto el metodo en la realidad que quiero probar
        JugadorDTO jugadorEsperadoDTO = objectMapper.convertValue(jugadorEsperado, JugadorDTO.class); // Convierto el jugadorEsperado

        //ASSERT
        assertNotNull(jugadorObtenido, "El jugador no debería ser null");
        assertEquals(jugadorEsperadoDTO, jugadorObtenido, "El jugador debería ser el esperado");
    }

    @Test
    @DisplayName("2- Validar que no existe jugador con ID 100")
    @Order(2)
    void whenIdDoesNotExist_thenThrowException() {
        //ARRANGE
        int idEntrada = 100;
        //ACT
        ErrorDTO excepcionEsperada= new ErrorDTO("Jugador no encontrado");
        Mockito.when(jugadorRepository.findById(idEntrada)).thenReturn(null);
        //ASSERT
        Assertions.assertThrows( IllegalArgumentException.class,
                () -> jugadorService.obtenerJugadorPorId(idEntrada));

        Assertions.assertEquals(excepcionEsperada.getMessage(), "Jugador no encontrado");
        Mockito.verify(jugadorRepository, times(1)).findById(idEntrada); // Verificamos que el método findById haya sido llamado una vez

    }

    @Test
    @DisplayName("3- Validar que los jugadores estén ordenados por goles de mayor a menor")
    @Order(3)
    void whenNeedsJugadoresOrderedByGolesOK() {
        //ARRANGE
        List<Jugador> jugadoresOrdenadosEsperados = Arrays.asList(
                new Jugador(6, "Robert Lewandowski", "Polonia", 72),
                new Jugador(5, "Luis Suárez", "Uruguay", 68),
                new Jugador(7, "Karim Benzema", "Francia", 59)
        ); // Ya armo la lista con el orden establecido corectamente

        //ACT
        when(jugadorRepository.cargarJugadores()).thenReturn(jugadoresOrdenadosEsperados);
        List<JugadorDTO> jugadoresObtenidos = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        List<JugadorDTO> jugadoresEsperadosDTO = jugadoresOrdenadosEsperados
                .stream()
                .map( jugador -> objectMapper.convertValue(jugador, JugadorDTO.class))
                .toList();

        assertEquals(jugadoresOrdenadosEsperados.get(0).getGoles(), jugadoresObtenidos.get(0).getGoles(),
                "No coincide la cantidad de goles para el jugador en posición 0");
        assertEquals(jugadoresOrdenadosEsperados.get(1).getGoles(), jugadoresObtenidos.get(1).getGoles(),
                "No coincide la cantidad de goles para el jugador en posición 1");
        assertEquals(jugadoresOrdenadosEsperados.get(2).getGoles(), jugadoresObtenidos.get(2).getGoles(),
                "No coincide la cantidad de goles para el jugador en posición 2");


        assertEquals(jugadoresEsperadosDTO, jugadoresObtenidos, "Los jugadores no son los esperados");
        verify(jugadorRepository, times(1)).cargarJugadores();
    }


    @Test
    @DisplayName("4- Validar que el método de obtener un jugador por nombre sea correcto")
    @Order(4)
    void whenNameExists_thenReturnJugador() {
        //ARRANGE
        String nombreEnviado = "Cristiano Ronaldo";
        JugadorDTO jugadorEsperadoDTO = new JugadorDTO(2, "Cristiano Ronaldo", "Portugal", 90);
        List<Jugador> jugadoresList = Arrays.asList(
                new Jugador(1, "Lionel Messi", "Argentina", 91),
                new Jugador(2, "Cristiano Ronaldo", "Portugal", 90));

        //ACT
        when(jugadorRepository.cargarJugadores()).thenReturn(jugadoresList); // Simulo la carga de jugadores
        JugadorDTO jugadorObtenido = jugadorService.obtenerJugadorPorNombre(nombreEnviado);
        //ASSERT
        assertNotNull(jugadorObtenido, "El jugador no debería ser null");
        assertEquals(jugadorEsperadoDTO, jugadorObtenido, "El jugador debería ser el esperado");
        verify(jugadorRepository, times(1)).cargarJugadores();
    }
}

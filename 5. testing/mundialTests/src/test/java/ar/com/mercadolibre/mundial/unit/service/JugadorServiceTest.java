package ar.com.mercadolibre.mundial.unit.service;

import ar.com.mercadolibre.mundial.dto.RequestJugadorDTO;
import ar.com.mercadolibre.mundial.dto.ResponseDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.impl.JugadorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JugadorServiceTest {

    @Mock
    private JugadorRepository jugadorRepository;

    @Mock
    ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private JugadorServiceImpl jugadorService;

    private final List<Jugador> jugadoresMock = Arrays.asList(
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

    @Test
    @DisplayName("Validar que Messi tenga 91 goles")
    void validarGolesDeMessi() {
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        Jugador messi = jugadorService.obtenerJugadorPorId(1);
        assertNotNull(messi, "El jugador Messi no debería ser null");
        assertEquals(91, messi.getGoles(), "Messi debería tener 91 goles");
    }

    @Test
    @DisplayName("Validar que la lista contenga 20 jugadores")
    void validarCantidadDeJugadores() {
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        assertNotNull(jugadores, "La lista de jugadores no debería ser null");
        assertEquals(20, jugadores.size(), "Deberían haber 20 jugadores en la lista");
    }

    @Test
    @DisplayName("Validar que los jugadores estén ordenados por goles de mayor a menor")
    void validarOrdenDeJugadoresPorGoles() {
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        assertNotNull(jugadores, "La lista de jugadores no debería ser null");
        assertEquals(91, jugadores.get(0).getGoles(), "El primer jugador debe tener 91 goles");
        assertEquals(85, jugadores.get(1).getGoles(), "El segundo jugador debe tener 85 goles");
        assertEquals(77, jugadores.get(2).getGoles(), "El tercer jugador debe tener 77 goles");
    }

    @Test
    @DisplayName("Validar que Cristiano Ronaldo tiene 85 goles")
    void validarGolesDeCristianoRonaldo() {
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        Jugador cristianoRonaldo = jugadorService.obtenerJugadorPorId(2);
        assertNotNull(cristianoRonaldo, "El jugador Cristiano Ronaldo no debería ser null");
        assertEquals(85, cristianoRonaldo.getGoles(), "Cristiano Ronaldo debería tener 85 goles");
    }

    @Test
    @DisplayName("Validar que no existe jugador con ID 100")
    void validarJugadorInexistente() {
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        Jugador jugadorInexistente = jugadorService.obtenerJugadorPorId(100);
        assertNull(jugadorInexistente, "El jugador con ID 100 debería ser null");
    }

    @Test
    @DisplayName("Validar que el jugador con ID 10 es Sergio Agüero y tiene 41 goles")
    void validarJugadorPorId() {
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        Jugador aguero = jugadorService.obtenerJugadorPorId(10);
        assertNotNull(aguero, "El jugador Agüero no debería ser null");
        assertEquals("Sergio Agüero", aguero.getNombre(), "El jugador debería ser Sergio Agüero");
        assertEquals(41, aguero.getGoles(), "Sergio Agüero debería tener 41 goles");
    }

    @Test
    @DisplayName("Validar que la lista de jugadores contiene a Kylian Mbappé")
    void validarJugadorKylianMbappe() {
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        assertNotNull(jugadores, "La lista de jugadores no debería ser null");
        assertTrue(jugadores.stream().anyMatch(j -> j.getNombre().equals("Kylian Mbappé")),
                "La lista debería contener a Kylian Mbappé");
    }

    @Test
    @DisplayName("Validar que recupera todos los jugadores")
    void validarListadoTodosJugadores(){
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        List<Jugador> jugadores = jugadorService.getAll();
        assertNotNull(jugadores, "La lista de jugadores no debe ser null");
    }

    @Test
    @DisplayName("Validar que encuentra el jugador por ID")
    void validarShowJugador(){
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        Jugador jugador = jugadorService.show(1);
        assertNotNull(jugador, "El jugador no debe ser null");
    }

    @Test
    @DisplayName("Validar que NO encuentra el jugador por ID")
    void validarShowJugadorNotFound(){
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        assertThrows(RuntimeException.class,
                () -> jugadorService.show(100));
    }

    @Test
    @DisplayName("Validar que crea el jugador")
    void validarCreateJugador(){
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        RequestJugadorDTO requestJugadorDTO = new RequestJugadorDTO("Juan", "Argentina", 12);
        Jugador jugadorCreado = objectMapper.convertValue(requestJugadorDTO, Jugador.class);

        when(jugadorRepository.create(jugadorCreado)).thenReturn(true);

        ResponseDTO responseDTOEsperado = new ResponseDTO("Jugador creado con exito.");

        ResponseDTO responseDTO = jugadorService.create(requestJugadorDTO);

        assertEquals(responseDTO, responseDTOEsperado);
    }

    @Test
    @DisplayName("Validar que NO crea el jugador ya existente")
    void validarCreateJugadorYaExistenteBadRequest(){
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        RequestJugadorDTO requestJugadorDTO = new RequestJugadorDTO("Lionel Messi", "Argentina", 91);
        assertThrows(RuntimeException.class,
                () -> jugadorService.create(requestJugadorDTO));
    }

    @Test
    @DisplayName("Validar que NO crea el jugador por error")
    void validarCreateJugadorErrorBadRequest(){
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        RequestJugadorDTO requestJugadorDTO = new RequestJugadorDTO("Juan", "Argentina", 12);

        Jugador jugadorCreado = objectMapper.convertValue(requestJugadorDTO, Jugador.class);

        when(jugadorRepository.create(jugadorCreado)).thenReturn(false);

        assertThrows(RuntimeException.class,
                () -> jugadorService.create(requestJugadorDTO));
    }

    @Test
    @DisplayName("Validar que actualiza el jugador")
    void validarUpdateJugador(){
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        int idJugador = 1;
        RequestJugadorDTO requestJugadorDTO = new RequestJugadorDTO("Juan Perez", "Argentina", 12);

        Optional<Jugador> jugadorActualizar = jugadorService.getAll()
                .stream()
                .filter(j -> j.getId() == idJugador)
                .findFirst();

        when(jugadorRepository.find(idJugador)).thenReturn(jugadorActualizar.get());

        Jugador jugadorActualizado = jugadorService.update(idJugador, requestJugadorDTO);

        assertEquals(idJugador, jugadorActualizado.getId());
        assertEquals(jugadorActualizado.getNombre(), requestJugadorDTO.getNombre());
        assertEquals(jugadorActualizado.getPais(), requestJugadorDTO.getPais());
        assertEquals(jugadorActualizado.getGoles(), requestJugadorDTO.getGoles());
    }


    @Test
    @DisplayName("Validar que NO actualiza el jugador no existe")
    void validarUpdateNoExisteJugadorBadRequest(){
        int idJugador = 1;
        RequestJugadorDTO requestJugadorDTO = new RequestJugadorDTO("Juan Perez", "Argentina", 12);

        when(jugadorRepository.find(idJugador)).thenThrow(new RuntimeException("Jugador no encontrado"));

        assertThrows(RuntimeException.class,
                () -> jugadorService.update(idJugador, requestJugadorDTO));
    }

    @Test
    @DisplayName("Validar que elimina el jugador")
    void validarDeleteJugador(){
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        int idJugador = 1;
        Optional<Jugador> jugadorEliminar = jugadorService.getAll()
                .stream()
                .filter(j -> j.getId() == idJugador)
                .findFirst();

        when(jugadorRepository.find(idJugador)).thenReturn(jugadorEliminar.get());
        when(jugadorRepository.remove(jugadorEliminar.get())).thenReturn(true);

        ResponseDTO responseDTOEsperada = new ResponseDTO("Se elimino el jugador con exito.");

        ResponseDTO responseDTO = jugadorService.delete(idJugador);

        assertEquals(responseDTO, responseDTOEsperada);
    }


    @Test
    @DisplayName("Validar que NO elimina el jugador no existe")
    void validarDeleteNoExisteJugadorBadRequest(){
        int idJugador = 1;

        when(jugadorRepository.find(idJugador)).thenThrow(new RuntimeException("Jugador no encontrado"));

        assertThrows(RuntimeException.class,
                () -> jugadorService.delete(idJugador));
    }

    @Test
    @DisplayName("Validar que NO elimina el jugador por error")
    void validarDeleteJugadorErrorBadRequest(){
        when(jugadorRepository.getAll()).thenReturn(jugadoresMock);
        int idJugador = 1;
        Optional<Jugador> jugadorEliminar = jugadorService.getAll()
                .stream()
                .filter(j -> j.getId() == idJugador)
                .findFirst();

        when(jugadorRepository.remove(jugadorEliminar.get())).thenReturn(false);

        assertThrows(RuntimeException.class,
                () -> jugadorService.delete(idJugador));
    }
}

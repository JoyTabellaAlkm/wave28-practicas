package ar.com.mercadolibre.mundial.unit.services;

import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.impl.JugadorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JugadorServiceImplTest {
    @Mock
    JugadorRepository jugadorRepository;

    @InjectMocks
    JugadorServiceImpl jugadorService;

    private ObjectMapper mapper;

    public JugadorServiceImplTest() {
        mapper = new ObjectMapper();
    }

    @Test
    void crearJugador() {
        //arrange
        Jugador jugadorEsperado = new Jugador(21,"Juan","Argentina",23);
        JugadorDTO jugadorEsperadoDTO = new JugadorDTO(21,"Juan","Argentina",23);
        //act
        Mockito.when(jugadorRepository
                .agregarJugador(jugadorEsperado))
                .thenReturn(jugadorEsperado);

        JugadorDTO jugadorObtenido = jugadorService.crearJugador(jugadorEsperadoDTO);

        //assert
        Assertions.assertEquals(jugadorEsperadoDTO,jugadorObtenido);
    }

    @Test
    void actualizarJugador() {
        //arrange
        Jugador jugadorEsperado = new Jugador(21,"Juan","Argentina",23);
        JugadorDTO jugadorEsperadoDTO = new JugadorDTO(21,"Juan","Argentina",23);
        //act
        Mockito.when(jugadorRepository
                .actualizarJugador(jugadorEsperado))
                .thenReturn(jugadorEsperado);

        JugadorDTO jugadorObtenido = jugadorService.crearJugador(jugadorEsperadoDTO);

        //assert
        Assertions.assertEquals(jugadorEsperadoDTO,jugadorObtenido);
    }

    @Test
    void eliminarJugador() {
    }

    @Test
    void buscarJugadorPorId() {
    }

    @Test
    void obtenerJugadores() {
    }
}
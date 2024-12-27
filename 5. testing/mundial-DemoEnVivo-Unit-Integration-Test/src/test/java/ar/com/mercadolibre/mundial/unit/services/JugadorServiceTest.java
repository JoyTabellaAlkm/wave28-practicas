package ar.com.mercadolibre.mundial.unit.services;

import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.dto.MensajeDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.services.impl.JugadorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


/*
* Resolucion de ejercicios propuestos,
*  - Test del metodo 'registrarJugador'
* */
@ExtendWith(MockitoExtension.class)
class JugadorServiceTest {
    @Mock
    JugadorRepository jugadorRepository;

    @InjectMocks
    JugadorServiceImpl service;

    @Test
    void registrarJugadorOk() {
        /* arrange */
        JugadorDTO jugadorDTO = new JugadorDTO(100, "Milito", "Argentina", 150);
        ObjectMapper mapper = new ObjectMapper();
        Jugador jugador = mapper.convertValue(jugadorDTO, Jugador.class);
        MensajeDTO expectedResponse = new MensajeDTO("Jugador registrado");
        when(jugadorRepository.save(jugador)).thenReturn(jugador);

        /* act */
        MensajeDTO actualResponse = service.registrarJugador(jugadorDTO);

        /* assert */
        verify(jugadorRepository, atLeastOnce()).save(jugador);
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    void registrarJugadorError() {
        /* arrange */
        JugadorDTO jugadorDTO = new JugadorDTO(1, "Milito", "Argentina", 150);
        when(jugadorRepository.exist(1)).thenReturn(true);

        /* act & assert */
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.registrarJugador(jugadorDTO));
        assertEquals("Ya existe un jugador con este ID", exception.getMessage());
    }
}
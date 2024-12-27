package ar.com.mercadolibre.mundial.integration;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.repository.JugadorRepository;
import ar.com.mercadolibre.mundial.util.JugadorFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import ar.com.mercadolibre.mundial.dto.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JugadorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Obtener jugador por id")
    public void obtenerJugadorPorId() throws Exception {
        // arrange
        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        jugadorRepository.crear(jugador);
        int parametroEntrada = jugador.getId();

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(jugador));

        // act and assert
        mockMvc.perform(get("/jugador/{id}", parametroEntrada))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());

        jugadorRepository.borrar(jugador);
    }

    @Test
    @DisplayName("Obtener jugador por id, el cual no existe")
    public void obtenerJugadorPorIdNoExistente() throws Exception {
        // arrange
        int parametroEntrada = 0;

        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(new ErrorDto("no se ha encontrado jugador por ese id.")));

        // act and assert
        mockMvc.perform(get("/jugador/{id}", parametroEntrada))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());
    }

    @Test
    @Rollback
    @DisplayName("Crear jugador existente (se permiten repetidos, porque trabajamos con listas)")
    public void crearJugadorExistente() throws Exception {
        // arrange
        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        jugadorRepository.crear(jugador);
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().string("true");

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.post("/jugador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jugador)))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());

        jugadorRepository.borrar(jugador);
    }

    @Test
    @DisplayName("Crear jugador no existente")
    public void crearJugadorNoExistente() throws Exception {
        // arrange
        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().string("true");

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.post("/jugador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jugador)))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());

        jugadorRepository.borrar(jugador);
    }

    @Test
    @Rollback
    @DisplayName("Borrar jugador")
    public void borrarJugador() throws Exception {
        // arrange
        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        jugadorRepository.crear(jugador);

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().string("true");

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/jugador/{id}",jugador.getId()))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());

        jugadorRepository.borrar(jugador);
    }

    @Test
    @Rollback
    @DisplayName("Borrar jugador no existente")
    public void borrarJugadorNoExistente() throws Exception {
        // arrange
        int parametroEntradaIdJugador = JugadorFactory.jugadorNoExistenteMock().getId();
        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(new ErrorDto("no se ha encontrado jugador por ese id.")));

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/jugador/{id}", parametroEntradaIdJugador))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());
    }

    @Test
    @Rollback
    @DisplayName("Modificar jugador")
    public void modificarJugador() throws Exception {
        // arrange

        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        jugadorRepository.crear(jugador);
        jugador.setNombre("John Doe");

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().string("true");

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.put("/jugador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jugador)))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());

        jugadorRepository.borrar(jugador);
    }

    @Test
    @Rollback
    @DisplayName("Modificar jugador que no existe")
    public void modificarJugadorNoExistente() throws Exception {
        // arrange
        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(new ErrorDto("no se ha encontrado jugador por ese id.")));

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.put("/jugador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jugador)))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());
    }

    @Test
    @Rollback
    @DisplayName("Obtener todos los jugadores")
    void ObtenerJugadores() throws  Exception {
        // arrange
        Jugador jugador = JugadorFactory.jugadorNoExistenteMock();
        jugadorRepository.crear(jugador);

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // act and assert
        mockMvc.perform(get("/jugador/jugadores"))
                .andExpect(contentTypeEsperado)
                .andExpect(statusEsperado)
                .andExpect(jsonPath("$[-1].id").value(jugador.getId()))  // Accede al ultimo jugador
                .andExpect(jsonPath("$[-1].nombre").value(jugador.getNombre()))  // Accede al nombre del ultimo jugador
                .andDo(print());

        jugadorRepository.borrar(jugador);
    }
}

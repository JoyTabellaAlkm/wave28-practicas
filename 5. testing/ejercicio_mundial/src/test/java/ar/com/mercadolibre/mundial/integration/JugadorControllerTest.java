package ar.com.mercadolibre.mundial.integration;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.services.JugadorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JugadorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JugadorService jugadorService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testObtenerJugadorPorId() throws Exception {
        mockMvc.perform(get("/jugadores/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Lionel Messi"))
                .andExpect(jsonPath("$.pais").value("Argentina"))
                .andExpect(jsonPath("$.goles").value(91));
    }

    @Test
    public void testObtenerJugadorPorId_NoFound() throws Exception {
        mockMvc.perform(get("/jugadores/99"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testObtenerJugadoresOrdenadosPorGoles() throws Exception {
        mockMvc.perform(get("/jugadores"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(20))
                .andExpect(jsonPath("$[0].goles").value(91))
                .andExpect(jsonPath("$[1].goles").value(85))
                .andExpect(jsonPath("$[2].goles").value(77));
    }

    @Test
    public void testCrearJugador() throws Exception {
        Jugador jugador =new Jugador(21, "Julian Alvarez", "Argentina", 32);

        mockMvc.perform(post("/jugadores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jugador)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Julian Alvarez"))
                .andExpect(jsonPath("$.pais").value("Argentina"))
                .andExpect(jsonPath("$.goles").value(32));
    }

    @Test
    public void testActualizarJugador() throws Exception {
        Jugador jugador = new Jugador(1, "Lionel Messi", "Argentina", 848);


        mockMvc.perform(put("/jugadores/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jugador)))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testActualizarJugador_NotFound() throws Exception {
        Jugador jugador = new Jugador(99, "Kylian Mbappe", "Francia", 600);

        mockMvc.perform(put("/jugadores/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jugador)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testEliminarJugador() throws Exception {
        mockMvc.perform(delete("/jugadores/4"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testEliminarJugador_NotFound() throws Exception {
        mockMvc.perform(delete("/jugadores/99"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
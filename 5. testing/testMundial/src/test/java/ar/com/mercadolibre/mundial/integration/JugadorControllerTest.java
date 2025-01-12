package ar.com.mercadolibre.mundial.integration;

import ar.com.mercadolibre.mundial.models.Jugador;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JugadorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Jugador jugador1;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        jugador1 = new Jugador(1, "Lionel Messi", "Argentina", 91);
    }

    @Test
    @DisplayName("Debe retornar un jugador por Id")
    public void obtenerJugadorPorIdOk() throws Exception {
        int parametroEntrada = 1;
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(jugador1));
        ResultMatcher typeEsperado = content().contentType("application/json");

        mockMvc.perform(get("/jugador/{id}", parametroEntrada))
                .andExpectAll(statusEsperado, typeEsperado, bodyEsperado)
                .andDo(print());
    }
}

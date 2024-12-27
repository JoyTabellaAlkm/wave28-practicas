package ar.com.mercadolibre.mundial.integration.controller;

import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static javax.management.Query.value;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JugadorControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void registrarJugadorOk() throws Exception {
        JugadorDTO jugador = new JugadorDTO(21, "Joy Tabella", "Argentina", 1);
        String request = stringedBody(jugador);
        ResultMatcher statusCreated = status().isCreated();
        ResultMatcher jsonResponse = content().contentType("application/json");
        ResultMatcher expectedResponse = MockMvcResultMatchers.jsonPath("$.mensaje").value("Jugador registrado");

        mockMvc.perform(post("/jugador").content(request).contentType("application/json"))
                .andExpect(statusCreated)
                .andExpect(jsonResponse)
                .andExpect(expectedResponse)
                .andDo(print());
    }

    @Test
    void registrarJugadorError() throws Exception {
        JugadorDTO jugador = new JugadorDTO(1, "Lionel Messi", "Argentina", 91);
        String request = stringedBody(jugador);
        ResultMatcher statusNotFound = status().isNotFound();
        ResultMatcher jsonResponseType = content().contentType("application/json");
        ResultMatcher expectedResponse = content().string(containsString("Ya existe"));

        mockMvc.perform(post("/jugador").content(request).contentType("application/json"))
                .andExpect(statusNotFound)
                .andExpect(jsonResponseType)
                .andExpect(expectedResponse)
                .andDo(print());
    }

    @Test
    void obtenerJugadorPorNombreOk() throws Exception {
        String nombreABuscar = "Lionel Messi";
        ResultMatcher statusOk = status().isOk();
        ResultMatcher jsonResponseType = content().contentType("application/json");
        ResultMatcher expectedName = MockMvcResultMatchers.jsonPath("$.nombre").value("Lionel Messi");
        ResultMatcher expectedGoals = MockMvcResultMatchers.jsonPath("$.goles").value(91);

        mockMvc.perform(get("/jugador").queryParam("nombre", nombreABuscar))
                .andExpect(statusOk)
                .andExpect(jsonResponseType)
                .andExpect(expectedName)
                .andExpect(expectedGoals)
                .andDo(print());
    }

    @Test
    void obtenerJugadorPorNombreError() throws Exception {
        String nombreABuscar = "Leo";
        ResultMatcher statusNotFound = status().isNotFound();
        ResultMatcher jsonResponseType = content().contentType("application/json");
        ResultMatcher expectedErrorMessage = MockMvcResultMatchers.jsonPath("$.message").value("Jugador no encontrado");

        mockMvc.perform(get("/jugador").queryParam("nombre", nombreABuscar))
                .andExpect(statusNotFound)
                .andExpect(jsonResponseType)
                .andExpect(expectedErrorMessage)
                .andDo(print());
    }

    private String stringedBody(JugadorDTO jugador) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writer().writeValueAsString(jugador);
    }
}

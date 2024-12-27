package ar.com.mercadolibre.mundial.integration.controller;

import ar.com.mercadolibre.mundial.dto.ExceptionDTO;
import ar.com.mercadolibre.mundial.dto.RequestJugadorDTO;
import ar.com.mercadolibre.mundial.dto.ResponseDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class JugadorControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static final Jugador jugador1 = new Jugador(1, "Lionel Messi", "Argentina", 91);
    private static final Jugador jugador2 = new Jugador(2, "Cristiano Ronaldo", "Portugal", 85);
    private static final Jugador jugador3 = new Jugador(321, "Juan Perez", "Argentina", 12);

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("getAll Ok")
    public void testGetAllOK() throws Exception {
        //ARRANGE
        List<Jugador> jugadoresEsperado = List.of(jugador1, jugador2);
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(jugadoresEsperado));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(get("/jugadores"))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("show Ok")
    public void testShowOK() throws Exception {
        //ARRANGE
        int idJugador = jugador1.getId();
        Jugador jugadorEsperado = jugador1;
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(jugadorEsperado));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(get("/jugadores/{id}", idJugador))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }


    @Test
    @DisplayName("show Not Found")
    public void testShowNotFound() throws Exception {
        //ARRANGE
        int idJugador = 123;
        ExceptionDTO exceptionDTO = new ExceptionDTO("No se encontro el jugador");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(get("/jugadores/{id}", idJugador))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }


    @Test
    @DisplayName("create Ok")
    public void testCreateOK() throws Exception {
        //ARRANGE
        ResponseDTO responseDTO = new ResponseDTO("Jugador creado con exito.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(responseDTO));
        ResultMatcher statusEsperado = status().isCreated();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(post("/jugadores")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(jugador3)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("create Exists")
    public void testCreateExist() throws Exception {
        //ARRANGE
        ExceptionDTO exceptionDTO = new ExceptionDTO("El jugador ya existe.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(post("/jugadores")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(jugador1)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("create Invalid Name")
    public void testCreateInvalidName() throws Exception {
        //ARRANGE
        ExceptionDTO exceptionDTO = new ExceptionDTO("El nombre del jugador no puede estar vacío.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        RequestJugadorDTO requestJugadorDTONameInvalid = new RequestJugadorDTO("", "Argentina", 12);

        // ACT & ASSERT
        mockMvc.perform(post("/jugadores")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestJugadorDTONameInvalid)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("create Invalid Country")
    public void testCreateInvalidCountry() throws Exception {
        //ARRANGE
        ExceptionDTO exceptionDTO = new ExceptionDTO("El pais del jugador no puede estar vacío.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        RequestJugadorDTO requestJugadorDTONameInvalid = new RequestJugadorDTO("Juan", "", 12);

        // ACT & ASSERT
        mockMvc.perform(post("/jugadores")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestJugadorDTONameInvalid)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("create Invalid Goals")
    public void testCreateInvalidGoals() throws Exception {
        //ARRANGE
        ExceptionDTO exceptionDTO = new ExceptionDTO("El jugador no puede tener menos de 0 goles.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        RequestJugadorDTO requestJugadorDTONameInvalid = new RequestJugadorDTO("Juan", "Argentina", -12);

        // ACT & ASSERT
        mockMvc.perform(post("/jugadores")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestJugadorDTONameInvalid)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("create Invalid json")
    public void testCreateInvalidJson() throws Exception {
        //ARRANGE
        ExceptionDTO exceptionDTO = new ExceptionDTO("Formato invalido en la request.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(post("/jugadores")
                        .contentType("application/json")
                        .content("\"dsa\""))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("update Ok")
    public void testUpdateOk() throws Exception {
        //ARRANGE
        int idJugador = 1;
        Jugador jugadorActualizado = new Jugador(1, "Pedro Gomez", "Argentina" , 32);
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(jugadorActualizado));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        RequestJugadorDTO requestJugadorDTO = new RequestJugadorDTO(jugadorActualizado.getNombre(),
                                                                    jugadorActualizado.getPais(),
                                                                    jugadorActualizado.getGoles());

        // ACT & ASSERT
        mockMvc.perform(put("/jugadores/{id}", idJugador)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestJugadorDTO)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("update Invalid Name")
    public void testUpdateInvalidName() throws Exception {
        //ARRANGE
        int idJugador = 1;
        ExceptionDTO exceptionDTO = new ExceptionDTO("El nombre del jugador no puede estar vacío.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        RequestJugadorDTO requestJugadorDTONameInvalid = new RequestJugadorDTO("", "Argentina", 12);

        // ACT & ASSERT
        mockMvc.perform(put("/jugadores/{id}", idJugador)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestJugadorDTONameInvalid)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("update Invalid Country")
    public void testUpdateInvalidCountry() throws Exception {
        //ARRANGE
        int idJugador = 1;
        ExceptionDTO exceptionDTO = new ExceptionDTO("El pais del jugador no puede estar vacío.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        RequestJugadorDTO requestJugadorDTONameInvalid = new RequestJugadorDTO("Juan", "", 12);

        // ACT & ASSERT
        mockMvc.perform(put("/jugadores/{id}", idJugador)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestJugadorDTONameInvalid)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("update Invalid Goals")
    public void testUpdateInvalidGoals() throws Exception {
        //ARRANGE
        int idJugador = 1;
        ExceptionDTO exceptionDTO = new ExceptionDTO("El jugador no puede tener menos de 0 goles.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        RequestJugadorDTO requestJugadorDTONameInvalid = new RequestJugadorDTO("Juan", "Argentina", -12);

        // ACT & ASSERT
        mockMvc.perform(put("/jugadores/{id}", idJugador)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestJugadorDTONameInvalid)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }


    @Test
    @DisplayName("delete Ok")
    public void testDeleteOk() throws Exception {
        //ARRANGE
        int idJugador = 1;
        ResponseDTO responseDTO = new ResponseDTO("Se elimino el jugador con exito.");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(responseDTO));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(delete("/jugadores/{id}", idJugador))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("delete Not Found")
    public void testNotFoundOk() throws Exception {
        //ARRANGE
        int idJugador = 123;
        ExceptionDTO exceptionDTO = new ExceptionDTO("Jugador no encontrado");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(delete("/jugadores/{id}", idJugador))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }
}

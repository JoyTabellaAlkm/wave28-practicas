package ar.com.mercadolibre.mundial.integration;

import ar.com.mercadolibre.mundial.dto.ErrorDTO;
import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class JugadorControllerITest {

    @Autowired
    MockMvc mockMvc;

    private JugadorDTO jugadorNuevo =  new JugadorDTO(100, "Maria", "Venezuela", 1);


    List<Jugador> jugadoresDePrueba = Arrays.asList(
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
            new Jugador(20, "Edinson Cavani", "Uruguay", 56));
    private static final Jugador jugador1 = new Jugador(
            1, "Lionel Messi", "Argentina", 91);

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Obtiene un jugador por su ID")
    @Order(1)
    public void obtenerJugadorPorIdOk() throws Exception {

        //ARRANGE
        int parametroEntrada = 1;

        ResultMatcher statusEsperado= status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(jugador1));

        //ACT && ASSERT
        mockMvc.perform(get("/jugador/{id}",parametroEntrada))
                .andExpectAll(
                        statusEsperado, contentTypeEsperado, bodyEsperado
                ).andDo(print());
    }

    @Test
    @DisplayName("Lanza excepcion cuando ID no existe")
    @Order(2)
    public void obtenerJugadorPorIdNotFound() throws Exception {

        //ARRANGE
        int parametroEntrada = 0;
        ErrorDTO mensajeEsperado = new ErrorDTO( "Jugador no encontrado");

        ResultMatcher statusEsperado= status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(mensajeEsperado));

        //ACT && ASSERT
        mockMvc.perform(get("/jugador/{id}",parametroEntrada))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Obtiene la lista de jugadores ordenados por cantidad de goles")
    @Order(3)
    public void obtenerJugadoresOrdenadosPorGolesOk() throws Exception {

        //ARRANGE
        ResultMatcher statusEsperado= status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(jugadoresDePrueba));

        //ACT && ASSERT
        mockMvc.perform(get("/jugadores"))
                .andExpectAll(
                        statusEsperado, contentTypeEsperado, bodyEsperado
                ).andDo(print());
    }

    @Test
    @DisplayName("Validar que al registrar un jugador funcione correctamente")
    @Order(4)
    public void registerPlayerIsOk() throws Exception{
        //Arrange
        ResultMatcher statusEsperado = status().isCreated();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        String body = objectMapper.writeValueAsString(jugadorNuevo);

        //ACT && ASSERT
        mockMvc.perform(post("/jugador")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(jsonPath("$.mensaje").value("Jugador registrado"));
    }

    @Test
    @DisplayName("Si no consigue el jugador lanzar excepcion y codigo de status correspondiente ")
    @Order(5)
    public void registerPlayerIsNotFound() throws Exception {

        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        String body = objectMapper.writeValueAsString(jugadoresDePrueba.get(1));

        mockMvc.perform(post("/jugador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(contentTypeEsperado)
                .andExpect(statusEsperado)
                .andExpect(jsonPath("$.message").value("Ya existe un jugador con este ID"))
                .andDo(print());

    }


    @Test
    @DisplayName("Validar que cuando se busque por nombre, funcione correctamente")
    @Order(6)
    public void obtenerJugadorPorNombresOk() throws Exception {

        //ARRANGE
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(jugadoresDePrueba.get(1)));
        String parametroEntrada = jugadoresDePrueba.get(1).getNombre();

        //ACT && ASSERT
        mockMvc.perform(get("/jugador")
                        .param("nombre", parametroEntrada)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(bodyEsperado)
                .andDo(print());
        ;
    }

    @Test
    @DisplayName("Cuando el jugador no existe, verificar excepciones")
    @Order(7)
    public void obtenerJugadorPorNombreIsNotFound() throws Exception{

        //ARRANGE
        String name = "Pepe";

        //ACT && ASSERT
        mockMvc.perform(get("/jugador")
                        .param("nombre", name)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Jugador no encontrado"))
                .andDo(print());
        ;

    }
}

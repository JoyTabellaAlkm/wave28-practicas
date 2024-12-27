package ar.com.mercadolibre.mundial.integration;

import ar.com.mercadolibre.mundial.dto.ErrorDTO;
import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.dto.MensajeDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.*;
import org.mockito.internal.matchers.Or;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JugadorControllerITest {

    @Autowired
    MockMvc mockMvc;

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
    @DisplayName("1 - Obtiene un jugador por su ID")
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
    @DisplayName("2 - Lanza excepcion cuando ID no existe")
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
    @DisplayName("3 - Obtiene la lista de jugadores ordenados por cantidad de goles")
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
    @DisplayName("4 - Registra jugador ok")
    @Order(4)
    public void registrarJugador() throws Exception {


        ObjectWriter objectWriter = objectMapper.writer();
        String jsonString = objectWriter.writeValueAsString(new JugadorDTO(21,"Juan","Peru", 4));

        //ARRANGE
        ResultMatcher statusEsperado= status().isCreated();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(new MensajeDTO("Jugador registrado")));



        mockMvc.perform(post("/jugador")
                        .content(jsonString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        statusEsperado, contentTypeEsperado, bodyEsperado
                ).andDo(print());
    }

    @Test
    @DisplayName("5 - Registra jugador ya existente")
    @Order(5)
    public void registrarJugadorException() throws Exception {


        ObjectWriter objectWriter = objectMapper.writer();
        String jsonString = objectWriter.writeValueAsString(new JugadorDTO(1,"Juan","Peru", 4));

        //ARRANGE
        ResultMatcher statusEsperado= status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(new ErrorDTO("Ya existe un jugador con este ID")));



        mockMvc.perform(post("/jugador")
                        .content(jsonString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        statusEsperado, contentTypeEsperado, bodyEsperado
                ).andDo(print());
    }


    @Test
    @DisplayName("6 - Obtener jugador por nombre Ok")
    @Order(6)
    public void obtenerPorNombre() throws Exception {

        String parametroEntrada = "Lionel Messi";
        ResultMatcher statusEsperado= status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(new JugadorDTO(1,"Lionel Messi","Argentina", 91)));

        mockMvc.perform(get("/jugador").param("nombre",parametroEntrada))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());

    }

    @Test
    @DisplayName("7 - Obtener jugador por nombre inexistente")
    @Order(7)
    public void obtenerPorNombreException() throws Exception {

        String parametroEntrada = "Lucas Caraballo";
        ResultMatcher statusEsperado= status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(new ErrorDTO("Jugador no encontrado")));

        mockMvc.perform(get("/jugador").param("nombre",parametroEntrada))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());

    }

}

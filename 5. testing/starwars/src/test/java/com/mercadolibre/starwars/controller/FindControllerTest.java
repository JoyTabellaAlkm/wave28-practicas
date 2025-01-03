package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService findService;

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    private FindController findController;

    @Test
    public void findExistingCharactersTest() {
        // ARRANGE
        List<CharacterDTO> expectedCharacters = List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );
        String expectedQuery = "darth";
        Mockito.when(findService.find(expectedQuery)).thenReturn(expectedCharacters);

        // ACT
        List<CharacterDTO> obtainedCharacters = findController.find(expectedQuery);

        // ASSERT
        Mockito.verify(findService, Mockito.atLeastOnce()).find(expectedQuery);
        Assertions.assertEquals(expectedCharacters, obtainedCharacters);
    }

    @Test
    public void findNotExistingCharacterTest() {
        // ARRANGE
        List<CharacterDTO> expectedCharacters = new ArrayList<>();
        String expectedQuery = "hola";
        Mockito.when(findService.find(expectedQuery)).thenReturn(expectedCharacters);

        // ACT
        List<CharacterDTO> obtainedCharacters = findController.find(expectedQuery);

        // ARRANGE
        Mockito.verify(findService, Mockito.atLeastOnce()).find(expectedQuery);
        Assertions.assertEquals(expectedCharacters, obtainedCharacters);
    }

    @Test
    public void findExistingCharacters() throws Exception {
        String query = "darth";

        // Para este test, asumimos que el servicio findService está correctamente implementado
        // y retorna los personajes de acuerdo a la consulta "darth".

        // Aquí el JSON esperado debe coincidir con la respuesta que retorna tu servicio.
        String expectedJson = "["
                + "{\"name\":\"Darth Vader\", \"hair_color\":\"none\", \"skin_color\":\"white\", \"eye_color\":\"yellow\", \"birth_year\":\"41.9BBY\", \"gender\":\"male\", \"homeworld\":\"Tatooine\", \"species\":\"Human\", \"height\":202, \"mass\":136},"
                + "{\"name\":\"Darth Maul\", \"hair_color\":\"none\", \"skin_color\":\"red\", \"eye_color\":\"yellow\", \"birth_year\":\"54BBY\", \"gender\":\"male\", \"homeworld\":\"Dathomir\", \"species\":\"Zabrak\", \"height\":175, \"mass\":80}"
                + "]";

        mockMvc.perform(get("/" + query)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    public void findNotExistingCharacter() throws Exception {
        String query = "unknown";

        // Asegúrate que el comportamiento de tu servicio sea el esperado para un personaje no encontrado
        String expectedJson = "[]"; // Esperar una lista vacía

        mockMvc.perform(get("/" + query)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}

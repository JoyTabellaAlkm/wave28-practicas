package com.mercadolibre.starwars.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class StarWarsControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Test OK - List all StarWars characters")
    public void getCharactersByNameOK() throws Exception {
        //Arrange
        List<CharacterDTO> expectedCharacters = List.of(
                new CharacterDTO("Darth Vader",202,136, "male","Tatooine", "Human"),
                new CharacterDTO("Darth Maul",175,80, "male","Dathomir", "Zabrak")
        );
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(expectedCharacters));

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/characters")
                        .param("name", "darth"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(bodyEsperado)
                .andDo(print());
    }

}

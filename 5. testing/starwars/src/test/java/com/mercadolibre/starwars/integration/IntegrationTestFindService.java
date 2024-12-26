package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestFindService {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    List<CharacterDTO> characters;

    private String convertObjectToJsonString(List<CharacterDTO> characters) {
        try {
            return writer.writeValueAsString(characters);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @BeforeEach
    public void beforEach() {
        characters = List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );
    }

    @Test
    public void Get_All_Existing_Characters_With_Darth_Query() throws Exception {
        String expectedQuery = "darth";
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/{query}", expectedQuery)).
                andDo(MockMvcResultHandlers.print()).
                andExpect(content().contentType("application/json")).
                andExpect(status().isOk()).
                andExpect(content().json(convertObjectToJsonString(characters)));
    }

    @Test
    public void Get_No_Characters_With_Wrong_Query() throws Exception {
        String expectedQuery = "hola";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/{query}", expectedQuery)).
                andDo(MockMvcResultHandlers.print()).
                andExpect(content().contentType("application/json")).
                andExpect(status().isOk()).
                andExpect(content().json("[]"));
    }
}

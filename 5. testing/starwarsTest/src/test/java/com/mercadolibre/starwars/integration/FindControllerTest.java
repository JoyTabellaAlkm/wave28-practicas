package com.mercadolibre.starwars.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final CharacterDTO Pj1 =
        new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY",
                "male", "Tatooine", "Human", 202, 136);

    private static final CharacterDTO Pj2 =
        new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY",
            "male", "Dathomir", "Zabrak", 175, 80);

    @Test
    public void cFindTest() throws Exception {
        // Arrange
        List<CharacterDTO> charactersEsperados = List.of(Pj1,Pj2);
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(charactersEsperados));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");


        // ACT & ASSERT
        mockMvc.perform(get("/darth"))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }
}

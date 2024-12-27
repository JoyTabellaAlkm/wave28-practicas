package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final List<CharacterDTO> paramMock = List.of(
            new CharacterDTO("Luke Skywalker", "blond", "fair", "blue",
                    "19BBY", "male", "Tatooine", "Human",
                    172, 77)
    );

    ObjectMapper obj = new ObjectMapper();
    @Test
    @DisplayName("Obtiene un personaje por ID")
    public void findController() throws Exception {
        // arrange

        String parametroEntrada = "Luke";
        ResultMatcher estatusEsperado = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType("application/json");
        ResultMatcher content = MockMvcResultMatchers.content().json(obj.writeValueAsString(paramMock));
        // act assert
        mockMvc.perform(get("/{query}",parametroEntrada)).
                andExpect(estatusEsperado).
                andExpect(contentType).
                andExpect(content).
                andDo(print()).
                andReturn();
    }
}

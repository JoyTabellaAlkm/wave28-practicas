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

import static com.mercadolibre.starwars.utils.TestUtilsFactory.getDarthCharacters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getCharactersByKeyPhrase() throws Exception {
        String keyPhrase = "darth";
        List<CharacterDTO> expectedCharacters = getDarthCharacters();
        String expectedJson = objectMapper.writeValueAsString(expectedCharacters);
        System.out.println("Expected JSON: " + expectedJson);
        ResultMatcher expectedResponse = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(expectedJson);

        mockMvc.perform(get("/{query}", keyPhrase))
                .andExpect(expectedResponse)
                .andExpect(expectedContentType)
                .andExpect(expectedBody)
                .andDo(print());
    }
}

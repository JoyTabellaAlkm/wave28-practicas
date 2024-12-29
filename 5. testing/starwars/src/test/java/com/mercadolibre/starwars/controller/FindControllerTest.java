package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTest {

    @Autowired
    private FindService findService;

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp(){
        findService.saveCharacter(new CharacterDTO("Lucas bianchi", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
    }


    @Test
    @DisplayName("test OK-  obtener characters ")
    void find() throws Exception{
        String name = "Lucas";
//        arrange
        List<CharacterDTO> characterDTOList = List.of(new CharacterDTO("Lucas bianchi", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));

        mockMvc.perform(get("/{query}", name))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(characterDTOList)))
                .andDo(print());
    }

    @Test
    @DisplayName("Test Ok - eliminar character")
    void deleteCharacterByName() throws Exception{
        String name = "Lucas Bianchi";
        boolean res = true;

        mockMvc.perform(delete("/{name}", name))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(res)))
                .andDo(print());

    }

    @Test
    @DisplayName("Test Ok - agregar character")
    void addCharacter() throws Exception{
        CharacterDTO reqBody = new CharacterDTO("tomas bianchi", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        String jsonReq = mapper.writeValueAsString(reqBody);
        mockMvc.perform(post("/add-character")
                        .contentType("application/json")
                        .content(jsonReq))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf("true")))
                .andDo(print());
    }

}
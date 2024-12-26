package com.bootcamp.ejercicio_starwars.controller;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDto;
import com.bootcamp.ejercicio_starwars.model.Personaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonajeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private static final String URI = "/personajes";

    @Test
    void getAllPersonajes() throws Exception {
        MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get(URI))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        var data = mapToList(res.getResponse().getContentAsString());
        Assertions.assertEquals(4, data.size());
    }

    @Test
    void givenName_getAllPersonajes() throws Exception {
        MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get(URI).param("name","luk"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        var data = mapToList(res.getResponse().getContentAsString());
        Assertions.assertEquals(2, data.size());
    }

    @Test
    void givenEmptyName_getAllPersonajes() throws Exception {
        MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get(URI).param("name",""))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        var data = mapToList(res.getResponse().getContentAsString());
        Assertions.assertEquals(4, data.size());
    }

    private List<PersonajeDto> mapToList(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
       return mapper.readValue(json, new TypeReference<List<PersonajeDto>>(){});
    }
}

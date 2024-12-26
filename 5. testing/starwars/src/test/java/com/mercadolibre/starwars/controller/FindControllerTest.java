package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    FindService findService;

    @Test
    void testFind_CorrectQuery() throws Exception{
        when(findService.find("Darth")).thenReturn(List.of(
                new CharacterDTO("Darth Vader"),
                new CharacterDTO("Darth Maul")
        ));

        mockMvc.perform(get("/Darth"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Darth Vader"))
                .andExpect(jsonPath("$[1].name").value("Darth Maul"));
    }

    @Test
    void testFind_NoResults() throws Exception {
        when(findService.find("Gandalf")).thenReturn(List.of());

        mockMvc.perform(get("/Gandalf"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0)); // Verificar que la lista esté vacía
    }

    @Test
    void testFind_InvalidQuery_EmptyString() throws Exception {

        when(findService.find("")).thenReturn(List.of());
        mockMvc.perform(get("/"))
                .andExpect(status().is4xxClientError());
    }
}

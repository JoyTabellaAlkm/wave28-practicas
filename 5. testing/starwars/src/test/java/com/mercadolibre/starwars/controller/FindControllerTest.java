package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFind() throws Exception {

        CharacterDTO luckDto = new CharacterDTO();
        luckDto.setName("Luck Skywalker");
        CharacterDTO leaDto = new CharacterDTO();
        leaDto.setName("Lea Skywalker");

        List<CharacterDTO> mockResponse = Arrays.asList(
        );

        String expectedQuery = "Luck Skywalker";

        Mockito.when(findService.find(expectedQuery)).thenReturn(mockResponse);

        List<CharacterDTO> obtainedCharacters = findController.find(expectedQuery);

        Mockito.verify(findService, Mockito.atLeastOnce()).find(expectedQuery);

        Assertions.assertEquals(mockResponse, obtainedCharacters);
    }
}

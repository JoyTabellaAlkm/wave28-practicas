package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findAllWithExistingCharacters() {
        List<CharacterDTO> expectedCharacters = List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );
        String expectedQuery = "darth";
        Mockito.when(characterRepository.findAllByNameContains(expectedQuery)).thenReturn(expectedCharacters);

        List<CharacterDTO> obtainedCharacters = findService.find(expectedQuery);

        Assertions.assertEquals(expectedCharacters, obtainedCharacters);
    }

    @Test
    public void findAllWithNoExistingCharacters() {
        List<CharacterDTO> expectedCharacters = new ArrayList<>();
        String expectedQuery = "hola";
        Mockito.when(characterRepository.findAllByNameContains(expectedQuery)).thenReturn(expectedCharacters);

        List<CharacterDTO> obtainedCharacters = findService.find(expectedQuery);

        Assertions.assertEquals(expectedCharacters, obtainedCharacters);
    }
}

package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.mercadolibre.starwars.utils.TestUtilsFactory.getDarthCharacters;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    void find() {
        List<CharacterDTO> expectedCharacters = getDarthCharacters();
        String keyPhrase = "darth";
        when(characterRepository.findAllByNameContains(keyPhrase)).thenReturn(expectedCharacters);

        List<CharacterDTO> currentCharacters = findService.find(keyPhrase);

        assertEquals(expectedCharacters, currentCharacters);
    }
}
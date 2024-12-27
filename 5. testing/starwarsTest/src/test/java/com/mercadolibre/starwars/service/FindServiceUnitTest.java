package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceUnitTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    private CharacterDTO character = new CharacterDTO(
            "Luke Skywalker",
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male",
            "Tatooine",
            "Human",
            172,
            12
    );

    @Test
    void givenValidName_whenFindCharacters_thenReturns200AndExpectedBody(){
        String name = "Luke";

        List<CharacterDTO> characters =java.util.List.of(character);

        when(findService.find(name)).thenReturn(characters);

        List<CharacterDTO> getCharacter = findService.find(name);

        assertNotNull(getCharacter);
        assertTrue(characters.equals(getCharacter));


    }

}

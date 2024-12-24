package com.mercadolibre.starwars.unitary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.model.Character;
import com.mercadolibre.starwars.repository.impl.StarWarsRepository;
import com.mercadolibre.starwars.service.impl.StarWarsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StarWarsServiceTest {

    @Mock
    StarWarsRepository starWarsRepository;

    @Mock
    ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    StarWarsService starWarsService;

    @Test
    @DisplayName("Test OK - Get all StarWars characters by name")
    public void getCharactersByNameOK(){
        // Arrange
        String param = "d";
        Integer expectedAmountOfCharacters = 2;

        List<Character> mockedCharacters = List.of(
                new Character("Luke Skywalker",172,77, "blond", "fair", "blue","19BBY","male","Tatooine", "Human"),
                new Character("Darth Vader",202,136, "none", "white", "yellow","41.9BBY","male","Tatooine", "Human"),
                new Character("Darth Maul",175,80, "none", "red", "blue","54BBY","male","Dathomir", "Zabrak")
        );

        List<CharacterDTO> expectedCharacters = List.of(
                new CharacterDTO("Darth Vader",202,136, "male","Tatooine", "Human"),
                new CharacterDTO("Darth Maul",175,80, "male","Dathomir", "Zabrak")
        );

        // Act
        Mockito.when(starWarsRepository.getCharacters()).thenReturn(mockedCharacters);
        List<CharacterDTO> obtained = starWarsService.getCharactersByName(param);

        // Assert
        Assertions.assertEquals(expectedAmountOfCharacters, obtained.size());
        Assertions.assertEquals(expectedCharacters, obtained);
    }

    @Test
    @DisplayName("Test not OK - Get all StarWars characters by name return empty list")
    public void getCharactersByNameBadPath(){
        // Arrange
        String param = "222";
        Integer expectedAmountOfCharacters = 0;

        List<Character> mockedCharacters = List.of(
                new Character("Luke Skywalker",172,77, "blond", "fair", "blue","19BBY","male","Tatooine", "Human"),
                new Character("Darth Vader",202,136, "none", "white", "yellow","41.9BBY","male","Tatooine", "Human"),
                new Character("Darth Maul",175,80, "none", "red", "blue","54BBY","male","Dathomir", "Zabrak")
        );

        // Act
        Mockito.when(starWarsRepository.getCharacters()).thenReturn(mockedCharacters);
        List<CharacterDTO> obtained = starWarsService.getCharactersByName(param);

        // Assert
        Assertions.assertEquals(expectedAmountOfCharacters, obtained.size());
        Assertions.assertTrue(obtained.isEmpty());
    }

}

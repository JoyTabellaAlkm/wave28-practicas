package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;


    @Test
    public void testFind() {
        // Arrange
        String query = "Luke";
        List<CharacterDTO> charactersEsperados = List.of(
                new CharacterDTO(
                        "Luke Skywalker","blond","fair","blue","19BBY",
                        "male","Tatooine","Human",172,77));

        // Act
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(charactersEsperados);
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertNotNull(result);
        assertEquals(charactersEsperados, result);
    }

    @Test
    public void testFindEmpty() {
        // Arrange
        String query = "asd";
        List<CharacterDTO> charactersEsperados = new ArrayList<>();

        // Act
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(charactersEsperados);
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertNotNull(result);
        assertEquals(charactersEsperados, result);

    }
}

package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepositoryMock;
    @InjectMocks
    FindService findService;

    @Test
    void testFind_withExistingQuery() {
        // Arrange
        String query = "Darth";
        List<CharacterDTO> expected = List.of(
                new CharacterDTO("Darth Vader"),
                new CharacterDTO("Darth Maul")
        );

        when(characterRepositoryMock.findAllByNameContains(query)).thenReturn(expected);

        // Act
        List<CharacterDTO> actual = findService.find(query);

        // Assert
        assertEquals(2, actual.size());
        assertTrue(actual.stream().anyMatch(c -> c.getName().equals("Darth Vader")));
        assertTrue(actual.stream().anyMatch(c -> c.getName().equals("Darth Maul")));
    }
    @Test
    void testFindNoResults() {
        when(characterRepositoryMock.findAllByNameContains("Unknown")).thenReturn(List.of());

        List<CharacterDTO> results = findService.find("Unknown");

        assertTrue(results.isEmpty());
    }
}

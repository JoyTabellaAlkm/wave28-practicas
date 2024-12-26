package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryImplTest {

    @Autowired
    private CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameContains() {
        // Arrange
        String query = "luke";
        // Act
        List<CharacterDTO> charactersFound = characterRepository.findAllByNameContains(query);
        // Assert
        assertEquals(1, charactersFound.size());
        assertEquals("luke skywalker", charactersFound.get(0).getName().toLowerCase());
    }
}
package com.mercadolibre.starwars.unitary.repository;

import com.mercadolibre.starwars.model.Character;
import com.mercadolibre.starwars.repository.impl.StarWarsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StarWarsRepositoryTest {

    StarWarsRepository starWarsRepository = new StarWarsRepository();

    @Test
    @DisplayName("Test OK - List all StarWars characters")
    public void findAllOK() {
        // Arrange
        Integer expectedNumberOfCharacters = 87;

        // Act
        List<Character> characters = starWarsRepository.getCharacters();

        // Assert
        Assertions.assertEquals(expectedNumberOfCharacters, characters.size());
        Assertions.assertFalse(characters.isEmpty());
    }
}

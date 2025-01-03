package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CharacterRepositoryTest {
    CharacterRepository characterRepository = new CharacterRepositoryImpl();

    @Test
    public void findAllByNameContainsExistingCharacter() {
        // ARRANGE
        String expectedQuery = "darth";

        // ACT
        List<CharacterDTO> obtainedCharacters = characterRepository.findAllByNameContains(expectedQuery);

        // ASSERT
        assertThat(obtainedCharacters).hasSize(2);
        assertThat(obtainedCharacters).extracting(CharacterDTO::getName).containsExactlyInAnyOrder("Darth Vader", "Darth Maul");
    }

    @Test
    public void findAllByNameContainsNoExistingCharacter() {
        // ARRANGE
        String expectedQuery = "fermin";

        // ACT
        List<CharacterDTO> obtainedCharacters = characterRepository.findAllByNameContains(expectedQuery);

        // ASSERT
        assertThat(obtainedCharacters).isEmpty(); // Verifica que no se encontraron personajes
    }
}

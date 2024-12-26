package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CharacterRepositoryTest {
    CharacterRepository characterRepository = new CharacterRepositoryImpl();

    @Test
    public void findAllByNameContainsExistingCharacter() {
        List<CharacterDTO> expectedCharacters = List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );
        String expectedQuery = "darth";

        List<CharacterDTO> obtainedCharacters = characterRepository.findAllByNameContains(expectedQuery);

        Assertions.assertEquals(expectedCharacters, obtainedCharacters);
    }

    @Test
    public void findAllByNameContainsNoExistingCharacter() {
        List<CharacterDTO> expectedCharacters = new ArrayList<>();
        String expectedQuery = "hola";

        List<CharacterDTO> obtainedCharacters = characterRepository.findAllByNameContains(expectedQuery);

        Assertions.assertEquals(expectedCharacters, obtainedCharacters);
    }
}

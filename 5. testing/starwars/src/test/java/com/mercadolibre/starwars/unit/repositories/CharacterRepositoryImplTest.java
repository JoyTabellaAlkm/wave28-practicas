package com.mercadolibre.starwars.unit.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.starwars.utils.TestUtilsFactory.getDarthCharacters;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryImplTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    @DisplayName("findAllByNameContains when is given a key phrase should return a list with characters whose names contain the key phrase")
    void findAllByNameContains() {
        String keyPhrase = "darth";
        List<CharacterDTO> expectedCharacters = getDarthCharacters();

        List<CharacterDTO> obtainedCharacters = characterRepository.findAllByNameContains(keyPhrase);

        assertEquals(expectedCharacters, obtainedCharacters);
    }

    @Test
    @DisplayName("findAllByNameContains when is given a key phrase that has not any match, should return an empty list of characters")
    void findAllByNameContainsEmptyList() {
        String keyPhrase = "pepito";
        List<CharacterDTO> expectedCharacters = new ArrayList<>();

        List<CharacterDTO> obtainedCharacters = characterRepository.findAllByNameContains(keyPhrase);

        assertEquals(expectedCharacters, obtainedCharacters);
        assertEquals(expectedCharacters.size(), obtainedCharacters.size());
    }
}
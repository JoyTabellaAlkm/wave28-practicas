package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CharacterRepositoryTest {

    private final CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains() {

        // ARRANGE
        String param = "Darth";

        // ACT
        List<CharacterDTO> actual = characterRepository.findAllByNameContains(param);

        // ASSERT
        boolean noneMatch = actual
                .stream()
                .noneMatch(c -> c.getName().toUpperCase().contains(param.toUpperCase()));
        assertFalse(noneMatch);

    }

}
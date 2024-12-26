package com.mercadolibre.starwars.unit_tests.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CharacterRepositoryTests {
    @Autowired
    CharacterRepositoryImpl repository;

    @Test
    @DisplayName("Validar que no hay ningún personaje con nombre 'KLS'")
    public void verifyEmptyList() {
        /* arrange */
        String query = "KLS";

        /* act */
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        /* assert */
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Validar que al menos un personaje se contenga 'Dark'")
    public void verifyAtLeastOneDark() {
        /* arrange */
        String query = "Dark";

        /* act */
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        /* assert */
        assertThat(result.size()).isGreaterThanOrEqualTo(1);
    }
}

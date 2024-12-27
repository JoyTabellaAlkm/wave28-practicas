package com.mercadolibre.starwars.repository;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CharacterRepositoryUnitTest {

    private CharacterRepository characterRepository;

    @BeforeEach
    void setUp(){
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void givenValidName_whenFindCharacters_thenReturns200AndExpectedBody() {
        // ARRANGE
        String name = "Luke";

        // ACT
        List<CharacterDTO> getAllCharactes = characterRepository.findAllByNameContains(name);

        // ASSERT
        assertNotNull(getAllCharactes);

    }

}

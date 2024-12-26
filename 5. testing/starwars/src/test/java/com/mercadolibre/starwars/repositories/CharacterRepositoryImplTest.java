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
    private CharacterRepository repository;

    @Test
    void findAllByNameContains() {

        List<CharacterDTO> charactersFound = repository.findAllByNameContains("Luke");

        // assert
        assertEquals(1, charactersFound.size());
        assertEquals("Luke Skywalker", charactersFound.get(0).getName());
    }
}

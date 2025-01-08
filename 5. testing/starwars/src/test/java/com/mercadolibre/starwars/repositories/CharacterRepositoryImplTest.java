package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {
    @Test
    void findAllByNameContains() {
        //arrange
        String name = "Darthasdf";
        CharacterRepository characterRepository = new CharacterRepositoryImpl();
        List <CharacterDTO> obtained;

        //act
        obtained = characterRepository.findAllByNameContains(name);

        //assert
        Assertions.assertTrue(obtained.size()>0);
    }
}
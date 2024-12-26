package com.mercadolibre.starwars.unitTest.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTest {

    CharacterRepository repository = new CharacterRepositoryImpl();

    @Test
    public void findAllExistentStudents() {
        // arrange
        String query = "DarTh";
        List<CharacterDTO> listDarth = List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );


        // act
        List<CharacterDTO> foundCharacters = repository.findAllByNameContains(query);

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(listDarth, foundCharacters));
    }
}

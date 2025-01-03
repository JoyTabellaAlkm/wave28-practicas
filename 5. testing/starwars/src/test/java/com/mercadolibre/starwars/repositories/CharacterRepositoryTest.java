package com.mercadolibre.starwars.repositories;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mercadolibre.starwars.dto.CharacterDTO;

public class CharacterRepositoryTest {

  CharacterRepository characterRepository = new CharacterRepositoryImpl();

  @Test
  @DisplayName("Debe encontrar registros que contienen en su nombre la palabra 'SkyWalKeR'")
  public void findAllByNameContainsTest() {
    // arrange
    String query = "SkyWalKeR";

    // act
    List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

    // assert
    assertNotEquals(result.size(), 0);
    result.stream()
        .forEach(c -> {
          assertTrue(c.getName().toLowerCase().contains(query.toLowerCase()));
        });
  }

}

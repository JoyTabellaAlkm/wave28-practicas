package com.mercadolibre.starwars.service;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.util.TestUtilsGenerator;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

  @Mock
  CharacterRepository characterRepository;

  @InjectMocks
  FindService service;

  @Test
  @DisplayName("Debe encontrar registros que contienen en su nombre la palabra 'DArTh'")
  public void find() {
    // arrange
    String query = "DArTh";
    List<CharacterDTO> expected = TestUtilsGenerator.generateDarthCharacters();
    when(characterRepository.findAllByNameContains(query)).thenReturn(expected);

    // act
    List<CharacterDTO> res = service.find(query);

    // assert
    assertIterableEquals(expected, res);
  }

}

package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    @DisplayName("Test caso feliz: buscar personajes por query")
    @Order(1)
    void testFindCharacters(){
//      //arrange
        List<CharacterDTO> characterList = List.of(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
//                new CharacterDTO("C-3PO", "NA", "gold", "yellow", "112BBY", "NA", "Tatooine", "Droid", 167, 75)
        );

        when(characterRepository.findAllByNameContains("Luke")).thenReturn(characterList);

//      //act
        List<CharacterDTO> result = findService.find("Luke");

        // assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Luke Skywalker", result.get(0).getName());

        // Verify
        verify(characterRepository, times(1)).findAllByNameContains("Luke");

    }


    @Test
    @DisplayName("Test caso no feliz: buscar personajes por query - devuelve vacio")
    @Order(2)
    void testFind_WithNoMatches_ShouldReturnEmptyList() {
        // Arrange
        String query = "Nonexistent";
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        Assertions.assertTrue(result.isEmpty());
        verify(characterRepository, times(1)).findAllByNameContains(query);
    }


    @Test
    @DisplayName("eliminar character")
    @Order(3)
    void test_deleteCharacterByName(){
        String name = "Lucas Bianchi";
        when(characterRepository.deleteCharacterById(name)).thenReturn(true);

        boolean characterDeleted = findService.deleteCharacterByName(name);

        Assertions.assertNotNull(characterDeleted);
        Assertions.assertTrue(characterDeleted);

        verify(characterRepository, times(1)).deleteCharacterById(name);
    }


}
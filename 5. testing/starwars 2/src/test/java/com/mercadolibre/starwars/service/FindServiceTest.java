package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void find() {
        // Arrange
        String query = "luke";
        List<CharacterDTO> characterList = List.of(new CharacterDTO());
        when(characterRepository.findAllByNameContains(query)).thenReturn(characterList);
        // Act
        List<CharacterDTO> characterDTOList = findService.find(query);
        // Assert
        assertEquals(1, characterDTOList.size());
    }

}
package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void find() {

        // arrange
        List<CharacterDTO> characterDTOList = List.of(new CharacterDTO());
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(characterDTOList);
        //act

        List<CharacterDTO> characterDTOList1 = findService.find("Luke");

        //assert

        assertEquals(1, characterDTOList.size());

    }
}

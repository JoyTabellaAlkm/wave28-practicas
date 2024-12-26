package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void find(){

        // arrange
        List<CharacterDTO> characterDTOList = List.of(new CharacterDTO());
        when(findService.find("Luke")).thenReturn(characterDTOList);
        //act

        List<CharacterDTO> characterDTOList1 = findController.find("Luke");

        //assert

        assertEquals(1, characterDTOList.size());

    }



}

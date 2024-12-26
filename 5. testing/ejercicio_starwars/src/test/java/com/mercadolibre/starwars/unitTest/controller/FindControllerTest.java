package com.mercadolibre.starwars.unitTest.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.collections4.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    public void findCharacter() {
        // arrange
        List<CharacterDTO> listDarth = List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );
        String query = "DarTh";

        // act
        when(service.find(query)).thenReturn(listDarth);
        List<CharacterDTO> obtenido = controller.find(query);

        // assert
        verify(service, atLeastOnce()).find(query);
        Assertions.assertTrue(CollectionUtils.isEqualCollection(listDarth, obtenido));
    }
}
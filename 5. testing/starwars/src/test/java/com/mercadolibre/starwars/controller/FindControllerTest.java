package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    public void findExistingCharacters() {
        List<CharacterDTO> expectedCharacters = List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );
        String expectedQuery = "darth";
        Mockito.when(findService.find(expectedQuery)).thenReturn(expectedCharacters);

        List<CharacterDTO> obtainedCharacters = findController.find(expectedQuery);

        Mockito.verify(findService, Mockito.atLeastOnce()).find(expectedQuery);

        Assertions.assertEquals(expectedCharacters, obtainedCharacters);
    }

    @Test
    public void findNotExistingCharacter() {
        List<CharacterDTO> expectedCharacters = new ArrayList<>();
        String expectedQuery = "hola";
        Mockito.when(findService.find(expectedQuery)).thenReturn(expectedCharacters);

        List<CharacterDTO> obtainedCharacters = findController.find(expectedQuery);

        Mockito.verify(findService, Mockito.atLeastOnce()).find(expectedQuery);

        Assertions.assertEquals(expectedCharacters, obtainedCharacters);
    }
}

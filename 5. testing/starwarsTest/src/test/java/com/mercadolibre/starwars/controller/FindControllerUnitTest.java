package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerUnitTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    private final CharacterDTO character = new CharacterDTO(
            "Luke Skywalker",
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male",
            "Tatooine",
            "Human",
            172,
            12
    );

    @Test
    void givenValidName_whenFindCharacters_thenReturns200AndExpectedBody() {
        // ARRANGE
        String name = "Luke";
        List<CharacterDTO> mockCharacters = List.of(character);

        when(findService.find(name)).thenReturn(mockCharacters);

        //ACT
        ResponseEntity<List<CharacterDTO>> response = findController.findCharacter(name);

        // ASSERT
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(mockCharacters, response.getBody());

        verify(findService, times(1)).find(name);
    }
}

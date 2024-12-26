package com.mercadolibre.starwars.unit_tests.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FindControllerTests {
    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    public void findsCharacterThatMatchesName() {
        /* arrange */
        String query = "Dark";
        Integer minimumCharacterMatchs = 1;
        CharacterDTO expectedCharacter = new CharacterDTO();
        expectedCharacter.setName("Dark Veider");
        when(findService.find(query)).thenReturn(List.of(expectedCharacter));

        /* act */
        List<CharacterDTO> result = findController.find(query);

        /* assert */
        verify(findService, atLeast(1)).find(query);
        assertThat(result.size()).isGreaterThanOrEqualTo(minimumCharacterMatchs);
    }

    @Test
    public void responseIsEmptyWhenNameIsIncorrect() {
        /* arrange */
        String query = "Krads";
        Integer expectedCharacterMatchs = 0;
        when(findService.find(query)).thenReturn(List.of());

        /* act */
        List<CharacterDTO> result = findController.find(query);

        /* assert */
        verify(findService, atLeast(1)).find(query);
        assertThat(result.size()).isEqualTo(expectedCharacterMatchs);
    }
}

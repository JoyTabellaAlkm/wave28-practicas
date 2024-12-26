package com.mercadolibre.starwars.unit_tests.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.unit_tests.TestUtilsFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindServiceTests {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService service;

    @Test
    public void validateRepositoryIsCalled() {
        /* arrange */
        String query = "Luke";
        List<CharacterDTO> characterList = List.of(TestUtilsFactory.createCharacter("Luke Skywalker"));
        when(characterRepository.findAllByNameContains(query)).thenReturn(characterList);

        /* act */
        List<CharacterDTO> response = service.find(query);

        /* assert */
        verify(characterRepository, atLeastOnce()).findAllByNameContains(query);
        assertThat(response).hasSizeGreaterThanOrEqualTo(1);
    }
}

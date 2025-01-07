package com.mercadolibre.starwars.unitTest.service;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
        @Mock
        CharacterRepository repository;

        @InjectMocks
        FindService service;

    @Test
    public void getAllStudents() {
        // arrange
        String query = "DarTh";
        List<CharacterDTO> listDarth = List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );

        // act
        when(repository.findAllByNameContains(query)).thenReturn(listDarth);
        List<CharacterDTO> readCharacters = service.find(query);

        // assert
        verify(repository, atLeastOnce()).findAllByNameContains(query);
        Assertions.assertTrue(CollectionUtils.isEqualCollection(listDarth, readCharacters));
    }
}

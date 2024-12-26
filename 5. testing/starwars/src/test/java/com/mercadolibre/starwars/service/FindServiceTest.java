package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
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
class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    private static final List<CharacterDTO> filteredList;

    static {
        filteredList = new ArrayList<>();
        CharacterDTO c1 = new CharacterDTO();
        CharacterDTO c2 = new CharacterDTO();

        c1.setName("Darth Vader");
        c2.setName("Darth Maul");

        filteredList.add(c1);
        filteredList.add(c2);
    }


    @Test
    void find() {

        // ARRANGE
        String param = "Darth";

        // ACT
        when(characterRepository.findAllByNameContains(param)).thenReturn(filteredList);
        List<CharacterDTO> actual = findService.find(param);

        // ASSERT
        boolean noneMatch = actual
                .stream()
                .noneMatch(c -> c.getName().toUpperCase().contains(param.toUpperCase()));
        assertFalse(noneMatch);

    }


}
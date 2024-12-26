package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RepositoryTest {

    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    CharacterRepositoryImpl characterRepositoryImpl = new CharacterRepositoryImpl();

    @Test
    public void findAllByNameTest(){
        List<CharacterDTO> esperado = new ArrayList<>();
        CharacterDTO characterDTO = new CharacterDTO("R2-D2", "NA", "white, blue", "red", "33BBY", "NA", "Naboo", "Droid", 96, 32);
        esperado.add(characterDTO);

        List<CharacterDTO> obtenido = characterRepositoryImpl.findAllByNameContains("2");

        Assertions.assertEquals(esperado, obtenido);
    }

    @Test
    public void findServiceTest(){
        List<CharacterDTO> esperado = new ArrayList<>();
        CharacterDTO characterDTO = new CharacterDTO("R2-D2", "NA", "white, blue", "red", "33BBY", "NA", "Naboo", "Droid", 96, 32);
        esperado.add(characterDTO);

        String query = "2";

        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(esperado);

        List<CharacterDTO> obtenido = findService.find(query);

        Assertions.assertEquals(esperado, obtenido);
    }

}

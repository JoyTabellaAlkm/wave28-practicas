package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    public void findServiceTestOK(){
        //arrange
        List<CharacterDTO> paramMock = List.of(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue",
                        "19BBY", "male", "Tatooine", "Human",
                        172, 77)
        );
        String request = "Luke";

        //act
        Mockito.when(repository.findAllByNameContains(request)).thenReturn(paramMock);

        List<CharacterDTO> response = service.find(request);
        //assert
        Assertions.assertEquals(response,paramMock);
    }
}

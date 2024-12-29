package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryImplTest {


    @Autowired
    private CharacterRepository characterRepository;
    private List<CharacterDTO> characterDTOList = List.of(new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));




    @Test
    void findAllByNameContains() {
//        arrange
        String name = "Luke";
        List<CharacterDTO> characterList = characterRepository.findAllByNameContains(name);
//        act & assert
        assertNotNull(characterList);
        assertEquals(characterDTOList, characterList);
    }


    @Test
    @DisplayName("test: borrar usuario")
    void deleteCharacterById(){
//        arrange
        String name = "Lucas Bianchi";
        characterRepository.saveCharacter(new CharacterDTO("Lucas bianchi", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        boolean deleted = characterRepository.deleteCharacterById(name);

//        act & assert
        assertNotNull(deleted);
        assertTrue(deleted);


    }

    @Test
    @DisplayName("test: update usuario")
    void updateCharacterByName(){
//        arrange
        String name = "Lucas Bianchi";
        characterRepository.saveCharacter(new CharacterDTO("Lucas bianchi", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        CharacterDTO characterUpdate = new CharacterDTO("Juan perez", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        CharacterDTO characterUpdated = characterRepository.updateCharacterByName(name, characterUpdate);

//        act & assert
        assertNotNull(characterUpdated);
        assertEquals(characterUpdate, characterUpdated);

    }

}
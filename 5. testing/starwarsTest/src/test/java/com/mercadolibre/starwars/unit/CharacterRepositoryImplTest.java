package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CharacterRepositoryImplTest {

    private static CharacterRepositoryImpl characterRepositoryImpl;

    @BeforeAll
    public static void setUp() {
        characterRepositoryImpl = new CharacterRepositoryImpl();
    }

    @Test
    public void testFindAllByNameContains() {
        // Arrange
        String query = "Luke";
        // Act
        List<CharacterDTO> result = characterRepositoryImpl.findAllByNameContains(query);
        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testFindAllByNameContainsEmpty() {
        // Arrange
        String query = "asd";
        // Act
        List<CharacterDTO> result = characterRepositoryImpl.findAllByNameContains(query);
        // Assert
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}

package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CharacterRepositoryImplTest {
    @Autowired
    CharacterRepository characterRepository;

    @Test
    void findAllByNameContains() {
        // Arrange
        String param = "luke";

        // Act
        List<CharacterDTO> allByNameContains = characterRepository.findAllByNameContains(param);

        // Assert
        assertEquals(1, allByNameContains.size());
    }

 }
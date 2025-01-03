package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findAllWithExistingCharacters() {
        // ARRANGE
        List<CharacterDTO> expectedCharacters = List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        );
        String expectedQuery = "darth";
        Mockito.when(characterRepository.findAllByNameContains(expectedQuery)).thenReturn(expectedCharacters);

        // ACT
        List<CharacterDTO> obtainedCharacters = findService.find(expectedQuery);

        // ASSERT
        assertThat(obtainedCharacters).isNotNull()
                .hasSize(2) // Verificamos que se encontraron 2 personajes
                .containsExactlyInAnyOrderElementsOf(expectedCharacters); // Verificamos los personajes devueltos

        // O puedes verificar individualmente:
        assertThat(obtainedCharacters.get(0).getName()).isEqualTo("Darth Vader");
        assertThat(obtainedCharacters.get(1).getName()).isEqualTo("Darth Maul");
    }

    @Test
    public void findAllWithNoExistingCharacters() {
        // ARRANGE
        List<CharacterDTO> expectedCharacters = new ArrayList<>();
        String expectedQuery = "hola";
        Mockito.when(characterRepository.findAllByNameContains(expectedQuery)).thenReturn(expectedCharacters);

        // ACT
        List<CharacterDTO> obtainedCharacters = findService.find(expectedQuery);

        // ASSERT
        assertThat(obtainedCharacters).isNotNull()
                .isEmpty(); // Comprobamos que la lista devuelta está vacía
    }

    @Test
    public void findWithNullQuery() {
        // ARRANGE
        String expectedQuery = null;

        // ACT
        List<CharacterDTO> obtainedCharacters = findService.find(expectedQuery);

        // ASSERT
        assertThat(obtainedCharacters).isNotNull()
                .isEmpty(); // Comprobamos que la lista está vacía para consultas nulas
        // Opcionalmente podrías agregar aquí la verificación en tu servicio si permite null o lanza una excepción.
    }

    @Test
    public void findWithEmptyQuery() {
        // ARRANGE
        String expectedQuery = "";

        // ACT
        List<CharacterDTO> obtainedCharacters = findService.find(expectedQuery);

        // ASSERT
        assertThat(obtainedCharacters).isNotNull()
                .isEmpty(); // Comprobamos que la lista está vacía para consultas vacías
    }
}
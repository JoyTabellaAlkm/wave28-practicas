package com.mercadolibre.starwars.utils;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsFactory {

    public static List<CharacterDTO> getDarthCharacters() {
        return new ArrayList<>(
            List.of(
                    new CharacterDTO(
                            "Darth Vader",
                            "none",
                            "white",
                            "yellow",
                            "41.9BBY",
                            "male",
                            "Tatooine",
                            "Human",
                            202,
                            136
                    ),
                    new CharacterDTO(
                            "Darth Maul",
                            "none",
                            "red",
                            "yellow",
                            "54BBY",
                            "male",
                            "Dathomir",
                            "Zabrak",
                            175,
                            80
                    )
            )
        );
    }
}

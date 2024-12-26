package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public class TestUtilsFactory {
    public static List<CharacterDTO> createCharacterList() {
        CharacterDTO c1 = createCharacter("Darth Vader");
        CharacterDTO c2 = createCharacter("Luke");
        CharacterDTO c3 = createCharacter("Han Solo");
        return List.of(c1, c2, c3);
    }

    public static CharacterDTO createCharacter(String name) {
        CharacterDTO character = new CharacterDTO();
        character.setName(name);
        return character;
    }
}

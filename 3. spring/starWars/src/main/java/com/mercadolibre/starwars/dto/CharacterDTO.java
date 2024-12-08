package com.mercadolibre.starwars.dto;

import com.mercadolibre.starwars.model.Character;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {

    public CharacterDTO(Character character) {
        this.name = character.getName();
        this.height = character.getHeight();
        this.mass = character.getMass();
        this.gender = character.getGender();
        this.homeworld = character.getHomeworld();
        this.species = character.getSpecies();
    }

    private String name;
    private Integer  height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public static CharacterDTO fromEntity(Character character) {
        return new CharacterDTO(character);
    }
}

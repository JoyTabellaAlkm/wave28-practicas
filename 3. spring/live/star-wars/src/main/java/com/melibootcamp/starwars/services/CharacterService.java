package com.melibootcamp.starwars.services;

import com.melibootcamp.starwars.dtos.CharacterDTO;
import com.melibootcamp.starwars.entities.Character;

import java.util.List;

public interface CharacterService {
    public List<CharacterDTO> getCharacterListByName(String toFind);
}

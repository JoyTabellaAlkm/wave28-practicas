package com.ejercicios.starwars.services;

import com.ejercicios.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> getCharactersByName(String name);
}
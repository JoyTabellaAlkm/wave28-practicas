package com.ejercicio.starwars.service;

import com.ejercicio.starwars.dto.CharactersDTO;

import java.util.List;

public interface ICharacters {
    public List<CharactersDTO> getCharactersByName(String name) ;

}

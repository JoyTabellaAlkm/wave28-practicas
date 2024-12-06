package com.example.starwars2.service;

import com.example.starwars2.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    public List<CharacterDTO> getCharactersByName(String name);
}

package com.example.starWars.service;

import com.example.starWars.DTO.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> getCharactersByName(String name);
}

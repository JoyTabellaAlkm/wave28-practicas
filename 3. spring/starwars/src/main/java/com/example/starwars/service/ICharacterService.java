package com.example.starwars.service;

import java.util.List;

import com.example.starwars.dto.CharacterDTO;

public interface ICharacterService <T>{
    List<CharacterDTO> findByName(String name);
}

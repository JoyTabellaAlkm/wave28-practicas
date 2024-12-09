package com.example.starwars.repository;

import com.example.starwars.entity.Character;

import java.util.List;

public interface ICharacerRepository {
    List<Character> getCharactersByName(String name);
}

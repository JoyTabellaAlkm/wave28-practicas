package com.example.starWars.repository;

import com.example.starWars.model.Character;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICharacterRepository {
    List<Character> getCharactersByName(String name);
}

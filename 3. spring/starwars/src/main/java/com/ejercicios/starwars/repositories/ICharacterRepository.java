package com.ejercicios.starwars.repositories;

import com.ejercicios.starwars.models.Character;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICharacterRepository {
    List<Character> getCharactersByName(String name);
}

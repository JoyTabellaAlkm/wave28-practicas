package com.melibootcamp.starwars.repositories;

import com.melibootcamp.starwars.entities.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface CharacterRepository {
    public List<Character> readAll();

}

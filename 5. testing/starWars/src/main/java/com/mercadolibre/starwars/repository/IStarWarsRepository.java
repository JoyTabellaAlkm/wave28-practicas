package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.model.Character;

import java.util.List;

public interface IStarWarsRepository {
    public List<Character> getCharacters();
}

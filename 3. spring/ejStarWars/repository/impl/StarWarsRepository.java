package com.mercadolibre.starwars.repository.impl;

import com.mercadolibre.starwars.model.Character;
import com.mercadolibre.starwars.repository.IStarWarsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepository implements IStarWarsRepository {

    private List<Character> characters = new ArrayList<>();

    public StarWarsRepository() {
        Character luke = new Character("Luke Skywalker",2,83,"rubio","blanco","verde", "20/02/1983", "masculino", "tierra", "humano");
        Character darthVader = new Character("Darth Vader",2,130,"marron","oscura","marron", "12/04/1934", "masculino", "saturno", "humano");
        Character darthMaul = new Character("Darth Maul",4,300,"rojo","blanco","verde", "25/03/1922", "indefinido", "jupiter", "humano");

        characters.add(luke);
        characters.add(darthMaul);
        characters.add(darthVader);
    }
    @Override
    public List<Character> getCharacters() {
        return characters;
    }
}

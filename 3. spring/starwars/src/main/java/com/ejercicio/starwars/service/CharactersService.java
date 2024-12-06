package com.ejercicio.starwars.service;

import com.ejercicio.starwars.dto.CharactersDTO;
import com.ejercicio.starwars.repository.CharactersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharactersService implements ICharacters{

    @Autowired
    private CharactersDAO charactersDAO;
    @Override
    public List<CharactersDTO> getCharactersByName(String name) {
        return charactersDAO.FindCharacters(name).stream().map(c -> new CharactersDTO(c.getName(),c.getHeight(), c.getMass(), c.getGender(), c.getHomeworld(), c.getSpecies())).toList();

    }
}

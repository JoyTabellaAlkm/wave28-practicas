package com.mercadolibre.starwars.service.impl;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.model.Character;
import com.mercadolibre.starwars.repository.IStarWarsRepository;
import com.mercadolibre.starwars.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    private IStarWarsRepository starWarsRepository;

    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
        List<Character> characters = starWarsRepository.getCharacters();

        return characters.stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .map(c -> CharacterDTO.fromEntity(c))
                .toList();
    }
}

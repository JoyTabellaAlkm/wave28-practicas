package com.example.starwars2.service.impl;

import com.example.starwars2.dto.CharacterDTO;
import com.example.starwars2.repository.CharacterDAO;
import com.example.starwars2.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    private CharacterDAO characterDAO;

    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
        return characterDAO.FindCharacters(name).stream().map(
                character -> new CharacterDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()
                )
        ).toList();
    }
}

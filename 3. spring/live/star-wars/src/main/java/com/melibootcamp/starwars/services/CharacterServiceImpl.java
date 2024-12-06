package com.melibootcamp.starwars.services;

import com.melibootcamp.starwars.dtos.CharacterDTO;
import com.melibootcamp.starwars.entities.Character;
import com.melibootcamp.starwars.repositories.CharacterRepository;
import com.melibootcamp.starwars.repositories.CharacterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{

    private CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> getCharacterListByName(String toFind) {
        List<Character> toRead = characterRepository.readAll();
        List<CharacterDTO> toReturn = new ArrayList<>();

        for (Character character: toRead.stream().filter(x -> x.getName().toLowerCase().contains(toFind.toLowerCase())).toList()) {
            toReturn.add(new CharacterDTO(
                    character.getName(),
                    character.getHeight(),
                    character.getMass(),
                    character.getGender(),
                    character.getHomeworld(),
                    character.getSpecies()
            ));
        }
        return toReturn;

    }
}

package com.example.starWars.service;

import com.example.starWars.DTO.CharacterDTO;
import com.example.starWars.model.Character;
import com.example.starWars.repository.ICharacterRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CharacterService implements ICharacterService{

    private final ICharacterRepository characterRepository;

    public CharacterService(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
        List<CharacterDTO> charactersDTO;
        List<Character> characters = characterRepository.getCharactersByName(name);
        charactersDTO = characters.stream().map(character ->
                new CharacterDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()
                )).toList();

        return charactersDTO;
    }
}

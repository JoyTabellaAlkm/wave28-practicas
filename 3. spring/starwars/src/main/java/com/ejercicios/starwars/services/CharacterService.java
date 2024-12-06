package com.ejercicios.starwars.services;

import com.ejercicios.starwars.dto.CharacterDTO;
import com.ejercicios.starwars.models.Character;
import com.ejercicios.starwars.repositories.ICharacterRepository;
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

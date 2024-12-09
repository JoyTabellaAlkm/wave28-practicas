package com.example.starwars.services.Impl;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entity.Character;
import com.example.starwars.repository.CharacterRepository;
import com.example.starwars.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository repository;
    @Override
    public List<CharacterDTO> findAllByName (String name) throws IOException {
        List<Character> characters = repository.findAll();

        return characters.stream()
                .filter(p -> p.getName().toUpperCase()
                        .contains(name.toUpperCase()))
                .map(this::mapperDTO).toList();
    }
    private CharacterDTO mapperDTO (Character character){
        Integer height = 0;
        Integer mass= 0;
        try{
            height = Integer.parseInt(character.getHeight());
        }catch (NumberFormatException e){
            System.out.println("No se pudo parsear el peso: "+ character.getHeight());
        }
        try{
            mass = Integer.parseInt(character.getMass());
        }catch (NumberFormatException e){
            System.out.println("No se pudo parsear la masa: "+ character.getMass());
        }

        CharacterDTO characterDTO = new CharacterDTO(character.getName(), height, mass, character.getBirthYear(), character.getGender(), character.getHomeworld(), character.getSpecies());
        return characterDTO;
    }
}

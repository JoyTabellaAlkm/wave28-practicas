package com.mercadolibre.StarWars.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.StarWars.dto.*;
import com.mercadolibre.StarWars.entity.CharacterEntity;
import com.mercadolibre.StarWars.repository.IStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StarWarsServiceImpls implements IStarWasService{
    @Autowired
    private IStarWarsRepository _repository;

    @Override
    public List<CharacterResponseDTO> getNames(String name) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<CharacterResponseDTO> reference = new TypeReference<CharacterResponseDTO>(){};
        List<CharacterResponseDTO> characters = _repository.
                getNames().
                stream().
                filter(c -> c.getName().contains(name)).
                map(c -> new CharacterResponseDTO(
                        c.getName(),
                        c.getHeight().equalsIgnoreCase("NA") ? -1 : Integer.parseInt(c.getHeight()),
                        c.getMass().equalsIgnoreCase("NA") ? -1 : Integer.parseInt(c.getMass()),
                        c.getGender(),
                        c.getHomeworld(),
                        c.getSpecies()
                        )
                ).
                toList();
        return characters;
    }

    @Override
    public AddCharacterResponseDTO addCharacter(CharacterRequestDTO character) {
        AddCharacterResponseDTO response = new AddCharacterResponseDTO("Registrado correctamente");
        _repository.addCharacter(MapperDtoToEntity(character));
        return response;
    }

    @Override
    public PutCharacterResponseDTO putCharacter(int id, CharacterRequestDTO character) {
        return null;
    }

    @Override
    public DeleteCharacterResponseDTO deleteCharacter(int id) {
        return null;
    }

    public CharacterEntity MapperDtoToEntity(CharacterRequestDTO character){
        CharacterEntity entity = new CharacterEntity(
                character.getName(),
                String.valueOf(character.getHeight()),
                String.valueOf(character.getMass()),
                character.getHair_color(),
                character.getSkin_color(),
                character.getEye_color(),
                character.getBirth_year(),
                character.getGender(),
                character.getHomeworld(),
                character.getSpecies()
        );
        return entity;
    }
}

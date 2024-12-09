package com.mercadolibre.StarWars.repository;

import com.mercadolibre.StarWars.dto.AddCharacterResponseDTO;
import com.mercadolibre.StarWars.dto.CharacterRequestDTO;
import com.mercadolibre.StarWars.dto.DeleteCharacterResponseDTO;
import com.mercadolibre.StarWars.dto.PutCharacterResponseDTO;
import com.mercadolibre.StarWars.entity.CharacterEntity;

import java.util.List;

public interface IStarWarsRepository {
    public List<CharacterEntity> getNames();
    public CharacterEntity addCharacter(CharacterEntity character);
    public CharacterEntity putCharacter(int id, CharacterEntity character);
    public boolean deleteCharacter(int id);
}

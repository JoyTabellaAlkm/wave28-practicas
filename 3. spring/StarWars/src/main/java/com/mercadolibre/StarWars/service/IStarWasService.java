package com.mercadolibre.StarWars.service;

import com.mercadolibre.StarWars.dto.*;

import java.util.List;

public interface IStarWasService {
    public List<CharacterResponseDTO> getNames(String name);
    public AddCharacterResponseDTO addCharacter(CharacterRequestDTO character);
    public PutCharacterResponseDTO putCharacter(int id, CharacterRequestDTO character);
    public DeleteCharacterResponseDTO deleteCharacter(int id);
}

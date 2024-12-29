package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
  List<CharacterDTO> findAllByNameContains(String query);

  boolean deleteCharacterById(String name);

  boolean saveCharacter(CharacterDTO characterDTO);

  CharacterDTO updateCharacterByName(String name,CharacterDTO characterDTO);

}

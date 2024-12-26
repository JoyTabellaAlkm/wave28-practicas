package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
  private List<CharacterDTO> database;

  @Value("${api.scope}")
  private String SCOPE;

  public CharacterRepositoryImpl() {
    this.database = new ArrayList<>();
  }

  @Override
  public List<CharacterDTO> findAllByNameContains(String query) {
    return database.stream()
        .filter(characterDTO -> matchWith(query, characterDTO))
        .collect(Collectors.toList());
  }

  private boolean matchWith(String query, CharacterDTO characterDTO) {
    return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
  }

  @PostConstruct
  private void loadDataBase() {
    File file = new File("src/" + SCOPE + "/resources/starwars_characters.json");
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
    List<CharacterDTO> characters = null;
    try {
      characters = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    database = characters;
  }
}

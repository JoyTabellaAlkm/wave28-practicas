package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
  private final List<CharacterDTO> database;
  private ObjectMapper mapper = new ObjectMapper();

  public CharacterRepositoryImpl() {
    this.database = loadDataBase();
  }

  @Override
  public List<CharacterDTO> findAllByNameContains(String query) {
    return database.stream()
        .filter(characterDTO -> matchWith(query, characterDTO))
        .collect(Collectors.toList());
  }

  @Override
  public boolean deleteCharacterById(String name) {
    return database.removeIf(c -> c.getName().equalsIgnoreCase(name));
  }

  @Override
  public boolean saveCharacter(CharacterDTO characterDTO) {
    boolean response =  database.add(characterDTO);
    System.out.println(database);
    return response;
  }

  @Override
  public CharacterDTO updateCharacterByName(String name, CharacterDTO characterDTO) {
    return database.stream()
            .filter(c->c.getName().equalsIgnoreCase(name))
            .findFirst()
            .map(c->{
//              c.setName(characterDTO.getName());
//              c.setBirth_year(characterDTO.getBirth_year());
//              c.setGender(characterDTO.getGender());
//              c.setHeight(characterDTO.getHeight());
//              c.setMass(characterDTO.getMass());
//              c.setHomeworld(characterDTO.getHomeworld());
//              c.setSpecies(characterDTO.getSpecies());
//              c.setEye_color(characterDTO.getEye_color());
//              c.setHair_color(characterDTO.getHair_color());
//              c.setSkin_color(characterDTO.getSkin_color());
              BeanUtils.copyProperties(characterDTO, c); // Copia todas las propiedades
              return c;
            })
            .orElse(null);
  }


  private boolean matchWith(String query, CharacterDTO characterDTO) {
    return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
  }




  private List<CharacterDTO> loadDataBase() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:starwars_characters.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
    List<CharacterDTO> characters = null;
    try {
      characters = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return characters;
  }
}

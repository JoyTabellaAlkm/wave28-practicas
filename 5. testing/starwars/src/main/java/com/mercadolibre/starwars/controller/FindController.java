package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FindController {
  @Autowired
  private FindService findService;

  @GetMapping("/{query}")
  public List<CharacterDTO> find(@PathVariable String query) {
    return findService.find(query);
  }

  @DeleteMapping("/{name}")
  public boolean deleteCharacter(@PathVariable String name){
    return findService.deleteCharacterByName(name);
  }

  @PostMapping("/add-character")
  public boolean addCharacter(@RequestBody CharacterDTO characterDTO){
    return findService.saveCharacter(characterDTO);
  }
}

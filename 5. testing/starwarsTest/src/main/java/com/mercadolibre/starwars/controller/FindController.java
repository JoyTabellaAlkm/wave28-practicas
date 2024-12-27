package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FindController {

  @Autowired
  private FindService findService;

  @GetMapping("/{query}")
  public ResponseEntity<List<CharacterDTO>> findCharacter(@PathVariable String query) {
    return ResponseEntity.ok().body(findService.find(query));
  }
}

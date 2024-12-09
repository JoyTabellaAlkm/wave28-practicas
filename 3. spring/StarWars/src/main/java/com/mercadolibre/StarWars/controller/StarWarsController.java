package com.mercadolibre.StarWars.controller;

import com.mercadolibre.StarWars.dto.AddCharacterResponseDTO;
import com.mercadolibre.StarWars.dto.CharacterRequestDTO;
import com.mercadolibre.StarWars.dto.CharacterResponseDTO;
import com.mercadolibre.StarWars.service.IStarWasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starWar")
public class StarWarsController {

    @Autowired
    IStarWasService _service;


    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<CharacterResponseDTO>> getStarWarsName(@PathVariable String name){
        return new ResponseEntity<List<CharacterResponseDTO>>(_service.getNames(name),HttpStatus.ACCEPTED);
    }

    @PostMapping("/addCharacter")
    public ResponseEntity<AddCharacterResponseDTO> addCharacter(@RequestBody CharacterRequestDTO character){
        return new ResponseEntity<AddCharacterResponseDTO>(_service.addCharacter(character),HttpStatus.CREATED);

    }
}

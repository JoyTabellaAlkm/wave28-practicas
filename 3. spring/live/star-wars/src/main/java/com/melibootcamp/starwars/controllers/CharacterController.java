package com.melibootcamp.starwars.controllers;

import com.melibootcamp.starwars.dtos.CharacterDTO;
import com.melibootcamp.starwars.services.CharacterService;
import com.melibootcamp.starwars.services.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    @Autowired
    private CharacterServiceImpl characterService;

    @GetMapping("/{character}")
    public ResponseEntity<List<CharacterDTO>> findByName(@PathVariable("character") String character){
        List<CharacterDTO> toReturn = characterService.getCharacterListByName(character);
        if(toReturn.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(toReturn, HttpStatus.OK);
        }
    }

}

package com.example.starwars.services;

import com.example.starwars.dto.CharacterDTO;
import lombok.Data;

import java.io.IOException;
import java.util.List;
public interface CharacterService {
    public List<CharacterDTO> findAllByName(String name) throws IOException;
}

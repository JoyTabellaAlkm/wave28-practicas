package com.example.starwars.service;

import com.example.starwars.dto.response.GetCharacterResponse;

public interface ICharacterService {
    GetCharacterResponse getCharacterByName(String name);
}

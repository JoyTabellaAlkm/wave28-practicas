package com.example.starwars.service.impl;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entity.Character;
import com.example.starwars.repository.ICharacerRepository;
import com.example.starwars.dto.response.GetCharacterResponse;
import com.example.starwars.service.ICharacterService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CharacterServiceImpl implements ICharacterService {
    @Autowired
    private ICharacerRepository characerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public GetCharacterResponse getCharacterByName(String name) {
        name = name.toLowerCase();
        List<CharacterDTO> characterDTOs = objectMapper.convertValue(
                characerRepository.getCharactersByName(name),
                new TypeReference<>() {
                }
        );
        return new GetCharacterResponse(characterDTOs);
    }
}

package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entity.CharacterE;
import com.example.starwars.repository.CharacterRepository;
import com.example.starwars.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CharacterService implements ICharacterService<CharacterDTO> {

    @Autowired
    IRepository characterRepository;

    @Override
    public List<CharacterDTO> findByName(String name) {
        List<CharacterE> characterES = characterRepository.findByName(name);
        return characterES.stream().map(c -> {
            int height = 0;
            int mass = 0;

            try {
                height = Integer.parseInt(c.getHeight());
            } catch (NumberFormatException e){}

            try {
                mass = Integer.parseInt(c.getMass());
            } catch (NumberFormatException e){}

            return new CharacterDTO(c.getName(), height, mass, c.getGender(), c.getHomeworld(), c.getSpecies());
        }).toList();
    }
}

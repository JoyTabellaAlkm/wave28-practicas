package com.mercadolibre.athletes.service;

import com.mercadolibre.athletes.dto.response.AthleteDTO;
import com.mercadolibre.athletes.dto.response.SportDTO;
import com.mercadolibre.athletes.model.Sport;
import com.mercadolibre.athletes.repository.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public List<SportDTO> findAllSports(){
        return athleteRepository.findAllSports().stream()
                .map( sport -> new SportDTO(
                            sport.getName(),
                            sport.getLevel()
                        )
                ).toList();
    }

    public SportDTO findSportByName(String name){
        Optional<Sport> sport = athleteRepository.findSportByName(name);
        return sport.map(value -> new SportDTO(value.getName(), value.getLevel()))
                .orElse(null);
    }

    public List<AthleteDTO> findSportPersons(){
        return athleteRepository.findSportPersons().stream()
                .map(person -> new AthleteDTO(
                        person.getFirstname(),
                        person.getLastname(),
                        person.getSports().stream()
                                .map(Sport::getName)
                                .toList()
                    )
                ).toList();
    }
}

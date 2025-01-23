package com.deportistas.service.impl;

import com.deportistas.dto.SportDto;
import com.deportistas.dto.SportLevelDto;
import com.deportistas.dto.SportPersonDto;
import com.deportistas.exception.NotFoundException;
import com.deportistas.repository.IPersonRepository;
import com.deportistas.repository.ISportRepository;
import com.deportistas.service.ISportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SportService implements ISportService {

    private final IPersonRepository personRepository;
    private final ISportRepository sportRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public SportService(IPersonRepository personRepository,
                        ISportRepository sportRepository) {
        this.personRepository = personRepository;
        this.sportRepository = sportRepository;
    }

    @Override
    public List<SportDto> findSports() {
        return sportRepository.findAll().stream().map(sport -> objectMapper.convertValue(sport, SportDto.class)).toList();
    }

    @Override
    public SportLevelDto findSport(String name) {
        return sportRepository.findAll().stream()
                .filter(sport -> Objects.equals(sport.getName(), name))
                .map(sport -> objectMapper.convertValue(sport,SportLevelDto.class))
                .findFirst().orElseThrow(() -> new NotFoundException("No se encontró ningún deporte con ese nombre."));
    }

    @Override
    public List<SportPersonDto> findSportPersons() {
        return personRepository.findAll().stream()
                .filter(person -> person.getSport() != null)
                .map(person -> objectMapper.convertValue(person, SportPersonDto.class))
                .toList();
    }
}

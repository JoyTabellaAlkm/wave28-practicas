package com.bootcamp.ejercicio_covid.service.impl;

import com.bootcamp.ejercicio_covid.dto.PersonDto;
import com.bootcamp.ejercicio_covid.dto.SymptomDto;
import com.bootcamp.ejercicio_covid.repository.IPersonRepository;
import com.bootcamp.ejercicio_covid.service.IPersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<PersonDto> findRiskPerson() {
        return personRepository.findRiskPerson().
                stream()
                .map(p -> objectMapper.convertValue(p, PersonDto.class))
                .toList();
    }
}

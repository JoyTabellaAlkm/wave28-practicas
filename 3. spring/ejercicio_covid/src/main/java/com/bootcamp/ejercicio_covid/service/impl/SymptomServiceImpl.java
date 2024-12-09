package com.bootcamp.ejercicio_covid.service.impl;

import com.bootcamp.ejercicio_covid.dto.PersonDto;
import com.bootcamp.ejercicio_covid.dto.SymptomDto;
import com.bootcamp.ejercicio_covid.repository.ISymptomRepository;
import com.bootcamp.ejercicio_covid.service.ISymptomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomServiceImpl implements ISymptomService {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ISymptomRepository symptomRepository;

    @Override
    public List<SymptomDto> findAll() {
        return symptomRepository.findAll().
                stream()
                .map(s -> objectMapper.convertValue(s, SymptomDto.class))
                .toList();
    }

    @Override
    public String findGravityLevelByName(String name) {
        return symptomRepository.findGravityLevelByName(name);
    }
}

package com.example.Covid19.service.impl;

import com.example.Covid19.dto.PersonRiskDto;
import com.example.Covid19.dto.SymptomDto;
import com.example.Covid19.model.Symptom;
import com.example.Covid19.respository.IHealthRespository;
import com.example.Covid19.service.ICovidService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidServiceImpl implements ICovidService {

    private final IHealthRespository healthRespository;
    private final ModelMapper mapper;

    public CovidServiceImpl(IHealthRespository healthRespository, ModelMapper mapper) {
        this.healthRespository = healthRespository;
        this.mapper = mapper;
    }

    @Override
    public List<SymptomDto> findAll() {
        return healthRespository.findAll().stream()
                .map(symptom -> mapper.map(symptom, SymptomDto.class))
                .toList();
    }

    @Override
    public SymptomDto findByName(String name) {
        return healthRespository.findByName(name)
                .map(symptom -> mapper.map(symptom, SymptomDto.class))
                .orElse(null);
    }

    @Override
    public List<PersonRiskDto> findRiskPerson() {
        return healthRespository.findRiskPerson().stream()
                .map(person -> new PersonRiskDto(
                        person.getName(),
                        person.getLastname(),
                        person.getSymptoms().stream()
                                .map(Symptom::getName)
                                .toList()
                ))
                .toList();
    }
}

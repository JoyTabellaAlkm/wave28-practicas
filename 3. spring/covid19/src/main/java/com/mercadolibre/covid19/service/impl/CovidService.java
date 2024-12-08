package com.mercadolibre.covid19.service.impl;

import com.mercadolibre.covid19.dto.RiskPersonDto;
import com.mercadolibre.covid19.dto.SymptomDto;
import com.mercadolibre.covid19.model.Symptom;
import com.mercadolibre.covid19.repository.ICovidRepository;
import com.mercadolibre.covid19.service.ICovidService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidService implements ICovidService {

    private final ICovidRepository covidRepository;
    private final ModelMapper mapper;

    public CovidService(ICovidRepository covidRepository, ModelMapper mapper) {
        this.covidRepository = covidRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SymptomDto> findAll() {

        return covidRepository.findAll().stream()
                .map(symptom -> mapper.map(symptom, SymptomDto.class))
                .toList();
    }

    @Override
    public SymptomDto findByName(String name) {
        return covidRepository.findByName(name)
                .map(symptom -> mapper.map(symptom, SymptomDto.class))
                .orElse(null);
    }

    @Override
    public List<RiskPersonDto> findRiskPerson() {
        return covidRepository.findRiskPerson().stream()
                .map(person -> new RiskPersonDto(
                        person.getFirstname(),
                        person.getLastname(),
                        person.getSymptoms().stream()
                                .map(Symptom::getName)
                                .toList()
                ))
                .toList();
    }

}

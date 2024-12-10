package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.dto.PersonDTO;
import com.mercadolibre.covid19.dto.SymptomDTO;
import com.mercadolibre.covid19.model.Person;
import com.mercadolibre.covid19.model.Symptom;
import com.mercadolibre.covid19.repository.ICovidRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CovidServiceImpl implements ICovidService {

    private final ICovidRepository repository;
    private final ModelMapper mapper;

    public CovidServiceImpl(ICovidRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<SymptomDTO> findAllSymptoms() {
        return repository.findAllSymptoms().stream()
                .map(symptom -> mapper.map(symptom, SymptomDTO.class)).toList();
    }

    @Override
    public SymptomDTO findByName(String name) {
        return repository.findByName(name).map(person -> mapper.map(person, SymptomDTO.class)).orElse(null);
    }

    @Override
    public List<PersonDTO> findRiskPerson() {
        return repository.findRiskPerson().stream()
                .map(person -> new PersonDTO(
                        person.getName(),
                        person.getLastName(),
                        person.getSymptoms().stream()
                                .map(Symptom::getName)
                                .toList()
                ))
                .toList();
    }
}

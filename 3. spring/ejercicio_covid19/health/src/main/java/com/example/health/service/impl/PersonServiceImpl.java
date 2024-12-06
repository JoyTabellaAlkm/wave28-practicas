package com.example.health.service.impl;

import com.example.health.common.ESymptomSeverity;
import com.example.health.dto.RiskPersonDTO;
import com.example.health.dto.response.person.GetRiskPersonsResponse;
import com.example.health.entity.Person;
import com.example.health.entity.Symptom;
import com.example.health.repository.IPersonRepository;
import com.example.health.repository.ISymptomRepository;
import com.example.health.service.IPersonService;
import com.example.health.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImpl implements IPersonService {
    private final IPersonRepository personRepository;
    private final ISymptomRepository symptomRepository;
    private final ISymptomService symptomService;

    @Autowired
    public PersonServiceImpl(IPersonRepository personRepository,
                             ISymptomRepository symptomRepository,
                             ISymptomService symptomService) {
        this.personRepository = personRepository;
        this.symptomRepository = symptomRepository;
        this.symptomService = symptomService;
    }

    @Override
    public GetRiskPersonsResponse getRiskPersons() {
        List<Person> persons = personRepository.getPersons();
        List<Symptom> symptoms = symptomRepository.getSymptoms();

        List<RiskPersonDTO> riskyPersons = persons.stream()
                .filter(person -> person.getAge() > 60 &&
                        person.getSymptoms().stream()
                                .anyMatch(symptomCode -> symptomService.getSeverityByCode(symptomCode) == ESymptomSeverity.SEVERE))
                .map(person -> new RiskPersonDTO(person.getName(),person.getSurname()))
                .toList();

        return new GetRiskPersonsResponse(riskyPersons);
    }
}

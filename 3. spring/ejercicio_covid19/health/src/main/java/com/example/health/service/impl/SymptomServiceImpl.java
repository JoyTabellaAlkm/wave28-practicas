package com.example.health.service.impl;

import com.example.health.common.ESymptomSeverity;
import com.example.health.dto.SymptomDTO;
import com.example.health.dto.response.symptom.GetSymptomsResponse;
import com.example.health.dto.response.symptom.GetSeverityByNameResponse;
import com.example.health.entity.Symptom;
import com.example.health.repository.ISymptomRepository;
import com.example.health.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SymptomServiceImpl implements ISymptomService {
    private final List<Symptom> symptoms;

    @Autowired
    public SymptomServiceImpl(ISymptomRepository symptomRepository) {
        this.symptoms = symptomRepository.getSymptoms();
    }

    @Override
    public GetSymptomsResponse getSymptoms() {
        List<SymptomDTO> symptomDTOs = symptoms.stream()
                .map(symptom -> new SymptomDTO(symptom.getCode(), symptom.getName()))
                .toList();
        return new GetSymptomsResponse(symptomDTOs);
    }

    @Override
    public GetSeverityByNameResponse getSeverityByName(String name) {
        return new GetSeverityByNameResponse(Objects.requireNonNull(symptoms.stream()
                .filter(symptom -> symptom.getName().equals(name))  // primero filtro
                .map(Symptom::getSeverity)  // para obtener solo campo concreto
                .findFirst()
                .orElse(null)).toString());
    }

    @Override
    public ESymptomSeverity getSeverityByCode(Long code) {
        return  symptoms.stream()
                .filter(symptom -> Objects.equals(symptom.getCode(), code))
                .map(Symptom::getSeverity)
                .findFirst()
                .orElse(null);
    }

}

package com.ar.mercadolibre.ejerciciocovid.service;

import com.ar.mercadolibre.ejerciciocovid.DTO.SymptomDTO;
import com.ar.mercadolibre.ejerciciocovid.model.SeverityLevel;
import com.ar.mercadolibre.ejerciciocovid.model.Symptom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SymptomServiceImpl implements ISymptomService{

    private final List<Symptom> symptoms;

    public SymptomServiceImpl() {
        symptoms = new ArrayList<>();
        symptoms.add(new Symptom(1, "Headache", SeverityLevel.MILD));
        symptoms.add(new Symptom(2, "Fever", SeverityLevel.MODERATE));
        symptoms.add(new Symptom(3, "Shortness of Breath", SeverityLevel.SEVERE));
        symptoms.add(new Symptom(4, "Chest Pain", SeverityLevel.CRITICAL));
        symptoms.add(new Symptom(5, "Severe Pain", SeverityLevel.CRITICAL));
    }

    @Override
    public List<SymptomDTO> findSymptoms() {
        return symptoms.stream().map(symptom -> new SymptomDTO(symptom.getCode(), symptom.getName(), symptom.getSeverityLevel())).toList();
    }

    @Override
    public SymptomDTO findSymptomByName(String name) {
        Optional<Symptom> symptom = symptoms.stream().filter(symp -> symp.getName().equalsIgnoreCase(name)).findFirst();
        try {
            if(symptom.isEmpty()) throw new NoSuchElementException("No valid name provided for that symptom");
        }
        catch (NoSuchElementException e) {
            return null;
        }

        return new SymptomDTO(symptom.get().getCode(), symptom.get().getName(), symptom.get().getSeverityLevel());
    }
}

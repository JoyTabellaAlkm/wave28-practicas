package com.example.health.repository.impl;

import com.example.health.common.ESymptomSeverity;
import com.example.health.entity.Symptom;
import com.example.health.repository.ISymptomRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SymptomRepositoryImpl implements ISymptomRepository {
    private final List<Symptom> symptoms = new ArrayList<>();

    public SymptomRepositoryImpl() {
        symptoms.add(new Symptom(328428L, "resfrio", ESymptomSeverity.MILD));
        symptoms.add(new Symptom(348237L, "mareos", ESymptomSeverity.MODERATE));
        symptoms.add(new Symptom(702L, "ahogos", ESymptomSeverity.SEVERE));
        symptoms.add(new Symptom(111045L, "empacho", ESymptomSeverity.MODERATE));
        symptoms.add(new Symptom(659287L, "fiebre", ESymptomSeverity.SEVERE));
    }

    @Override
    public List<Symptom> getSymptoms() {
        return symptoms;
    }
}

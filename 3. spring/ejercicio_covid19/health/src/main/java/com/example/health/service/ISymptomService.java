package com.example.health.service;

import com.example.health.common.ESymptomSeverity;
import com.example.health.dto.response.symptom.GetSymptomsResponse;
import com.example.health.dto.response.symptom.GetSeverityByNameResponse;

public interface ISymptomService {
    GetSymptomsResponse getSymptoms();

    GetSeverityByNameResponse getSeverityByName(String name);

    ESymptomSeverity getSeverityByCode(Long code);
}

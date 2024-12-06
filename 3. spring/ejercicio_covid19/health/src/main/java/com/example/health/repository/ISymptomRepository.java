package com.example.health.repository;

import com.example.health.entity.Symptom;

import java.util.List;

public interface ISymptomRepository {
    List<Symptom> getSymptoms();
}

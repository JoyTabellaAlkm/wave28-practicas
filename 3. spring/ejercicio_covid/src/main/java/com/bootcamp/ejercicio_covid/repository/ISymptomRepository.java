package com.bootcamp.ejercicio_covid.repository;

import com.bootcamp.ejercicio_covid.entity.Symptom;

import java.util.List;

public interface ISymptomRepository {

    public List<Symptom> findAll();
    public String findGravityLevelByName(String name);
}

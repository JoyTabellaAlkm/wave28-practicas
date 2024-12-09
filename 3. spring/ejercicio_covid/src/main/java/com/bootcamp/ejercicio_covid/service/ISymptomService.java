package com.bootcamp.ejercicio_covid.service;

import com.bootcamp.ejercicio_covid.dto.SymptomDto;
import com.bootcamp.ejercicio_covid.entity.Symptom;

import java.util.List;

public interface ISymptomService {
    public List<SymptomDto> findAll();
    public String findGravityLevelByName(String name);
}

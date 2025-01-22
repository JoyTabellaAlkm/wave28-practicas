package com.example.Covid19.service;

import com.example.Covid19.dto.PersonRiskDto;
import com.example.Covid19.dto.SymptomDto;

import java.util.List;

public interface ICovidService {
    List<SymptomDto> findAll();

    SymptomDto findByName(String name);

    List<PersonRiskDto> findRiskPerson();
}

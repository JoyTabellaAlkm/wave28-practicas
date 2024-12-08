package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.dto.RiskPersonDto;
import com.mercadolibre.covid19.dto.SymptomDto;

import java.util.List;

public interface ICovidService {
    List<SymptomDto> findAll();

    SymptomDto findByName(String name);

    List<RiskPersonDto> findRiskPerson();
}

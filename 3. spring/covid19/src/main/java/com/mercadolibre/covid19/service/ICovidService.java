package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.dto.PersonDTO;
import com.mercadolibre.covid19.dto.SymptomDTO;

import java.util.List;
import java.util.Optional;

public interface ICovidService {
    List<SymptomDTO> findAllSymptoms();
    SymptomDTO findByName(String name);
    List<PersonDTO> findRiskPerson();
}

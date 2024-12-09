package com.mercadolibre.Covid19.service;

import com.mercadolibre.Covid19.dto.SymptomDTO;
import com.mercadolibre.Covid19.dto.response.FindRiskPersonResponseDTO;
import com.mercadolibre.Covid19.dto.response.FindSymptomByNameReponseDTO;
import com.mercadolibre.Covid19.entity.PersonSymptomEntity;

import java.util.List;

public interface ICovidService {
    public List<SymptomDTO> getAllSymptom();
    public FindSymptomByNameReponseDTO getSymptomByName(String name);
    public List<FindRiskPersonResponseDTO> getRiskPerson();
}

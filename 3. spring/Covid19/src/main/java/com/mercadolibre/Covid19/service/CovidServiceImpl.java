package com.mercadolibre.Covid19.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.Covid19.dto.SymptomDTO;
import com.mercadolibre.Covid19.dto.response.FindRiskPersonResponseDTO;
import com.mercadolibre.Covid19.dto.response.FindSymptomByNameReponseDTO;
import com.mercadolibre.Covid19.entity.PersonSymptomEntity;
import com.mercadolibre.Covid19.entity.SymptomEntity;
import com.mercadolibre.Covid19.repository.CovidRepository;
import com.mercadolibre.Covid19.repository.ICovidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidServiceImpl  implements ICovidService{

    @Autowired
    private ICovidRepository _repository;

    @Override
    public List<SymptomDTO> getAllSymptom() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<SymptomDTO> response = new ArrayList<SymptomDTO>();
        List<SymptomEntity> SymptomFromRepository =  _repository.getAllSymptom();


        response = SymptomFromRepository.stream()
                .map(symptom -> objectMapper.convertValue(symptom, SymptomDTO.class))
                .collect(Collectors.toList());
        return response;
    }

    @Override
    public FindSymptomByNameReponseDTO getSymptomByName(String name) {
        FindSymptomByNameReponseDTO response = new FindSymptomByNameReponseDTO();
        SymptomEntity symptomFromRepository = _repository.getSymptomByName(name);

        response.setNivel_de_gravedad(symptomFromRepository.getLevelOfRisk());
        return response;
    }

    @Override
    public List<FindRiskPersonResponseDTO> getRiskPerson() {
        List<FindRiskPersonResponseDTO> response = new ArrayList<FindRiskPersonResponseDTO>();
        List<PersonSymptomEntity> personSymptomEntityListFromRepository = _repository.getRiskPerson().
                stream().filter(ps -> ps.getSymptom().getLevelOfRisk().equals("alto") && ps.getPersona().getAge() >= 60)
                .toList();

        for(PersonSymptomEntity ps : personSymptomEntityListFromRepository){
            response.add(
                    new FindRiskPersonResponseDTO(
                            ps.getPersona().getName(),
                            ps.getPersona().getLastName()
                    )
            );
        }



        return response;
    }
}

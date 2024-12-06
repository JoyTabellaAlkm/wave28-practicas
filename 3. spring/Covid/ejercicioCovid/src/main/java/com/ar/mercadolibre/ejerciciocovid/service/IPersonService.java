package com.ar.mercadolibre.ejerciciocovid.service;

import com.ar.mercadolibre.ejerciciocovid.DTO.PatientDTO;

import java.util.List;

public interface IPersonService {
    List<PatientDTO> findRiskPeople();
}

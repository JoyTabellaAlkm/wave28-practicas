package com.bootcamp.ejercicio_covid.service;

import com.bootcamp.ejercicio_covid.dto.PersonDto;

import java.util.List;

public interface IPersonService {
    public List<PersonDto> findRiskPerson();
}

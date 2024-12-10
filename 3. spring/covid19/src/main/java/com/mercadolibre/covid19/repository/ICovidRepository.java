package com.mercadolibre.covid19.repository;

import com.mercadolibre.covid19.model.Person;
import com.mercadolibre.covid19.model.Symptom;

import java.util.List;
import java.util.Optional;

public interface ICovidRepository {
    List<Symptom> findAllSymptoms();
    Optional<Symptom> findByName(String name);
    List<Person> findRiskPerson();
}

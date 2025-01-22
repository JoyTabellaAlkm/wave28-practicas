package com.example.Covid19.respository;

import com.example.Covid19.model.Person;
import com.example.Covid19.model.Symptom;

import java.util.List;
import java.util.Optional;

public interface IHealthRespository {
    List<Symptom> findAll();

    Optional<Symptom> findByName(String name);

    List<Person> findRiskPerson();
}

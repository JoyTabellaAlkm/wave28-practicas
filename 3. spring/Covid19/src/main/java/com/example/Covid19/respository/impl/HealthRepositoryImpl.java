package com.example.Covid19.respository.impl;

import com.example.Covid19.model.Person;
import com.example.Covid19.model.Symptom;
import com.example.Covid19.respository.IHealthRespository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HealthRepositoryImpl implements IHealthRespository {

    private final List<Symptom> symptoms;
    private final List<Person> persons;

    public HealthRepositoryImpl() {
        symptoms = new ArrayList<>();
        persons = new ArrayList<>();
        fillData();
    }

    @Override
    public List<Symptom> findAll() {
        return symptoms;
    }

    @Override
    public Optional<Symptom> findByName(String name) {
        return symptoms.stream()
                .filter(symptom -> symptom.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<Person> findRiskPerson() {
        return persons.stream()
                .filter(person -> person.getAge() > 60 && !person.getSymptoms().isEmpty())
                .toList();
    }

    private void fillData() {
        Symptom fever = new Symptom(1L, "Fever", 3);
        Symptom cough = new Symptom(2L, "Cough", 2);
        Symptom headache = new Symptom(3L, "Headache", 1);
        Symptom fatigue = new Symptom(4L, "Fatigue", 2);
        Symptom soreThroat = new Symptom(5L, "Sore Throat", 1);

        Person person1 = new Person(1L, "Juan", "Pérez", 30, List.of(fever, cough));
        Person person2 = new Person(2L, "Ana", "González", 25, List.of(headache));
        Person person3 = new Person(3L, "Carlos", "Martínez", 65, List.of(fatigue));
        Person person4 = new Person(4L, "Laura", "López", 70, List.of(soreThroat));
        Person person5 = new Person(5L, "Luis", "Hernández", 90, new ArrayList<>());
        Person person6 = new Person(6L, "Marta", "Jiménez", 35, List.of(fever, fatigue));

        symptoms.add(fever);
        symptoms.add(cough);
        symptoms.add(headache);
        symptoms.add(fatigue);
        symptoms.add(soreThroat);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
    }
}

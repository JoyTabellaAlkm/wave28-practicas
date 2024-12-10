package com.mercadolibre.covid19.repository;

import com.mercadolibre.covid19.model.Person;
import com.mercadolibre.covid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CovidRepositoryImpl implements ICovidRepository{
    private final List<Symptom> symptoms;
    private final List<Person> persons;

    public CovidRepositoryImpl(){
        symptoms = new ArrayList<>();
        persons = new ArrayList<>();
        fillData();
    }

    public List<Symptom> findAllSymptoms(){
        return symptoms;
    }

    public Optional<Symptom> findByName(String name){
        return symptoms.stream().filter(symptom -> symptom.getName().equalsIgnoreCase(name)).findFirst();
    }

    public List<Person> findRiskPerson(){
        return persons.stream().filter(person -> person.getAge() > 60 && person.getSymptoms() != null).toList();
    }

    private void fillData(){
        Symptom fever = new Symptom(1, "Fever", 3);
        Symptom cough = new Symptom(2, "Cough", 2);
        Symptom headache = new Symptom(3, "Headache", 1);
        Symptom fatigue = new Symptom(4, "Fatigue", 2);
        Symptom soreThroat = new Symptom(5, "Sore Throat", 1);

        Person person1 = new Person(1, "Juan", "Pérez", 30, List.of(fever, cough));
        Person person2 = new Person(2, "Ana", "González", 25, List.of(headache));
        Person person3 = new Person(3, "Carlos", "Martínez", 65, List.of(fatigue));
        Person person4 = new Person(4, "Laura", "López", 70, List.of(soreThroat));
        Person person5 = new Person(5, "Luis", "Hernández", 90, new ArrayList<>());
        Person person6 = new Person(6, "Marta", "Jiménez", 35, List.of(fever, fatigue));

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

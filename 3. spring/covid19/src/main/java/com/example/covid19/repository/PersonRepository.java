package com.example.covid19.repository;

import com.example.covid19.domain.Person;
import com.example.covid19.domain.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private List<Person> personList;

    public PersonRepository(){
        this.personList = new ArrayList<>();
    }

    public void add(Person person) {
        personList.add(person);
    }

    public void addSymtom(int id, Symptom symptom) {
        personList.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .ifPresent(person -> {
                    List<Symptom> symptomsEdited = person.getSymptoms();
                    symptomsEdited.add(symptom);
                    person.setSymptoms(symptomsEdited);
                });
    }

    public List<Person> findRiskPersons(){
        return personList.stream().filter(
                p -> (p.getEdad() >= 60) && !p.getSymptoms().isEmpty())
                .toList();
    }
}

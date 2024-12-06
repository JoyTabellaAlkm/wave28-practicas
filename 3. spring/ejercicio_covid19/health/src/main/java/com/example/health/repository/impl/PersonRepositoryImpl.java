package com.example.health.repository.impl;

import com.example.health.entity.Person;
import com.example.health.entity.Symptom;
import com.example.health.repository.IPersonRepository;
import com.example.health.repository.ISymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements IPersonRepository {
    private List<Symptom> symptoms;

    @Autowired
    public PersonRepositoryImpl(ISymptomRepository symptomRepository) {
        this.symptoms = symptomRepository.getSymptoms();
    }

    @Override
    public List<Person> getPersons() {
        return new ArrayList<>(List.of(
                new Person(1, "Pepito", "Perez", 10),
                new Person(1, "L", "Gante", 24,
                        new ArrayList<>(List.of(symptoms.get(2).getCode()))),
                new Person(1, "Pedro", "Picapiedra", 30,
                        new ArrayList<>(List.of(symptoms.getFirst().getCode()))),
                new Person(1, "Cosme", "Fulanito", 40),
                new Person(1, "Pepe", "Campos", 70,
                        new ArrayList<>(List.of(symptoms.getFirst().getCode(),
                                symptoms.get(2).getCode()))),
                new Person(1, "Wanda", "Nara", 65,
                        new ArrayList<>(List.of(symptoms.get(3).getCode()))),
                new Person(1, "Neira", "Enrique", 68,
                        new ArrayList<>(List.of(symptoms.get(4).getCode())))
        ));
    }
}

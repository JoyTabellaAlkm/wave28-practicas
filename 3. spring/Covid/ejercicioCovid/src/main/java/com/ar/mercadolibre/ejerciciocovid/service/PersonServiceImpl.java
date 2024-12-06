package com.ar.mercadolibre.ejerciciocovid.service;

import com.ar.mercadolibre.ejerciciocovid.DTO.PatientDTO;
import com.ar.mercadolibre.ejerciciocovid.DTO.SymptomDTO;
import com.ar.mercadolibre.ejerciciocovid.model.Person;
import com.ar.mercadolibre.ejerciciocovid.model.SeverityLevel;
import com.ar.mercadolibre.ejerciciocovid.model.Symptom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonServiceImpl implements IPersonService{

    private final List<Person> persons;
    private final List<Symptom> symptoms;

    public PersonServiceImpl() {
        persons = new ArrayList<>();
        persons.add(new Person(1, "John", "Doe", 65));
        persons.add(new Person(2, "Jane", "Smith", 70));
        persons.add(new Person(1, "Mark", "Johnson", 45));
        persons.add(new Person(1, "Emily", "Davis", 30));

        symptoms = new ArrayList<>();
        symptoms.add(new Symptom(1, "Headache", SeverityLevel.MILD));
        symptoms.add(new Symptom(2, "Fever", SeverityLevel.MODERATE));
        symptoms.add(new Symptom(3, "Shortness of Breath", SeverityLevel.SEVERE));
        symptoms.add(new Symptom(4, "Chest Pain", SeverityLevel.CRITICAL));
    }

    @Override
    public List<PatientDTO> findRiskPeople() {
        AtomicInteger cont = new AtomicInteger();
        List<PatientDTO> patients = persons.stream().map(patient -> {
            List<SymptomDTO> symptoms1 = new ArrayList<>();
            symptoms1.add(new SymptomDTO(symptoms.get(cont.get()).getCode(), symptoms.get(cont.get()).getName(), symptoms.get(cont.get()).getSeverityLevel()));
            cont.getAndIncrement();
            return new PatientDTO(patient.getId(), patient.getName(), patient.getSurname(), patient.getAge(), symptoms1);
        }).toList();

        return patients.stream().filter(patient -> patient.getAge() > 60).toList();
    }
}

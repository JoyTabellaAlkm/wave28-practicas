package com.bootcamp.ejercicio_covid.repository.impl;

import com.bootcamp.ejercicio_covid.entity.Person;
import com.bootcamp.ejercicio_covid.entity.Symptom;
import com.bootcamp.ejercicio_covid.repository.IPersonRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonRepository {

    private List<Person> personList = List.of(
            new Person(1L, "Joven", "Normal", 25, List.of(
                    new Symptom(2L, "Dolor de cabesa", "Normnal")
            )),
            new Person(2L, "Grande", "Normal", 55, List.of(
                    new Symptom(1L, "Fiebre", "Media"),
                    new Symptom(2L, "Dolor de cabesa", "Normnal")
                    )),
            new Person(3L, "Viejo", "Sano", 63, List.of()),
            new Person(4L, "Viejo", "Enferemo", 65, List.of(
                    new Symptom(1L, "Fiebre", "Media"),
                    new Symptom(2L, "Dolor de cabesa", "Normnal"),
                    new Symptom(3L, "Tos con sangre", "Alta")
            ))
    );


    @Override
    public List<Person> findRiskPerson() {

        return personList.stream().filter(p -> p.getAge() > 60 && p.getSyptoms().size() > 0).toList();
    }
}

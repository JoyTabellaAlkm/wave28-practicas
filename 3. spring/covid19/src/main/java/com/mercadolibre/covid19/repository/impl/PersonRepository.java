package com.mercadolibre.covid19.repository.impl;

import com.mercadolibre.covid19.model.Person;
import com.mercadolibre.covid19.repository.ICrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepository implements ICrudRepository<Person> {

    private final List<Person> people = new ArrayList<>();

    @Override
    public Person save(Person person) {
        people.add(person);
        return person;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return people.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Person> findAll() {
        return people;
    }

    @Override
    public String delete(Long id) {
        Optional<Person> person = findById(id);
        if (person.isPresent()){
            people.remove(person.get());
            return "Se eliminó la persona con id " + id;
        } else {
            return "La persona con id " + id + " no está registrada";
        }
    }
}

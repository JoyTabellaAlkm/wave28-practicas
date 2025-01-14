package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.model.Person;

import java.util.List;

public interface IPersonService {
    Person save(Person person);

    List<Person> findAll();

    Person findById(Long id);

    Person update(Person person, Long id);

    void delete(Long id);
}

package com.bootcamp.ejercicio_covid.repository;

import com.bootcamp.ejercicio_covid.entity.Person;
import java.util.List;

public interface IPersonRepository {
    public List<Person> findRiskPerson();
}

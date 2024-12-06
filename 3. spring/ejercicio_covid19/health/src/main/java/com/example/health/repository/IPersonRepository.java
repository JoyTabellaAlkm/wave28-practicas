package com.example.health.repository;

import com.example.health.entity.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> getPersons();
}

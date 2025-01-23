package com.deportistas.repository;

import com.deportistas.model.Person;

import java.util.List;

public interface IPersonRepository {
    public List<Person> findAll();
}

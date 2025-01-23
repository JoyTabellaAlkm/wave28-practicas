package com.deportistas.repository.impl;

import com.deportistas.model.Person;
import com.deportistas.model.Sport;
import com.deportistas.repository.IPersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository  implements IPersonRepository {
    private List<Person> entities = new ArrayList<>(List.of(
            new Person(1,"Mailen","Perez",20, new Sport(1,"basket","medio")),
            new Person(2, "Maite", "Castillo", 35, new Sport(2, "futbol", "alto")),
            new Person(3, "Martina", "Gomez", 19, new Sport(3, "snowboard", "alto")),
            new Person(4, "Elena", "Garcia", 31, new Sport(4, "natacion", "bajo"))
    ));

    public List<Person> findAll() {
        return entities;
    }
}

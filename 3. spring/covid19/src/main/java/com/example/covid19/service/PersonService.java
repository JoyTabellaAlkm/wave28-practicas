package com.example.covid19.service;

import com.example.covid19.domain.Person;
import com.example.covid19.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> retrieveRiskPersons(){
        return personRepository.findRiskPersons();
    }

}

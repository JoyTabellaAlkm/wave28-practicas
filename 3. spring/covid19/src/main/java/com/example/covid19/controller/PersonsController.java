package com.example.covid19.controller;

import com.example.covid19.domain.Person;
import com.example.covid19.dto.PersonDTO;
import com.example.covid19.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsController {
    @Autowired
    PersonService personService;

    @GetMapping("/riskPersons")
    public List<PersonDTO> getRiskPersons(){
        List<Person> personList = personService.retrieveRiskPersons();

        return personList.stream().map(p -> new PersonDTO(p.getNombre(), p.getApellido())).toList();
    }
}

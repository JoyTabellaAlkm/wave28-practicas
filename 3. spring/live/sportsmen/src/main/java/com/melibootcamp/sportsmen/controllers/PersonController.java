package com.melibootcamp.sportsmen.controllers;


import com.melibootcamp.sportsmen.dtos.PersonDto;
import com.melibootcamp.sportsmen.services.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sports")
public class PersonController {

    private PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personServiceImpl){
        this.personService = personServiceImpl;
    }

    @GetMapping
    public ResponseEntity<?> getPersons(){
        return new ResponseEntity<>(personService.getPeople(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(
            @PathVariable long id)
    {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> savePerson(
            @RequestBody PersonDto person)
    {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(
            @PathVariable long id)
    {
        return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(
            @RequestBody PersonDto person, @PathVariable long id)
    {
        return new ResponseEntity<>(personService.updatePerson(id, person), HttpStatus.OK);
    }

}

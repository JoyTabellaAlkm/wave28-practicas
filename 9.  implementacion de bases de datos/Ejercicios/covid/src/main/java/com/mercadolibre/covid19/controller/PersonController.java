package com.mercadolibre.covid19.controller;

import com.mercadolibre.covid19.model.Person;
import com.mercadolibre.covid19.service.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@RequestBody Person person, @PathVariable Long id) {
        return new ResponseEntity<>(personService.update(person, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

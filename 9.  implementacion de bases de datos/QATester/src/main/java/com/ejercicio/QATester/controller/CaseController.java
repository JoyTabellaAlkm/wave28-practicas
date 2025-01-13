package com.ejercicio.QATester.controller;

import com.ejercicio.QATester.entity.TestCase;
import com.ejercicio.QATester.service.iCaseService;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CaseController {

    @Autowired
    private iCaseService caseServ;

    @GetMapping("/findAll")
    public ResponseEntity<List<TestCase>> get() {
        return new ResponseEntity<>(caseServ.getAllTestCase(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TestCase> get(@PathVariable Long id) {
        return new ResponseEntity<>(caseServ.getById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<TestCase> post(@RequestBody TestCase tc) {
        return new ResponseEntity<>(caseServ.saveTestCase(tc), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public TestCase post(@PathVariable Long id, @RequestBody TestCase tc) {
        return caseServ.updateTestCase(tc, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return caseServ.deleteTestCase(id);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestCase>> filterLastUpdate(@RequestParam LocalDate last_update){
        return new ResponseEntity<>(caseServ.findByDate(last_update), HttpStatus.OK);
    };
}

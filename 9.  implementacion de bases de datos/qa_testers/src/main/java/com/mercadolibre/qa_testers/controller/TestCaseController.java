package com.mercadolibre.qa_testers.controller;

import com.mercadolibre.qa_testers.dto.NewTestCaseDTO;
import com.mercadolibre.qa_testers.dto.TestCaseDTO;
import com.mercadolibre.qa_testers.service.ITestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCase testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody NewTestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.save(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam("last_update") LocalDate date){
        if (date != null) {
            return new ResponseEntity<>(testCaseService.filter(date), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(testCaseService.getAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        return new ResponseEntity<>(testCaseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable long id, TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.edit(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return new ResponseEntity<>(testCaseService.delete(id), HttpStatus.OK);
    }

    //@GetMapping
    //public ResponseEntity<?> filter(@RequestParam LocalDate date){
    //    return new ResponseEntity<>(testCaseService.filter(date), HttpStatus.OK);
    //}
}

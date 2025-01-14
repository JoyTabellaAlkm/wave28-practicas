package com.example.testcasesapi.controller;

import com.example.testcasesapi.dto.request.RequestTestCaseDto;
import com.example.testcasesapi.service.ITestCaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {
    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("new")
    public ResponseEntity<?> create(@Valid @RequestBody RequestTestCaseDto requestTestCaseDto){
        return new ResponseEntity<>(testCaseService.create(requestTestCaseDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> index(){
        return new ResponseEntity<>(testCaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.show(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody RequestTestCaseDto requestTestCaseDto){
        return new ResponseEntity<>(testCaseService.update(id, requestTestCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.delete(id), HttpStatus.OK);
    }

    @GetMapping("filter")
    public ResponseEntity<?> indexByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastUpdate){
        return new ResponseEntity<>(testCaseService.getAllByDate(lastUpdate), HttpStatus.OK);
    }
}

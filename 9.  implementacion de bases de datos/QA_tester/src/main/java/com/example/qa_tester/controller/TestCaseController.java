package com.example.qa_tester.controller;

import com.example.qa_tester.dto.TestCaseDto;
import com.example.qa_tester.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase (@RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(testCaseService.create(testCaseDto),HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(testCaseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(testCaseService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestById(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto){
        return ResponseEntity.ok().body(testCaseService.update(id,testCaseDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.delete(id),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/filter")
    public ResponseEntity<?> getTestByLastUpdate(@RequestParam LocalDate date){
        return ResponseEntity.ok().body(testCaseService.getTestsByLastUpdate(date));
    }
}

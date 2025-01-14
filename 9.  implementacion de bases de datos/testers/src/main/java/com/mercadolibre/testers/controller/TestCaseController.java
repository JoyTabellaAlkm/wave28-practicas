package com.mercadolibre.testers.controller;

import com.mercadolibre.testers.dto.CreateTestCaseDTO;
import com.mercadolibre.testers.dto.TestCaseDTO;
import com.mercadolibre.testers.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createCaseTest(@RequestBody CreateTestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.createCaseTest(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> findAllCase(){
        return new ResponseEntity<>(testCaseService.findAllCase(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.findCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCase(@PathVariable Long id, @RequestBody CreateTestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.updateCase(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteCase(id), HttpStatus.NO_CONTENT);
    }
}

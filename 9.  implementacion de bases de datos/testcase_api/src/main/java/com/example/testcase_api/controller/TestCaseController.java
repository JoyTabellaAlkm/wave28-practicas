package com.example.testcase_api.controller;

import com.example.testcase_api.dto.TestCaseDTO;
import com.example.testcase_api.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return ResponseEntity.ok().body("TestCase with id '"+ testCaseService.createTestCase(testCaseDTO) +"' was created successfully.");
    }
    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getTestCases(){
        return ResponseEntity.ok().body(testCaseService.getTestCase());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> findTestCaseById(@PathVariable Long id){
        return ResponseEntity.ok().body(testCaseService.findTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        return ResponseEntity.ok().body("TestCase with id '"+ testCaseService.updateTestCase(id,testCaseDTO) +"' was updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id){
        return ResponseEntity.ok().body("TestCase with id '"+ testCaseService.deleteTestCase(id) +"' was deleted successfully.");
    }

    @GetMapping("/last_update")
    public ResponseEntity<List<TestCaseDTO>> findTestCaseByLastUpdate(@RequestParam("date") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate){
        return ResponseEntity.ok().body(testCaseService.findTestCaseByLastUpdate(lastUpdate));
    }

}

package com.testcase.controller;

import com.testcase.DTO.TestCaseDto;
import com.testcase.DTO.responses.TestCaseDtoRes;
import com.testcase.service.TestCaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/testcases/")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @PostMapping("new/")
    public ResponseEntity<TestCaseDtoRes> createTestCase(@RequestBody @Valid TestCaseDto testCase){
        return ResponseEntity.ok(testCaseService.createTestCase(testCase));
    }

    @PutMapping("{id}/")
    public  ResponseEntity<TestCaseDtoRes> updateTestCase(@PathVariable Long id, @RequestBody @Valid TestCaseDto testCase){
        return ResponseEntity.ok(testCaseService.updateTestCase(id, testCase));
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        testCaseService.deleteTestCase(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCaseDtoRes>> getAllTestsCases(@RequestParam(required = false) LocalDate last_update){
        return ResponseEntity.ok(testCaseService.getAllTestCase(last_update));
    }

    @GetMapping("{id}/")
    public ResponseEntity<TestCaseDtoRes> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.getTestCaseById(id));
    }
}

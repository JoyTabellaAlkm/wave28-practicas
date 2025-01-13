package com.melibootcamp.qatesters.controller;

import com.melibootcamp.qatesters.entity.TestCase;
import com.melibootcamp.qatesters.service.ITestCaseService;
import com.melibootcamp.qatesters.service.TestCaseServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private ITestCaseService testCaseService;

    public TestCaseController(TestCaseServiceImpl testCaseServiceImpl){
        this.testCaseService = testCaseServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getTestCases(){
        return new ResponseEntity<>(testCaseService.getTestCases(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveTestCase(
            @RequestBody TestCase testCase)
    {
        return new ResponseEntity<>(testCaseService.saveTestCase(testCase), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(
            @PathVariable long id)
    {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(
            @PathVariable long id)
    {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(
            @RequestBody TestCase testcase, @PathVariable long id)
    {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testcase), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getFilteredTestCases(
            @RequestParam
            @DateTimeFormat(pattern = "dd-MM-yyyy")
            LocalDate last_update
            ){
        return new ResponseEntity<>(testCaseService.getFilteredTestCases(last_update), HttpStatus.OK);
    }

    /*
    @PostMapping("/local-date")
    public void localDate(@RequestParam("localDate")
                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        // ...
    }
    */

}

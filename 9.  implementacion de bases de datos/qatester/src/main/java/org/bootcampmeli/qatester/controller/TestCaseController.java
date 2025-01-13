package org.bootcampmeli.qatester.controller;


import org.bootcampmeli.qatester.dto.TestCaseDto;
import org.bootcampmeli.qatester.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;


    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseDto testCaseDto) {
            return new ResponseEntity<>(testCaseService.createTestCase(testCaseDto), HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<?> getAllTestCases() {
        return new ResponseEntity<>(testCaseService.getAllTestCases(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDto),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id),HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getAllTestCasesSinceDate(@RequestParam String last_update) {

        return new ResponseEntity<>(testCaseService.filterByDate(last_update),HttpStatus.OK);

    }
}

package com.mercadolibre.testers.controller;

import com.mercadolibre.testers.dto.CreateTestCaseDTO;
import com.mercadolibre.testers.dto.TestCaseDTO;
import com.mercadolibre.testers.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody CreateTestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> findAllTestCases() {
        return new ResponseEntity<>(testCaseService.findAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.findTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody CreateTestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> findTestCasesAfterDate(
            @RequestParam("last_update")
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            String lastUpdateStr
    ) {
        LocalDate lastUpdate = LocalDate.parse(lastUpdateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return new ResponseEntity<>(testCaseService.findTestCasesAfterDate(lastUpdate), HttpStatus.OK);
    }
}

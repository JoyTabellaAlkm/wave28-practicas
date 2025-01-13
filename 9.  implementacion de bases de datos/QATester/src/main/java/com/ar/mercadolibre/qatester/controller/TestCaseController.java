package com.ar.mercadolibre.qatester.controller;

import com.ar.mercadolibre.qatester.dto.MessageDTO;
import com.ar.mercadolibre.qatester.dto.TestCaseDTO;
import com.ar.mercadolibre.qatester.service.ITestCaseService;
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
    public ResponseEntity<TestCaseDTO> createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getAll() {
        return new ResponseEntity<>(testCaseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TestCaseDTO> getById(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.update(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> delete(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/filters")
    public ResponseEntity<List<TestCaseDTO>> getWithFilters(@RequestParam (name = "last_update") String lastUpdate) {
        return new ResponseEntity<>(testCaseService.findAfterLastUpdate(lastUpdate), HttpStatus.OK);
    }
}

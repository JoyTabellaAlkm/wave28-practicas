package com.bootcamp.tester.controller;

import com.bootcamp.tester.dto.TestCaseCreationDto;
import com.bootcamp.tester.dto.TestCaseDto;
import com.bootcamp.tester.dto.TestCaseUpdateDto;
import com.bootcamp.tester.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @PostMapping("/new")
    ResponseEntity<TestCaseDto> createTestCase(@RequestBody TestCaseCreationDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.create(dto));
    }

    @GetMapping
    ResponseEntity<List<TestCaseDto>> getAllTestCases(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Optional<LocalDate> last_update) {
        return ResponseEntity.ok(testCaseService.getAll(last_update));
    }

    @GetMapping("/{id}")
    ResponseEntity<TestCaseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<TestCaseDto> update(@PathVariable Long id, @RequestBody TestCaseUpdateDto dto) {
        return ResponseEntity.ok().body(testCaseService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> update(@PathVariable Long id) {
        testCaseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

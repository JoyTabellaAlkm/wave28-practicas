package com.mercadolibre.qatesters.controller;

import com.mercadolibre.qatesters.dto.request.TestCaseRequestDto;
import com.mercadolibre.qatesters.dto.response.TestCaseResponseDto;
import com.mercadolibre.qatesters.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseResponseDto> save(@RequestBody TestCaseRequestDto testCaseRequestDto) {
        return new ResponseEntity<>(testCaseService.save(testCaseRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponseDto>> findAll(@RequestParam(value = "last_update", required = false) String lastUpdate) {
        return new ResponseEntity<>(testCaseService.findAll(lastUpdate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDto> update(@RequestBody TestCaseRequestDto testCaseRequestDto, @PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.update(testCaseRequestDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        testCaseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

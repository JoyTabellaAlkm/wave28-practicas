package com.mercadolibre.TestClase.controller;

import com.mercadolibre.TestClase.dto.request.TestCaseRequestDTO;
import com.mercadolibre.TestClase.dto.response.TestCaseResponseDTO;
import com.mercadolibre.TestClase.entity.TestCase;
import com.mercadolibre.TestClase.service.ITestcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestcaseController {

    @Autowired
    ITestcaseService testcaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCaseResponseDTO> createTestcase(@RequestBody TestCaseRequestDTO testcase){
        return ResponseEntity.ok(testcaseService.saveTestcase(testcase));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(testcaseService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<TestCase>> findById(){
        return ResponseEntity.ok(testcaseService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> updateTestcase(
            @PathVariable Long id,
            @RequestBody TestCaseRequestDTO testcase
    ){
        return ResponseEntity.ok(testcaseService.updateTestCase(id, testcase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestcase(@PathVariable Long id){
        return ResponseEntity.ok(testcaseService.deleteTestCase(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestCase>> findByLastUpdate(@RequestParam String last_update){
        return ResponseEntity.ok(testcaseService.findByLastUpdate(last_update));
    }

}

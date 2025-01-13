package com.bootcamp.testcase.controller;

import com.bootcamp.testcase.dto.request.CreateTestCaseDTO;
import com.bootcamp.testcase.dto.request.UpdateTestCaseDTO;
import com.bootcamp.testcase.service.TestCaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    TestCaseService testCaseService;

    @Autowired
    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    // Devolver todos los casos de prueba.
    // y buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.
    @GetMapping
    ResponseEntity<?> findAllTestCases(@RequestParam(required = false) String last_update) {
        if (last_update != null) {
            return ResponseEntity.ok(testCaseService.findAllAfterLastUpdateDate(last_update));
        }
        return ResponseEntity.ok(testCaseService.findAll());
    }

    // Crear un nuevo caso de prueba.
    @PostMapping("/new")
    ResponseEntity<?> createTestCase(@RequestBody @Valid CreateTestCaseDTO testCaseDTO) {
        return ResponseEntity.ok(testCaseService.create(testCaseDTO));
    }

    // Devolver un caso de prueba por id.
    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.findById(id));
    }

    // Actualizar un caso de prueba por id.
    @PutMapping("/{id}")
    ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody @Valid UpdateTestCaseDTO testCaseDTO) {
        return ResponseEntity.ok(testCaseService.updateById(id, testCaseDTO));
    }

    // Eliminar un tutorial por id.
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.deleteById(id));
    }
}

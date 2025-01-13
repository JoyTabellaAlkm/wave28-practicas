package com.mercadolibre.qatesters.controller;

import com.mercadolibre.qatesters.dto.MessageDto;
import com.mercadolibre.qatesters.dto.TestCaseDto;
import com.mercadolibre.qatesters.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCasesController {

    private final ITestCaseService testCaseService;

    public TestCasesController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> post(@RequestBody TestCaseDto testCaseDto) {
        testCaseService.post(testCaseDto);
        return new ResponseEntity<>(new MessageDto("Caso de prueba creado exitosamente."),
                HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDto>> getAll() {
        return ResponseEntity.ok(testCaseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testCaseService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> put(@PathVariable("id") Long id,
                                          @RequestBody TestCaseDto testCaseDto) {
        testCaseService.put(id, testCaseDto);
        return new ResponseEntity<>(new MessageDto("Caso de prueba modificado exitosamente."),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") Long id) {
        testCaseService.delete(id);
        return new ResponseEntity<>(new MessageDto("Caso de prueba eliminado exitosamente."),
                HttpStatus.NO_CONTENT);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestCaseDto>> filter(@RequestParam("last_update")LocalDate lastUpdate) {
        return ResponseEntity.ok(testCaseService.filter(lastUpdate));
    }
}

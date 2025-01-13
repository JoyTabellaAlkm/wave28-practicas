package com.testManagement.testCase.controller;

import com.testManagement.testCase.dto.request.NewTestCaseDTO;
import com.testManagement.testCase.dto.response.MessageDTO;
import com.testManagement.testCase.dto.response.TestCaseDTO;
import com.testManagement.testCase.exception.FormatException;
import com.testManagement.testCase.service.ITestCasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCasesController {
    @Autowired
    ITestCasesService testCasesService;

    @PostMapping("/new")
    public ResponseEntity<TestCaseDTO> createTestCase(@RequestBody NewTestCaseDTO newTestCaseDTO){
        return new ResponseEntity<>(testCasesService.createTestCase(newTestCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getTestCases(@RequestParam(value = "last_update", required = false) String lastUpdateParam) {
        LocalDate lastUpdate = null;


        if (lastUpdateParam != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                lastUpdateParam = lastUpdateParam.replaceAll("’", "").replaceAll("‘", "");
                System.out.println(lastUpdateParam);
                lastUpdate = LocalDate.parse(lastUpdateParam, formatter);
            } catch (DateTimeParseException e) {
                throw new FormatException("Formato de fecha inválido. Use 'dd/MM/yyyy'.");
            }
        }
        List<TestCaseDTO> testCases;

        if (lastUpdateParam == null) {
            testCases = testCasesService.getAllTestCases();
        } else {
            testCases = testCasesService.getTestCasesWithFilter(lastUpdate);
        }

        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(testCasesService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> updateTestCase(@PathVariable Long id, @RequestBody NewTestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCasesService.update(testCaseDTO,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(testCasesService.deleteById(id), HttpStatus.OK);
    }

}

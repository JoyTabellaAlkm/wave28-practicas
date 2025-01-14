package com.meli.ejerciciotestcases.controller;

import com.meli.ejerciciotestcases.dto.TestCaseDto;
import com.meli.ejerciciotestcases.model.TestCase;
import com.meli.ejerciciotestcases.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseControllerImpl implements ITestCaseController{

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    ResponseEntity<?> saveOne (@RequestBody TestCaseDto testcase){
        testCaseService.saveTestCase(testcase);
        return ResponseEntity.status(HttpStatus.OK).body(testcase);
    }

    @GetMapping("")
    ResponseEntity<List<TestCaseDto>> getAllTestCases (){
        List<TestCaseDto> testCaseList =  testCaseService.getTestCases();
        return ResponseEntity.status(HttpStatus.OK).body(testCaseList);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getOneById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.findTestCase(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateOneById (@PathVariable Long id, @RequestBody TestCaseDto testcase){
        testCaseService.updateTestCase(id, testcase);
        return ResponseEntity.status(HttpStatus.OK).body(testcase);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOneById (@PathVariable Long id){
        testCaseService.deleteTestCase(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}

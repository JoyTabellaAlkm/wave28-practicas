package com.example.qatesters.controller;

import com.example.qatesters.dto.TestCaseRequestDto;
import com.example.qatesters.dto.TestCaseResponseDto;
import com.example.qatesters.service.ITestCaseService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService){
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseResponseDto> createPost(@RequestBody TestCaseRequestDto post){
        return new ResponseEntity<>(testCaseService.createPost(post), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponseDto>> getAllPosts(@RequestParam(name = "last_update", required = false) LocalDate date){

        if(date != null){
            return new ResponseEntity<>(testCaseService.getPostsByDate(date), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(testCaseService.getAllPosts(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDto> getPostById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getPostById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TestCaseResponseDto> updatePost(@PathVariable Long id, @RequestBody TestCaseRequestDto post){
        return  new ResponseEntity<>(testCaseService.updatePost(id, post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deletePostById(id), HttpStatus.OK);
    }

}

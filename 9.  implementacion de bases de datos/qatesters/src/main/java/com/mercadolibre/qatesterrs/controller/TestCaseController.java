package com.mercadolibre.qatesterrs.controller;

import com.mercadolibre.qatesterrs.dto.CreateUpdateTestCaseRequestDto;
import com.mercadolibre.qatesterrs.service.ITestCaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

	@Autowired
	private ITestCaseService testCaseService;

	@GetMapping("")
	public ResponseEntity<?> findAll(@RequestParam(required = false, name = "last_update") String lastUpdate) {
		return ResponseEntity.ok(testCaseService.findAll(lastUpdate));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable long id) {
		return ResponseEntity.ok(testCaseService.findById(id));
	}

	@PostMapping("/new")
	public ResponseEntity<?> save(@RequestBody @Valid CreateUpdateTestCaseRequestDto request) {
		return ResponseEntity.created(null).body(testCaseService.save(request));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody @Valid CreateUpdateTestCaseRequestDto request) {
		testCaseService.update(id, request);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		testCaseService.delete(id);
		return ResponseEntity.noContent().build();
	}

}

package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@RequestBody @Valid StudentDTO rq) {
        return service.analyzeScores(rq);
    }

    @PostMapping ("/student")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO student) {
        return new ResponseEntity<>(service.addStudent(student), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/findStudent/{name}")
    public ResponseEntity<StudentDTO> findStudentByName(@PathVariable @NotBlank(message = "El nombre del estudiante no puede estar vacío.") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable @NotBlank(message = "El nombre no puede estar vacio") String name) {
        return ResponseEntity.ok(service.deleteByName(name));
    }



}

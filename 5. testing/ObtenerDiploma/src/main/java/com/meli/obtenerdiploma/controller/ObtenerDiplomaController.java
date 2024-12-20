package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ObtenerDiplomaController {
    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public ResponseEntity<?> analyzeScores(@Valid @RequestBody StudentDTO rq) {
        return ResponseEntity.ok(service.analyzeScores(rq));
    }
}

package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.Student;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @GetMapping("/analyzeScores/{studentId}")
    public Student analyzeScores(@PathVariable Long studentId) {
        return service.analyzeScores(studentId);
    }
}

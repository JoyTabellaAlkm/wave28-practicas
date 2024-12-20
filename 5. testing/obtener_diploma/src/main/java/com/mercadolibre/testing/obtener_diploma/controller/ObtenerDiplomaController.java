package com.mercadolibre.testing.obtener_diploma.controller;

import com.mercadolibre.testing.obtener_diploma.model.StudentDTO;
import com.mercadolibre.testing.obtener_diploma.service.IObtenerDiplomaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@Valid @RequestBody StudentDTO rq) {
        return service.analyzeScores(rq);
    }
}

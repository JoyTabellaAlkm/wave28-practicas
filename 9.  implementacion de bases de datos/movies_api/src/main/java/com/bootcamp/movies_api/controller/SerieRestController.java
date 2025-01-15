package com.bootcamp.movies_api.controller;

import com.bootcamp.movies_api.dto.SerieDTO;
import com.bootcamp.movies_api.model.Serie;
import com.bootcamp.movies_api.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/series")
public class SerieRestController {

    SerieService serieService;

    @Autowired
    public SerieRestController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    ResponseEntity<List<SerieDTO>> findAll() {
        return ResponseEntity.ok(serieService.findAll());
    }

    @GetMapping("/seasons/greater_than")
    ResponseEntity<List<SerieDTO>> findAllBySeasonsSizeGreaterThan(@RequestParam Integer num) {
        return ResponseEntity.ok(serieService.findAllBySeasonsSizeGreaterThan(num));
    }

}

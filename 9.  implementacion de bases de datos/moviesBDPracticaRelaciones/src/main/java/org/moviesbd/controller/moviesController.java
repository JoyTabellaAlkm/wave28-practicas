package org.moviesbd.controller;

import org.moviesbd.entity.genres;
import org.moviesbd.service.iMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class moviesController {
    @Autowired
    private iMovieService service;

    @GetMapping("/find")
    public ResponseEntity<List<genres>> get() {
        return new ResponseEntity<>(service.find(), HttpStatus.OK);
    }
}

package com.bootcamp.obras_literarias.controller;

import com.bootcamp.obras_literarias.model.Libro;
import com.bootcamp.obras_literarias.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
public class LibroRestController {

    private LibroService libroService;

    @Autowired
    public LibroRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    ResponseEntity<Iterable<Libro>> findAll() {
        return ResponseEntity.ok(libroService.findAll());
    }

    @GetMapping("/search/autor")
    ResponseEntity<List<Libro>> findByAuthorLastName(@RequestParam String last_name) {
        return ResponseEntity.ok(libroService.findByAuthorLastName(last_name));
    }

    @GetMapping("/search/title_containing")
    ResponseEntity<List<Libro>> findByTitleContaining(@RequestParam String word) {
        return ResponseEntity.ok(libroService.findByTitleContaining(word));
    }

    @GetMapping("/most_pages")
    ResponseEntity<List<Libro>> findFiveWithMostPagesOrderedDesc() {
        return ResponseEntity.ok(libroService.findFiveWithMostPagesOrderedDesc());
    }

    @GetMapping("/search/release_year_before")
    ResponseEntity<List<Libro>> findByReleaseDateBefore(@RequestParam Integer year) {
        return ResponseEntity.ok(libroService.findByYearBefore(year));
    }

    @GetMapping("/editorial/{name}")
    ResponseEntity<List<Libro>> findByEditorial(@PathVariable String name){
        return ResponseEntity.ok(libroService.findByEditorialIgnoreCase(name));
    }
}

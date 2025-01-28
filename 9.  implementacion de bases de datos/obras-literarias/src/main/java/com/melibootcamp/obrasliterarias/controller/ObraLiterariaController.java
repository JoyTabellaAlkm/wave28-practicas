package com.melibootcamp.obrasliterarias.controller;

import com.melibootcamp.obrasliterarias.entity.ObraLiteraria;
import com.melibootcamp.obrasliterarias.service.ObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/obrasLiterarias")
public class ObraLiterariaController {

    @Autowired
    private ObraLiterariaService obraLiterariaService;

    @PostMapping("/new")
    public ResponseEntity<?> save (@RequestBody ObraLiteraria artic) {
        return new ResponseEntity<>(obraLiterariaService.save(artic), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAll () {

        return new ResponseEntity<>(obraLiterariaService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    //va optional porque puede que devuelva como puede que no
    public ResponseEntity<?> findById(@PathVariable String id) {
        return new ResponseEntity<>(obraLiterariaService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteObraLiteraria (@PathVariable String id) {

        return new ResponseEntity<>(obraLiterariaService.delete(id), HttpStatus.OK);
    }

    @PutMapping ("/edit/{id}")
    public ResponseEntity<?> editObraLiteraria (@RequestBody ObraLiteraria obra, @PathVariable String id) {

        return new ResponseEntity<>(obraLiterariaService.update(obra, id), HttpStatus.OK);
    }

    //Consignas punto 2

    @GetMapping("/author/{author}")
    public ResponseEntity<?> findByAuthor (@PathVariable String author) {

        return new ResponseEntity<>(obraLiterariaService.findByAuthor(author), HttpStatus.OK);
    }


    @GetMapping("/name/{pattern}")
    public ResponseEntity<?> findByNameContaining (@PathVariable String author) {

        return new ResponseEntity<>(obraLiterariaService.findByPatternInTitle(author), HttpStatus.OK);
    }

    @GetMapping("/pages/top5")
    public ResponseEntity<?> findTop5WithMostPages () {

        return new ResponseEntity<>(obraLiterariaService.findTop5BooksWithMostPagesAscOrder(), HttpStatus.OK);
    }

    @GetMapping("/publish-year/{year}")
    public ResponseEntity<?> findBooksPriorToYear (@PathVariable Integer year) {

        return new ResponseEntity<>(obraLiterariaService.findBooksSoldPriorToSentYear(year), HttpStatus.OK);
    }

    @GetMapping("/editor/{editor}")
    public ResponseEntity<?> findBooksByEditorial (@PathVariable String editor) {

        return new ResponseEntity<>(obraLiterariaService.findByEditorial(editor), HttpStatus.OK);
    }



}

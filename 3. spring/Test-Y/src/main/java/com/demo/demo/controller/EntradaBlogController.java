package com.demo.demo.controller;

import com.demo.demo.dto.EntradaBlogDTO;
import com.demo.demo.service.EntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntradaBlogController {

    @Autowired
    EntradaBlogService blogService;

    @PostMapping("/blogs")
    public ResponseEntity<Integer> crearEntradaBlog(@RequestBody EntradaBlogDTO blog) {
        int id = blogService.crearEntradaBlog(blog);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

}

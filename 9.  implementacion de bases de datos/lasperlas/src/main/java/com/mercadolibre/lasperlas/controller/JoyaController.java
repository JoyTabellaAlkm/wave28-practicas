package com.mercadolibre.lasperlas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.lasperlas.dto.request.CreateJoyaDtoRequest;
import com.mercadolibre.lasperlas.service.IJoyaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/joya")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(joyaService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CreateJoyaDtoRequest joya) {
        return ResponseEntity.created(null).body(joyaService.save(joya));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        joyaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

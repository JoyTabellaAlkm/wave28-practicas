package com.mercadolibre.concesionariodeautos.controller;

import com.mercadolibre.concesionariodeautos.dto.AutoDTO;
import com.mercadolibre.concesionariodeautos.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/vehicles")
public class AutoController {

    @Autowired
    IAutoService autoService;

    @PostMapping("")
    public ResponseEntity<?> createAuto(@RequestBody AutoDTO auto) {
        try {
            return ResponseEntity.ok(autoService.create(auto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> readAll() {
        try {
            return ResponseEntity.ok(autoService.readAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //v1/api/vehicles/dates?since=’’to=’’
    @GetMapping("/dates")
    public ResponseEntity<?> readByDate(@RequestParam Integer since, @RequestParam Integer to) {
        try {
            return ResponseEntity.ok(autoService.readByDate(since, to));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(autoService.readById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

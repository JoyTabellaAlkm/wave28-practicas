package org.example.lasperlasjoyeria.controller;

import org.example.lasperlasjoyeria.model.Joya;
import org.example.lasperlasjoyeria.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    JoyaService joyaService;


    @GetMapping("jewelry")
    ResponseEntity<List<Joya>> addJoya() {
        return new ResponseEntity<>(joyaService.getAllJoyas(), HttpStatus.OK);
    }

    @PostMapping("jewelry/new")
    ResponseEntity<Long> addJoya(@RequestBody Joya newJoya) {
        return new ResponseEntity<>(joyaService.addJoya(newJoya), HttpStatus.CREATED);
    }

    @PutMapping("/jewerly/delete/{id}")
    ResponseEntity<Joya> addJoya(@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.deleteJoyaById(id), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    ResponseEntity<Joya> addJoya(@PathVariable Long id_modificar, @RequestBody Joya joya) {
        return new ResponseEntity<>(joyaService.updateJoya(id_modificar, joya), HttpStatus.OK);
    }


}

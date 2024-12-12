package com.bootcamp.ejerciciojoyeria.controller;

import com.bootcamp.ejerciciojoyeria.dto.JoyaDto;
import com.bootcamp.ejerciciojoyeria.service.IJoyaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jewelry")
public class JoyaController {
    @Autowired
    IJoyaService joyaService;

    @PostMapping("new")
    public ResponseEntity<?> createJewel(@RequestBody JoyaDto joyaDto) {
        return new ResponseEntity<>(joyaService.createJewel(joyaDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllJewels() {
        return new ResponseEntity<>(joyaService.getAllJewels(), HttpStatus.OK);
    }
}

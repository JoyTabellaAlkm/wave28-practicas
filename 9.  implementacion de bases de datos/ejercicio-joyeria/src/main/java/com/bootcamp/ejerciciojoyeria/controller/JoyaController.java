package com.bootcamp.ejerciciojoyeria.controller;

import com.bootcamp.ejerciciojoyeria.dto.RequestJoyaDto;
import com.bootcamp.ejerciciojoyeria.dto.ResponseDto;
import com.bootcamp.ejerciciojoyeria.dto.ResponseJoyaDto;
import com.bootcamp.ejerciciojoyeria.dto.UpdateJoyaDto;
import com.bootcamp.ejerciciojoyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jewelry")
public class JoyaController {
    @Autowired
    IJoyaService joyaService;

    @PostMapping("new")
    public ResponseEntity<?> createJewel(@RequestBody RequestJoyaDto requestJoyaDto) {
        return new ResponseEntity<>(joyaService.createJewel(requestJoyaDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllJewels() {
        List<ResponseJoyaDto> joyas = joyaService.getAllJewels();
        return new ResponseEntity<>(joyas, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteJewelById(@PathVariable Long id) {
        joyaService.deleteJewel(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateJewelById(@PathVariable Long id, @RequestBody UpdateJoyaDto updateJoyaDto) {
        return new ResponseEntity<>(joyaService.updateJewel(id, updateJoyaDto), HttpStatus.OK);
    }
}

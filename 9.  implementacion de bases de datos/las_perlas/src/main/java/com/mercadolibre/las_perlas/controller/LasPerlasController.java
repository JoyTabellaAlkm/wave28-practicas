package com.mercadolibre.las_perlas.controller;

import com.mercadolibre.las_perlas.dto.JoyaDTO;
import com.mercadolibre.las_perlas.service.ILasPerlasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jewerly")
public class LasPerlasController {

    @Autowired
    private ILasPerlasService lasPerlasService;

    @GetMapping()
    public ResponseEntity<List<JoyaDTO>> findAll() {
        return new ResponseEntity<>(lasPerlasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyaDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(lasPerlasService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<JoyaDTO> create(@RequestBody @Valid JoyaDTO joyaDTO) {
        return new ResponseEntity<>(lasPerlasService.create(joyaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaDTO> update(@PathVariable Long id ,@RequestBody @Valid JoyaDTO joyaDTO) {
        return new ResponseEntity<>(lasPerlasService.update(id, joyaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JoyaDTO> delete(@PathVariable Long id) {
        return new ResponseEntity<>(lasPerlasService.delete(id), HttpStatus.OK);
    }
}

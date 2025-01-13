package com.joyeria.controller;

import com.joyeria.dto.JoyaDTO;
import com.joyeria.service.IJoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyeriaController {

    @Autowired
    IJoyeriaService joyeriaService;

    @PostMapping("/new")
    public ResponseEntity<JoyaDTO> createJoya(@RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity<JoyaDTO>(joyeriaService.createJoya(joyaDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaDTO>> getAllJoya() {
        return new ResponseEntity<List<JoyaDTO>>(joyeriaService.findAllJoyas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyaDTO> getJoyaById(@PathVariable int id) {
        return new ResponseEntity<JoyaDTO>(joyeriaService.findJoyaById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaDTO> updateJoya(@PathVariable int id, @RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity<JoyaDTO>(joyeriaService.updateJoya(id, joyaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable int id) {
        return new ResponseEntity<String>(joyeriaService.deleteJoya(id), HttpStatus.OK);
    }
}

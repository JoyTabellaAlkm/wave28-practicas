package com.melibootcamp.lasperlas.controller;

import com.melibootcamp.lasperlas.entity.Joya;
import com.melibootcamp.lasperlas.service.IJoyaService;
import com.melibootcamp.lasperlas.service.JoyaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/joyas")
public class JoyaController {

    private IJoyaService joyaService;

    public JoyaController(JoyaServiceImpl joyaServiceImpl){
        this.joyaService = joyaServiceImpl;
    }

    @GetMapping
    public ResponseEntity<?> getJoyas(){
        return new ResponseEntity<>(joyaService.getJoyas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveJoya(
            @RequestBody Joya joya)
    {
        return new ResponseEntity<>(joyaService.saveJoya(joya), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJoya(
            @PathVariable long id)
    {
        return new ResponseEntity<>(joyaService.deleteJoya(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJoyaById(
            @PathVariable long id)
    {
        return new ResponseEntity<>(joyaService.getJoyaById(id), HttpStatus.OK);
    }



}

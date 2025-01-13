package com.mercadolibre.joyerialasperlas.controller;

import com.mercadolibre.joyerialasperlas.entity.Joya;
import com.mercadolibre.joyerialasperlas.repository.IJoyaRespository;
import com.mercadolibre.joyerialasperlas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoyaController {

    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @GetMapping("/jewerly")
    public ResponseEntity<?> getJewerly(){
        return new ResponseEntity<>(joyaService.getAllJoyas(), HttpStatus.OK);
    }

    @GetMapping("/jewerly/{id}")
    public ResponseEntity<?> getJewerlyById(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.getJoyaById(id), HttpStatus.OK);
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createJewerly(@RequestBody Joya joya){
        return new ResponseEntity<>(joyaService.createJoya(joya), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable Long id){
        joyaService.deleteJoya(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/jewerly/update/{id}")
    public ResponseEntity<?> updateJewerly(@PathVariable Long id, @RequestBody Joya joya){
        return new ResponseEntity<>(joyaService.updateJoya(id, joya), HttpStatus.OK);
    }
}

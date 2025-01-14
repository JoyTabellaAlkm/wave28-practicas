package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.service.IJoyaService;
import com.example.joyerialasperlas.service.JoyaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/joyas")
public class JoyaControlller {
    @Autowired
    JoyaServiceImpl joyaService;
    @GetMapping
    public ResponseEntity<?> getJoyas(){
        return new ResponseEntity<>(joyaService.getJoyas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJoya(@PathVariable long id){
        return new ResponseEntity<>(joyaService.findJoya(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postJoya(@RequestBody JoyaDto joyaDto){
        return new ResponseEntity<>(joyaService.saveJoya(joyaDto), HttpStatus.CREATED);
    }

    @PutMapping("delete/{id}")
    public ResponseEntity<?> logicDeleteJoya(@PathVariable long id){
        return new ResponseEntity<>(joyaService.logicDeleteJoya(id), HttpStatus.NO_CONTENT);
    }
}

package com.bootcamp.joyerialasperlas.controller;

import com.bootcamp.joyerialasperlas.dto.request.CreateJoyaDTO;
import com.bootcamp.joyerialasperlas.dto.response.JoyaDTO;
import com.bootcamp.joyerialasperlas.dto.response.ResponseDTO;
import com.bootcamp.joyerialasperlas.model.Joya;
import com.bootcamp.joyerialasperlas.service.IJoyeriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyeriaController {
    private final IJoyeriaService joyeriaService;

    public JoyeriaController(IJoyeriaService joyeriaService) {
        this.joyeriaService = joyeriaService;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> agregarJoya(@RequestBody CreateJoyaDTO createJoyaDTO) {
        return new ResponseEntity<>(joyeriaService.agregarJoya(createJoyaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<JoyaDTO>> obtenerJoyas() {
        return new ResponseEntity<>(joyeriaService.obtenerJoyas(), HttpStatus.OK);
    }
}
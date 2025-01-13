package com.example.JoyeriaLasPerlas.controller;

import com.example.JoyeriaLasPerlas.dtos.JoyaDto;
import com.example.JoyeriaLasPerlas.dtos.RespuestaDto;
import com.example.JoyeriaLasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService iJoyaService;

    @PostMapping("/new")
    public ResponseEntity<RespuestaDto> agregarJoya(@RequestBody JoyaDto joyaDto){
        return new ResponseEntity<>(iJoyaService.agregarJoya(joyaDto), HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<RespuestaDto> actualizarJoya(@PathVariable Integer id_modificar, @RequestBody JoyaDto joyaDto){
        return new ResponseEntity<>(iJoyaService.actualizarJoya(id_modificar, joyaDto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<JoyaDto>> listaJoyas(){
        return new ResponseEntity<>(iJoyaService.listarJoyas(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RespuestaDto> eliminarJoya(@PathVariable Integer id){
        return new ResponseEntity<>(iJoyaService.eliminarJoya(id), HttpStatus.NO_CONTENT);
    }
}

package com.mercadolibre.joyeria.controller;

import com.mercadolibre.joyeria.dto.JoyaDto;
import com.mercadolibre.joyeria.model.Joya;
import com.mercadolibre.joyeria.service.IJoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyeriaController {
    @Autowired
    IJoyeriaService joyeriaService;

    @GetMapping("/jewerly")
    public ResponseEntity<List<JoyaDto>> obtenerJoyas(){
        return new ResponseEntity<>(joyeriaService.obtenerJoyas(), HttpStatus.OK);
    }
    @GetMapping("/jewerly/{id}")
    public ResponseEntity<JoyaDto> obtenerJoya(@PathVariable Long id){
        return new ResponseEntity<>(joyeriaService.buscarJoya(id),HttpStatus.OK);
    }
    @PostMapping("/jewerly/new")
    public ResponseEntity<String> crearJoya(@RequestBody JoyaDto joyaDto){
        return new ResponseEntity<>("Su numero identificador es: "
                + joyeriaService.guardaJoya(joyaDto),HttpStatus.CREATED);
    }
    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<String> eliminarJoya(@PathVariable Long id){
        joyeriaService.eliminarJoya(id);
        return new ResponseEntity<>("Se elimino correctamente",HttpStatus.NO_CONTENT);
    }
    @PostMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<JoyaDto> modificarJoya(@PathVariable Long id_modificar, @RequestBody JoyaDto joyaDto){
        return new ResponseEntity<>(joyeriaService.actualizarJoya(id_modificar,joyaDto),HttpStatus.OK);
    }
}

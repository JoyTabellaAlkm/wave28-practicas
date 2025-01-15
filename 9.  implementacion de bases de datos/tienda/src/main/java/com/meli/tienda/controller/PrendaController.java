package com.meli.tienda.controller;

import com.meli.tienda.dto.MessageDto;
import com.meli.tienda.dto.PrendaDto;
import com.meli.tienda.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    @Autowired
    IPrendaService prendaService;

    @PostMapping("")
    ResponseEntity<PrendaDto> crearNuevaPrenda(@RequestBody PrendaDto prendaDto){
        return ResponseEntity.ok(prendaService.crearNuevaPrenda(prendaDto));
    }

    @GetMapping
    ResponseEntity<List<PrendaDto>> traerTodos(){
        return ResponseEntity.ok(prendaService.traerTodasPrendas());
    }

    @GetMapping("/{code}")
    ResponseEntity<PrendaDto> traerPrendaPorId(@PathVariable Long code){
        return ResponseEntity.ok(prendaService.traerPrendaPorId(code));
    }

    @PutMapping("/{code}")
    ResponseEntity<PrendaDto> actualizarPorId(@RequestBody PrendaDto prendaDto, @PathVariable Long code){
        return ResponseEntity.ok(prendaService.actualizarPorId(code, prendaDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<MessageDto> eliminarPorId(@PathVariable Long id){
        return ResponseEntity.ok(prendaService.eliminarPorId(id));
    }

    @GetMapping("/talle/{size}")
    ResponseEntity<List<PrendaDto>> traerPrendaPorTalle(@PathVariable int size){
        return ResponseEntity.ok(prendaService.traerPrendaPorTalle(size));
    }

    @GetMapping("/filtro")
    ResponseEntity<List<PrendaDto>> traerprendasPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(prendaService.traerPrendasPorNombre(nombre));
    }
}

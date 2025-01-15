package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.PrendaDto;
import com.mercadolibre.showroom.service.IPrendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    private final IPrendaService prendaService;

    public PrendaController(IPrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @PostMapping("")
    public ResponseEntity<String> crearNuevaPrenda(@RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>("Se creo la prenda con el id: "+ prendaService.crearNuevaPrenda(prendaDto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<PrendaDto>> obtenerPrendas(){
        return ResponseEntity.ok(prendaService.obtenerPrendas());
    }

    @GetMapping("/{code}")
    public ResponseEntity<PrendaDto> obtenerPrenda(@PathVariable Integer code){
        return ResponseEntity.ok(prendaService.obtenerPrenda(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<PrendaDto> actualizarPrenda(@PathVariable Integer code,
                                                      @RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>(prendaService.actualizarPrenda(code,prendaDto),HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> eliminarPrenda(@PathVariable Integer code){
        prendaService.eliminarPrenda(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<PrendaDto>> obtenerPrendasXTalle(@PathVariable String size){
        return ResponseEntity.ok(prendaService.buscarPrendasXTalle(size));
    }

    @GetMapping("/name")
    public ResponseEntity<List<PrendaDto>> obtenerPrendasXNombre(@RequestParam String name){
        return ResponseEntity.ok(prendaService.buscarPrendasXNombre(name));
    }
}

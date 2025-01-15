package com.ar.mercadolibre.obrasliterarias.controller;

import com.ar.mercadolibre.obrasliterarias.dto.ObraLiterariaDTO;
import com.ar.mercadolibre.obrasliterarias.service.IObraLiterariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obra_literaria")
public class ObraLiterariaController {

    private final IObraLiterariaService obraLiterariaService;

    public ObraLiterariaController(IObraLiterariaService obraLiterariaService) {
        this.obraLiterariaService = obraLiterariaService;
    }

    @PostMapping("/nueva")
    public ResponseEntity<ObraLiterariaDTO> crearObra(@RequestBody ObraLiterariaDTO obraLiterariaDTO) {
        return new ResponseEntity<>(obraLiterariaService.create(obraLiterariaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ObraLiterariaDTO>> encontrarTodasLasObras() {
        return new ResponseEntity<>(obraLiterariaService.encontrarTodasLasObras(), HttpStatus.OK);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaDTO>> encontrarPorNombreDeAutor(@PathVariable String autor) {
        return new ResponseEntity<>(obraLiterariaService.encontrarPorAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ObraLiterariaDTO>> encontrarPorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(obraLiterariaService.encontrarPorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/cantidad_obras")
    public ResponseEntity<List<ObraLiterariaDTO>> encontrarCincoObrasConMasPaginas() {
        return new ResponseEntity<>(obraLiterariaService.encontrarCincoObrasConMasPaginas(), HttpStatus.OK);
    }

    @GetMapping("/antes_de/{anio}")
    public ResponseEntity<List<ObraLiterariaDTO>> encontrarObrasAntesDeAnio(@PathVariable Integer anio) {
        return new ResponseEntity<>(obraLiterariaService.encontrarObrasAntesDeAnio(anio), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaDTO>> encontrarObrasAntesDeAnio(@PathVariable String editorial) {
        return new ResponseEntity<>(obraLiterariaService.encontrarPorEditorial(editorial), HttpStatus.OK);
    }
}

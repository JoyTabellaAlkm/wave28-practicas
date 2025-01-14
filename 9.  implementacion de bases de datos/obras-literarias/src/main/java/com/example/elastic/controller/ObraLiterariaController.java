package com.example.elastic.controller;

import com.example.elastic.model.ObraLiteraria;
import com.example.elastic.service.ObraLiterariaService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraLiterariaController {

    private final ObraLiterariaService obraLiterariaService;

    public ObraLiterariaController(ObraLiterariaService obraLiterariaService) {
        this.obraLiterariaService = obraLiterariaService;
    }

    @GetMapping()
    public ResponseEntity<?> getObrasByAutor(@RequestParam String autor) {
        return new ResponseEntity<>(obraLiterariaService.getObrasByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/titulo")
    public ResponseEntity<?> getObrasByNombre(@RequestParam String nombre) {
        return new ResponseEntity<>(obraLiterariaService.getObrasByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/paginas")
    public ResponseEntity<?> getObrasByCantidadPaginas() {
        return new ResponseEntity<>(obraLiterariaService.getObrasByCantidadPaginas(), HttpStatus.OK);
    }

    @GetMapping("/publicacion/{year}")
    public ResponseEntity<?> getObrasByPublicacion(@PathVariable int year) {
        return new ResponseEntity<>(obraLiterariaService.getObrasByPublicacion(year), HttpStatus.OK);
    }

    @GetMapping("editorial")
    public ResponseEntity<?> getObrasByPublicacion(@RequestParam String nombre) {
        return new ResponseEntity<>(obraLiterariaService.getObrasByEditorial(nombre), HttpStatus.OK);
    }
}

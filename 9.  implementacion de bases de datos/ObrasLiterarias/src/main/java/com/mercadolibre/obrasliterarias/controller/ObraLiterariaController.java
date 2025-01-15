package com.mercadolibre.obrasliterarias.controller;

import com.mercadolibre.obrasliterarias.service.IObraLiterariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/obras")
public class ObraLiterariaController {

    private final IObraLiterariaService obraLiterariaService;

    public ObraLiterariaController(IObraLiterariaService obraLiterariaService) {
        this.obraLiterariaService = obraLiterariaService;
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> getObrasByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraLiterariaService.getObrasByAutor(autor));
    }

    @GetMapping("/titulo/{tituloKeyword}")
    public ResponseEntity<?> getObrasByTituloKeyword(@PathVariable String tituloKeyword) {
        return ResponseEntity.ok(obraLiterariaService.getObrasByTituloKeyword(tituloKeyword));
    }

    @GetMapping("/before/{anio}")
    public ResponseEntity<?> getObrasBeforeAnio(@PathVariable int anio) {
        return ResponseEntity.ok(obraLiterariaService.getObrasBeforeAnio(anio));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> getObrasByEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraLiterariaService.getObrasByEditorial(editorial));
    }

    @GetMapping("/paginas/top5")
    public ResponseEntity<?> getTop5ObrasByCantidadPaginas() {
        return ResponseEntity.ok(obraLiterariaService.getTop5ObrasByCantidadPaginas());
    }



}

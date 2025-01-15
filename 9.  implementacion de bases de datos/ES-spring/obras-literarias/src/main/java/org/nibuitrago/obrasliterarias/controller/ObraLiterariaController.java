package org.nibuitrago.obrasliterarias.controller;

import org.nibuitrago.obrasliterarias.models.ObraLiteraria;
import org.nibuitrago.obrasliterarias.repositories.ObraLiterariaRepository;
import org.nibuitrago.obrasliterarias.service.ObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObraLiterariaController {

    @Autowired
    private ObraLiterariaService obraLiterariaService;

    @PostMapping
    public ResponseEntity<ObraLiteraria> agregarObra(@RequestBody ObraLiteraria obra) {
        ObraLiteraria nuevaObra = obraLiterariaService.guardarObra(obra);
        return ResponseEntity.ok(nuevaObra);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiteraria>> agregarObra(@PathVariable String autor) {
        List<ObraLiteraria> nuevaObra = obraLiterariaService.obtenerPorAutor(autor);
        return ResponseEntity.ok(nuevaObra);
    }
}

package com.elasticsearch.obrasliterarias.controller;

import com.elasticsearch.obrasliterarias.ObraLiterariaService;
import com.elasticsearch.obrasliterarias.model.ObraLiteraria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("obras")
public class ObraLiteariaController {

    @Autowired
    ObraLiterariaService obraLiterariaService;

    @GetMapping("/porAutor/{autor}")
    ResponseEntity<List<ObraLiteraria>> findByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraLiterariaService.findByAutor(autor));
    }

    @GetMapping("/porNombre/{nombre}")
    ResponseEntity<List<ObraLiteraria>> findByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(obraLiterariaService.findByName(nombre));
    }

    @GetMapping("/topCantPaginas")
    ResponseEntity<List<ObraLiteraria>> getTop5CantPaginas() {
        return ResponseEntity.ok(obraLiterariaService.getTop5CantPaginas());
    }

    @GetMapping("/beforeAnio/{anio}")
    ResponseEntity<List<ObraLiteraria>> getBeforeAnio(@PathVariable Integer anio) {
        return ResponseEntity.ok(obraLiterariaService.getAllBefore(anio));
    }

    @GetMapping("/porEditorial/{edit}")
    ResponseEntity<List<ObraLiteraria>> findByEditorial(@PathVariable String edit) {
        return ResponseEntity.ok(obraLiterariaService.findByEditorial(edit));
    }
}

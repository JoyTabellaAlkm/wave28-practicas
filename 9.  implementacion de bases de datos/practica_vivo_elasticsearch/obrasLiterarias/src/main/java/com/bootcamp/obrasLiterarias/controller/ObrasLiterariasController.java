package com.bootcamp.obrasLiterarias.controller;

import com.bootcamp.obrasLiterarias.model.ObraLiteraria;
import com.bootcamp.obrasLiterarias.service.IObraLiterariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras-literarias")
public class ObrasLiterariasController {

    private final IObraLiterariaService obraLiterariaService;

    public ObrasLiterariasController(IObraLiterariaService obraLiterariaService) {
        this.obraLiterariaService = obraLiterariaService;
    }

    @PostMapping("/")
    public ResponseEntity<ObraLiteraria> crear(@RequestBody ObraLiteraria obra) {
        return ResponseEntity.ok(obraLiterariaService.crear(obra));
    }

    @GetMapping
    public ResponseEntity<List<ObraLiteraria>> obtenerTodas () {
        return ResponseEntity.ok(obraLiterariaService.obtenerTodas());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ObraLiteraria> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(obraLiterariaService.obtenerPorId(id));
    }

    @DeleteMapping ("/{id}")
    public String borrar (@PathVariable Long id) {
        return obraLiterariaService.borrar(id);
    }

    @PutMapping("/")
    public String actualizar (@RequestBody ObraLiteraria obra) {
        return obraLiterariaService.actualizar(obra);
    }

    @GetMapping("/incluye-nombre/{nombre}")
    ResponseEntity<List<ObraLiteraria>> nombreContenido(@PathVariable String nombre) {
        return ResponseEntity.ok(obraLiterariaService.obtenerPorNombreContenido(nombre));
    }

    @GetMapping("/top-5-paginas-desc")
    ResponseEntity<List<ObraLiteraria>> getTop5CantPaginas() {
        return ResponseEntity.ok(obraLiterariaService.obtenerTop5CantidadPaginasDesc());
    }

    @GetMapping("/antes-de/{anio}")
    ResponseEntity<List<ObraLiteraria>> antesDe(@PathVariable Integer anio) {
        return ResponseEntity.ok(obraLiterariaService.obtenerPorAnioPublicacioMenorA(anio));
    }

    @GetMapping("/editorial/{editorial}")
    ResponseEntity<List<ObraLiteraria>> porEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraLiterariaService.obtenerPorEditorial(editorial));
    }
}

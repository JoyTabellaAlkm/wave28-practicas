package com.bootcamp.showroom.controller;

import com.bootcamp.showroom.dto.PrendaDTO;
import com.bootcamp.showroom.service.IPrendaService;
import com.bootcamp.showroom.service.PrendaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prendas")
public class PrendaController {
    private IPrendaService prendaService;

    public PrendaController(PrendaServiceImpl prendaServiceImpl) {
        this.prendaService = prendaServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<List<PrendaDTO>> getPrenda() {
        return ResponseEntity.ok(prendaService.getPrendas());
    }

    @GetMapping("/codigo")
    public ResponseEntity<List<PrendaDTO>> getPrendasByCode(@RequestParam String codigo) {
        return ResponseEntity.ok(prendaService.getPrendaByCode(codigo));
    }
    @GetMapping("/talle")
    public ResponseEntity<List<PrendaDTO>> getPrendasBySize(@RequestParam String talle) {
        return ResponseEntity.ok(prendaService.getPrendaBySize(talle));
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<PrendaDTO>> getPrendasByName(@RequestParam String nombre) {
        return ResponseEntity.ok(prendaService.getPrendaByName(nombre));
    }
}

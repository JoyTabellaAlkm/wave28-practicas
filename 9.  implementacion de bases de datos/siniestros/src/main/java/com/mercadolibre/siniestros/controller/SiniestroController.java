package com.mercadolibre.siniestros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.siniestros.dto.CreateSiniestroDto;
import com.mercadolibre.siniestros.service.ISiniestroService;
import com.mercadolibre.siniestros.service.IVehiculoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {

    @Autowired
    private ISiniestroService siniestroService;

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<?> findAllSiniestros() {
        return ResponseEntity.ok(siniestroService.findAllSiniestros());
    }

    @PostMapping
    public ResponseEntity<?> saveSiniestro(@RequestBody CreateSiniestroDto request) {
        return ResponseEntity.ok(siniestroService.saveSiniestro(request));
    }

    @GetMapping("/perdida-economica/{perdidaEconomica}")
    public ResponseEntity<?> findAllPatentesMarcaModeloBySiniestroPerdidaEconomicaUp(@PathVariable double perdidaEconomica) {
        // return ResponseEntity.ok(vehiculoService.findAllPatentesMarcaModeloBySiniestroPerdidaEconomicaUp(perdidaEconomica));
        return ResponseEntity.ok(vehiculoService.findAllPatentesMarcaModeloTotalLossBySiniestroPerdidaEconomicaUp(perdidaEconomica));
    }

}

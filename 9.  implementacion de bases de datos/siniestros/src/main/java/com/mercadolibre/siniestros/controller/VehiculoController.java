package com.mercadolibre.siniestros.controller;

import com.mercadolibre.siniestros.dto.PatenteMarcaDto;
import com.mercadolibre.siniestros.dto.PatenteMarcaModeloDto;
import com.mercadolibre.siniestros.dto.VehiculoSiniestroDto;
import com.mercadolibre.siniestros.service.IVehiculoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/patente/marca")
    public ResponseEntity<List<PatenteMarcaDto>> getPatenteMarca(){
        return ResponseEntity.ok(vehiculoService.getPatenteMarca());
    }

    @GetMapping("/patente")
    public ResponseEntity<List<String>> getPatentes(){
        return ResponseEntity.ok(vehiculoService.getPatentes());
    }

    @GetMapping("/patente/cuatro_ruedas/actual")
    public ResponseEntity<List<String>> getPatentesConCuatroRuedas(){
        return ResponseEntity.ok(vehiculoService.getPatenteByCantRuedasAndAñoFabricacion());
    }

    @GetMapping("/patente/perdida")
    public ResponseEntity<List<PatenteMarcaModeloDto>> getPatentesConPerdida(){
        return ResponseEntity.ok(vehiculoService.findByPerdidaValorGreaterThan10000());
    }

    @GetMapping("/siniestro/total")
    public ResponseEntity<List<VehiculoSiniestroDto>> getVehicleBySiniestro(){
        return ResponseEntity.ok(vehiculoService.getVehicleBySiniestro());
    }
}

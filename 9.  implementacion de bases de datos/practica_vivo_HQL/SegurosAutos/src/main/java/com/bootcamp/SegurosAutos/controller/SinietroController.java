package com.bootcamp.SegurosAutos.controller;

import com.bootcamp.SegurosAutos.dto.MessageDto;
import com.bootcamp.SegurosAutos.dto.SiniestroDto;
import com.bootcamp.SegurosAutos.service.ISiniestroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestro")
public class SinietroController {

    private final ISiniestroService siniestroService;

    public SinietroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping("/{vehiculo_id}")
    public ResponseEntity<MessageDto> post(@PathVariable("vehiculo_id") Long vehiculoId,
                                           @RequestBody SiniestroDto siniestro) {
        siniestroService.post(vehiculoId, siniestro);
        return new ResponseEntity<>(new MessageDto("Siniestro creado con exito"), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<SiniestroDto>> getAll() {
        return ResponseEntity.ok(siniestroService.getAll());
    }
}

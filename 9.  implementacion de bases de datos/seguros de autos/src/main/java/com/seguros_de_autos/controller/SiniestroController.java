package com.seguros_de_autos.controller;

import com.seguros_de_autos.DTO.SiniestroDto;
import com.seguros_de_autos.DTO.SiniestroResponseDto;
import com.seguros_de_autos.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/seguros")
public class SiniestroController {
    @Autowired
    private ISiniestroService siniestroService;

    @PostMapping("/siniestros")
    private ResponseEntity<SiniestroResponseDto> createSiniestros(@RequestBody SiniestroDto siniestro){
        return ResponseEntity.ok(siniestroService.createSiniestro(siniestro));
    }
}

package com.bootcamp.ejerciciocovid19.controller;

import com.bootcamp.ejerciciocovid19.dto.SintomaDto;
import com.bootcamp.ejerciciocovid19.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sintoma")
public class SintomaRestController {
    @Autowired
    private ISintomaService sintomaService;

    @GetMapping("findSymptom")
    public ResponseEntity<List<SintomaDto>> obtenerSintomas() {
        return new ResponseEntity<>(sintomaService.obtenerSintomas(), HttpStatus.OK);
    }

    @GetMapping("findSymptom/{nombre}")
    public ResponseEntity<SintomaDto> obtenerSintomaPorNombre(@PathVariable String nombre) {
        SintomaDto sintomaObtenido = sintomaService.obtenerSintomaPorNombre(nombre);
        if (sintomaObtenido == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sintomaObtenido, HttpStatus.OK);
    }
}

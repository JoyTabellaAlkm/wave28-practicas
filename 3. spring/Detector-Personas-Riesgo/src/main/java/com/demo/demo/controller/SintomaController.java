package com.demo.demo.controller;

import com.demo.demo.entity.Sintoma;
import com.demo.demo.repository.RepositorioSintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSymptom")
public class SintomaController {

    @GetMapping("/")
    public List<Sintoma> obtenerTodosLosSintomas() {
        return new RepositorioSintoma().getAll();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Sintoma> obtenerSintomaPorNombre(@PathVariable String nombre) {
        Sintoma sintoma = new RepositorioSintoma().getSintoma(nombre);
        return new ResponseEntity<>(sintoma, HttpStatus.NOT_FOUND);
    }
}

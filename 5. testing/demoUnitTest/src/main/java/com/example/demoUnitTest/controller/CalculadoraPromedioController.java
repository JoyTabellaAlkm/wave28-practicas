package com.example.demoUnitTest.controller;

import com.example.demoUnitTest.dto.AlumnoDTO;
import com.example.demoUnitTest.service.ICalculadoraPromedioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumno")
@Validated
public class CalculadoraPromedioController {

    @Autowired
    private ICalculadoraPromedioService calculadoraPromedioService;

    //SUMAR dos numeros
    @GetMapping("/sumar/{n1}/{n2}")
    public ResponseEntity<Double> sumar(@PathVariable @Positive(message = "El valor debe ser POSITIVO" ) Double n1, @PathVariable @Positive Double n2){
        return new ResponseEntity<>(calculadoraPromedioService.sumar(n1, n2), HttpStatus.OK);
    }

    @GetMapping("/promedio/{n1}/{n2}")
    public ResponseEntity<Double> promedio(@PathVariable Double n1, @PathVariable Double n2){
        return new ResponseEntity<>(calculadoraPromedioService.promedio(n1, n2), HttpStatus.OK);
    }

    @GetMapping("/promedioDeAlumno/{id}")
    public ResponseEntity<Double> promedioDeAlumno(@PathVariable Integer id){
        Double promedio = calculadoraPromedioService.promedioDeAlumno(id);
        return new ResponseEntity<>(promedio, HttpStatus.OK);
    }

    @PostMapping("/addAlumno")
    public ResponseEntity<?> addAlumno(@RequestBody @Valid AlumnoDTO alumnoDto){
        return new ResponseEntity<>(calculadoraPromedioService.addAlumno(alumnoDto), HttpStatus.CREATED);
    }

}

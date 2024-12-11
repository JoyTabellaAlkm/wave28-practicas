package com.mercadoLibre.concesionariaAutos.controller;

import com.mercadoLibre.concesionariaAutos.dto.request.AutoDto;
import com.mercadoLibre.concesionariaAutos.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/vehicles")
public class AutoController {
    final IAutoService autoService;

    public AutoController(IAutoService autoService) {
        this.autoService = autoService;
    }

    @PostMapping
    public ResponseEntity<?> agregarAuto(@RequestBody AutoDto autoAAgregar) {
        return new ResponseEntity<>(autoService.agregarAuto(autoAAgregar), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> traerAutos() {
        return new ResponseEntity<>(autoService.traerTodosLosAutos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerPorId(@PathVariable long id) {
        return new ResponseEntity<>(autoService.traerPorId(id), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> traerPorRangoDePrecios(@RequestParam double since, @RequestParam double to) {
        return new ResponseEntity<>(autoService.traerPorRangoDePrecios(since, to), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> traerPorRangoDeFechas(@RequestParam String since, @RequestParam String to) {
        return new ResponseEntity<>(autoService.traerPorRangoDeFechas(since, to), HttpStatus.OK);
    }
}

package com.demo.demo.controller;

import com.demo.demo.dto.VentaDTO;
import com.demo.demo.service.IVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class VentaController {
    private final IVentaService service;

    public VentaController(IVentaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> showAll(@RequestParam(required = false) String date) {
        if (date != null) {
            return new ResponseEntity<>(service.findAllByDate(date), HttpStatus.OK);
        }
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody VentaDTO venta) {
        return new ResponseEntity<>(service.save(venta), HttpStatus.CREATED);
    }

}

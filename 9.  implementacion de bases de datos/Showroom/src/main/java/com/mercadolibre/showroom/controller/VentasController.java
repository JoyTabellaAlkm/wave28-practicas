package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.PrendaDTO;
import com.mercadolibre.showroom.dto.VentaCreateDTO;
import com.mercadolibre.showroom.dto.VentaDTO;
import com.mercadolibre.showroom.service.IVentaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentasController {

    private final IVentaService ventaService;

    public VentasController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    ResponseEntity<VentaDTO> crearVenta(@RequestBody VentaCreateDTO ventaDto) {
        VentaDTO venta = ventaService.create(ventaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(venta);
    }

    @GetMapping
    ResponseEntity<List<VentaDTO>> getAllVentas(
            @RequestParam(required = false) @DateTimeFormat(format="dd/MM/yyyy") LocalDate date) {
        return ResponseEntity.ok(ventaService.getAllVentas(date));
    }

    @GetMapping("/{number}")
    ResponseEntity<VentaDTO> getVentaById(@PathVariable Long number) {
        return ResponseEntity.ok(ventaService.getVentaById(number));
    }

    @PutMapping("/{number}")
    ResponseEntity<VentaDTO> actualizarVenta(@PathVariable Long number, @RequestBody VentaCreateDTO ventaDto) {
        return ResponseEntity.ok(ventaService.actualizarVenta(number, ventaDto));
    }

    @DeleteMapping("/{number}")
    ResponseEntity<Void> eliminarVenta(@PathVariable Long number) {
        ventaService.eliminarVenta(number);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/clothes/{number}")
    ResponseEntity<List<PrendaDTO>> getPrendasPorVenta(@PathVariable Long number) {
        return ResponseEntity.ok(ventaService.getPrendasPorVenta(number));
    }
}

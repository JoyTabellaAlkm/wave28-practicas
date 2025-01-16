package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.VentaDto;
import com.mercadolibre.showroom.service.IVentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createVenta(@RequestBody VentaDto venta) {
        return ResponseEntity.ok(ventaService.createVenta(venta));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getVentas() {
        return ResponseEntity.ok(ventaService.getVentas());
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<?> getVentaByNumber(@PathVariable Long number) {
        return ResponseEntity.ok(ventaService.getVentaByNumber(number));
    }

    @PutMapping("/update/{number}")
    public ResponseEntity<?> updateVenta(@PathVariable Long number, @RequestBody VentaDto venta) {
        return ResponseEntity.ok(ventaService.updateVenta(number, venta));
    }

    @DeleteMapping("/delete/{number}")
    public ResponseEntity<?> deleteVenta(@PathVariable Long number) {
        return ResponseEntity.ok(ventaService.deleteVenta(number));
    }

    @GetMapping("/date")
    public ResponseEntity<?> getVentasByDate(@RequestParam LocalDate date) {
        return ResponseEntity.ok(ventaService.getVentasByDate(date));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getClothesFromVenta(@PathVariable Long number) {
        return ResponseEntity.ok(ventaService.getClothesFromVenta(number));
    }
}

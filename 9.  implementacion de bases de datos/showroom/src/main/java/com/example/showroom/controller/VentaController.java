package com.example.showroom.controller;

import com.example.showroom.dto.VentaDto;
import com.example.showroom.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
public class VentaController {
    @Autowired
    private IVentaService iVentaService;

    @PostMapping("")
    public ResponseEntity<String> createVenta() {
        return ResponseEntity.ok("");
    }

    @GetMapping("")
    public ResponseEntity<java.lang.String> getAllVentas() {
        return ResponseEntity.ok("");
    }

    @GetMapping("/{number}")
    public ResponseEntity<java.lang.String> getVentaByNumber(@PathVariable("number") Integer numero) {
        return ResponseEntity.ok("");
    }

    @PutMapping("/{number}")
    public ResponseEntity<java.lang.String> updateVenta(@RequestBody VentaDto ventaDto, @PathVariable("number") Integer numero) {
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<java.lang.String> deleteVenta(@PathVariable("number") Integer numero) {
        return ResponseEntity.ok("");
    }

    @GetMapping("/date")
    public ResponseEntity<String> getVentaByDate(@RequestParam("date") String date) {
        return ResponseEntity.ok("");
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<java.lang.String> getPrendasByNumber(@PathVariable("number") Integer numero) {
        return ResponseEntity.ok("");
    }

}

package com.example.showroom.controller;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.VentaDto;
import com.example.showroom.service.VentaService;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class VentaController {
    @Autowired
    VentaService ventaService;

    @PostMapping
    public ResponseEntity<?> postVenta(@RequestBody VentaDto ventaDto) {
        return ResponseEntity.ok().body(ventaService.postVenta(ventaDto));
    }

    @GetMapping
    public ResponseEntity<?> getVentas(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        if (date != null) {
            return ResponseEntity.ok().body(ventaService.findPrendasFecha(date));
        }
        return ResponseEntity.ok().body(ventaService.getVentas());
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> findVentaNumero(@PathVariable Long numero){return ResponseEntity.ok().body(ventaService.findVentaNumero(numero));}
    @DeleteMapping("/delete/{number}")
    public ResponseEntity<?> deleteVenta(@PathVariable Long numero){
        return ResponseEntity.ok().body(ventaService.deleteVenta(numero));
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> putVenta(@RequestBody VentaDto ventaDto, @PathVariable Long number){return ResponseEntity.ok().body(ventaService.putVenta(number,ventaDto));}

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> findPrendaByVenta(@PathVariable Long number){
        return ResponseEntity.ok().body(ventaService.findPrendasByVenta(number));}


}

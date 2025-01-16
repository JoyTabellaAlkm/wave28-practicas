package org.example.ejercicio_practico_opcional.controller;

import org.example.ejercicio_practico_opcional.dto.PrendaDTO;
import org.example.ejercicio_practico_opcional.dto.VentaDTO;
import org.example.ejercicio_practico_opcional.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Crear una nueva venta
    @PostMapping
    public ResponseEntity<VentaDTO> createVenta(@RequestBody VentaDTO ventaDTO) {
        return new ResponseEntity<>(ventaService.createVenta(ventaDTO), HttpStatus.CREATED);
    }

    // Devolver todas las ventas
    @GetMapping
    public ResponseEntity<List<VentaDTO>> getAllVentas() {
        return new ResponseEntity<>(ventaService.findAll(), HttpStatus.OK);
    }

    // Devolver una venta en particular
    @GetMapping("/{number}")
    public ResponseEntity<VentaDTO> getVentaByNumber(@PathVariable Long number) {
        return new ResponseEntity<>(ventaService.findByNumber(number), HttpStatus.OK);
    }

    // Actualizar una venta en particular
    @PutMapping("/{number}")
    public ResponseEntity<VentaDTO> updateVenta(@PathVariable Long number, @RequestBody VentaDTO ventaDTO) {
        return new ResponseEntity<>(ventaService.updateVenta(number, ventaDTO), HttpStatus.OK);
    }

    // Eliminar una venta en particular
    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long number) {
        ventaService.deleteVenta(number);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Traer todas las ventas de una fecha determinada
    @GetMapping(params = "date")
    public ResponseEntity<List<VentaDTO>> getVentasByDate(@RequestParam String date) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formatter.parse(date);
        return new ResponseEntity<>(ventaService.findByFecha(fecha), HttpStatus.OK);

    }

    // Traer la lista completa de prendas de una venta
    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<PrendaDTO>> getClothesBySaleNumber(@PathVariable Long number) {
        return new ResponseEntity<>(ventaService.getClothesBySaleNumber(number), HttpStatus.OK);
    }
}
package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.PrendaDto;
import com.mercadolibre.showroom.dto.VentaDto;
import com.mercadolibre.showroom.service.IVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class VentaController {
    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("")
    public ResponseEntity<String> generarNuevaVenta(@RequestBody VentaDto ventaDto){
        return new ResponseEntity<>("Se creo la venta con el id: "+ ventaService.generarNuevaVenta(ventaDto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<VentaDto>> obtenerVentas(){
        return ResponseEntity.ok(ventaService.obtenerVentas());
    }

    @GetMapping("/{number}")
    public ResponseEntity<VentaDto> obtenerVenta(@PathVariable Integer number){
        return ResponseEntity.ok(ventaService.obtenerVenta(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<VentaDto> actualizarVenta(@PathVariable Integer number,
                                                      @RequestBody VentaDto ventaDto){
        return new ResponseEntity<>(ventaService.actualizarVenta(number,ventaDto),HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Integer number){
        ventaService.eliminarVenta(number);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/date")
    public ResponseEntity<List<VentaDto>> obtenerVentasXFecha(@RequestParam LocalDate date){
        return ResponseEntity.ok(ventaService.obtenerVentasXFecha(date));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<PrendaDto>> obtenerPrendasXVenta(@PathVariable Integer number){
        return ResponseEntity.ok(ventaService.obtenerPrendasXVenta(number));
    }
}

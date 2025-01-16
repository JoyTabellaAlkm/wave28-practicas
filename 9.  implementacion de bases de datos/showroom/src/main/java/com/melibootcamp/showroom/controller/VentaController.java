package com.melibootcamp.showroom.controller;

import com.melibootcamp.showroom.entity.Venta;
import com.melibootcamp.showroom.service.VentaService;
import com.melibootcamp.showroom.service.VentaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    private VentaService ventaService;

    public VentaController(VentaServiceImpl ventaServiceImpl){
        this.ventaService = ventaServiceImpl;
    }

    @GetMapping
    public ResponseEntity<?> getVentas(){
        return new ResponseEntity<>(ventaService.getVentas(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getVentaById(
            @PathVariable long id)
    {
        return new ResponseEntity<>(ventaService.getVentaById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> saveVenta(
            @RequestBody Venta venta)
    {
        return new ResponseEntity<>(ventaService.saveVenta(venta), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVenta(
            @PathVariable long id)
    {
        return new ResponseEntity<>(ventaService.deleteVenta(id), HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateVenta(
            @RequestBody Venta venta, @PathVariable long id)
    {
        return new ResponseEntity<>(ventaService.updateVenta(id, venta), HttpStatus.OK);
    }




}

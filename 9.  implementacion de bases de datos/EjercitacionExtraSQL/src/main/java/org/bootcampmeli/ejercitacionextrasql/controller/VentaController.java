package org.bootcampmeli.ejercitacionextrasql.controller;


import org.bootcampmeli.ejercitacionextrasql.dto.VentaCreateRequestDTO;
import org.bootcampmeli.ejercitacionextrasql.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sale")

public class VentaController {

    @Autowired
    private IVentaService ventaService;


    @PostMapping()
    public ResponseEntity<?> addVenta(@RequestBody VentaCreateRequestDTO venta) {
        return ResponseEntity.ok(ventaService.addVenta(venta));
    }
}

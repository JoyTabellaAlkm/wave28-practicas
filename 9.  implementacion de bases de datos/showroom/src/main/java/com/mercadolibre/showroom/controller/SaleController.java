package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.ClotheDTO;
import com.mercadolibre.showroom.dto.SaleDTO;
import com.mercadolibre.showroom.service.IClotheService;
import com.mercadolibre.showroom.service.ISaleService;
import com.mercadolibre.showroom.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody SaleDTO sale) {
        return new ResponseEntity<>(saleService.create(sale), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(saleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> findSaleByNumber(@PathVariable Integer number) {
        return new ResponseEntity<>(saleService.findSaleByNumber(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> update(@PathVariable Integer number,@RequestBody SaleDTO saleDTO) {
        return new ResponseEntity<>(saleService.update(number,saleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> delete(@PathVariable Integer number) {
        return new ResponseEntity<>(saleService.delete(number), HttpStatus.OK);
    }
}

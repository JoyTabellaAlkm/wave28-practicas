package com.mercadolibre.ejercicioextrashowroom.controller;

import com.mercadolibre.ejercicioextrashowroom.dto.request.CreateSaleDTO;
import com.mercadolibre.ejercicioextrashowroom.service.ISaleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody CreateSaleDTO createSaleDTO) {
        return new ResponseEntity<>(saleService.createSale(createSaleDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllSales() {
        return new ResponseEntity<>(saleService.getAllSales(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSaleById(@PathVariable Long id) {
        return new ResponseEntity<>(saleService.getSaleById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSaleById(@PathVariable Long id) {
        return new ResponseEntity<>(saleService.deleteSale(id), HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<?> deleteSaleById(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date ) {
        return new ResponseEntity<>(saleService.getSalesByDate(date), HttpStatus.OK);
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<?> getClothesBySaleId(@PathVariable Long id) {
        return new ResponseEntity<>(saleService.getClothesBySale(id), HttpStatus.OK);
    }

}

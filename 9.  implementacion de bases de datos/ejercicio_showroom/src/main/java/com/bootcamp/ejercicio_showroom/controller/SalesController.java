package com.bootcamp.ejercicio_showroom.controller;

import com.bootcamp.ejercicio_showroom.model.Clothes;
import com.bootcamp.ejercicio_showroom.model.Sales;
import com.bootcamp.ejercicio_showroom.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping
    public ResponseEntity<Sales> createSale(@RequestBody Sales sale) {
        return new ResponseEntity<>(salesService.createSale(sale), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{number}")
    public ResponseEntity<Sales> getSaleByNumber(@PathVariable Long number) {
        Sales sale = salesService.getSaleByNumber(number);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<Sales> updateSale(@PathVariable Long number, @RequestBody Sales sale) {
        return new ResponseEntity<>(salesService.updateSale(number, sale), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long number) {
        salesService.deleteSale(number);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(params = "date")
    public List<Sales> getSalesByDate(@RequestParam LocalDate date) {
        return salesService.getSalesByDate(date);
    }
    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<Clothes>> getSaleItemsBySaleNumber(@PathVariable Long number) {
        return new ResponseEntity<>(salesService.getClothesBySalesId(number), HttpStatus.OK);
    }
}
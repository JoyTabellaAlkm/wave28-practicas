package com.bootcamp.clothes.controller;

import com.bootcamp.clothes.dto.SaleDTO;
import com.bootcamp.clothes.service.SaleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.clothes.entity.Sale;
import com.bootcamp.clothes.entity.Clothe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody SaleDTO sale) {
        Sale newSale = saleService.createSale(sale);
        return ResponseEntity.ok(newSale);
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("/{number}")
    public ResponseEntity<Sale> getSaleByNumber(@PathVariable Long number) {
        Sale sale = saleService.getSaleByNumber(number);
        if (sale != null) {
            return ResponseEntity.ok(sale);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{number}")
    public ResponseEntity<Sale> updateSale(@PathVariable Long number, @RequestBody SaleDTO sale) {
        Sale updatedSale = saleService.updateSale(number, sale);
        if (updatedSale != null) {
            return ResponseEntity.ok(updatedSale);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long number) {
        boolean deleted = saleService.deleteSale(number);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<Set<Clothe>> getClothesBySaleNumber(@PathVariable Long number) {
        Sale sale = saleService.getSaleByNumber(number);
        if (sale != null) {
            return ResponseEntity.ok(sale.getClothes());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/clothes")
    public ResponseEntity<Set<Clothe>> getClothesBySaleDate(
            @RequestParam(value = "date") @DateTimeFormat(pattern = "dd/MM/yyyy") String dateStr
    ) {
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Set<Clothe> clothes = saleService.getClothesBySaleDate(date);
        return ResponseEntity.ok(clothes);
    }
}

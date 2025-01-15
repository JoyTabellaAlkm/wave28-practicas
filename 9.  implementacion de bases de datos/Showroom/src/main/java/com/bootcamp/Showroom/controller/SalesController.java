package com.bootcamp.Showroom.controller;

import com.bootcamp.Showroom.dto.ClothDto;
import com.bootcamp.Showroom.dto.MessageDto;
import com.bootcamp.Showroom.dto.SaleDto;
import com.bootcamp.Showroom.service.ISaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final ISaleService saleService;

    public SalesController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("")
    ResponseEntity<MessageDto> createSale(@RequestBody SaleDto sale) {
        saleService.create(sale);
        return new ResponseEntity<>(new MessageDto("Venta creada."), HttpStatus.CREATED);
    }

    @GetMapping("")
    ResponseEntity<List<SaleDto>> getAllSales() {
        return new ResponseEntity<>(saleService.getAllSales(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    ResponseEntity<SaleDto> getSaleByNumber(@PathVariable Integer number) {
        return new ResponseEntity<>(saleService.getSaleByNumber(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    ResponseEntity<MessageDto> updateSale(@PathVariable Integer number, @RequestBody SaleDto sale) {
        saleService.updateSale(number, sale);
        return new ResponseEntity<>(new MessageDto("Venta actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    ResponseEntity<MessageDto> deleteSale(@PathVariable Integer number) {
        saleService.deleteSale(number);
        return new ResponseEntity<>(new MessageDto("Venta borrada."), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/by-date")
    ResponseEntity<List<SaleDto>> getSalesByDate(@RequestParam LocalDate date) {
        return new ResponseEntity<>(saleService.getSalesByDate(date), HttpStatus.OK);
    }

    @GetMapping("/sale/clothes/{number}")
    ResponseEntity<List<ClothDto>> getClothesBySaleNumber(@PathVariable Integer number) {
        return new ResponseEntity<>(saleService.getClothesBySaleNumber(number), HttpStatus.OK);
    }
}

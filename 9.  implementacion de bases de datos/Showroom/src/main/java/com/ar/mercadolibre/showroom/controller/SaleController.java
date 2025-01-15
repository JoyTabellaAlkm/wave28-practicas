package com.ar.mercadolibre.showroom.controller;

import com.ar.mercadolibre.showroom.dto.SaleDTO;
import com.ar.mercadolibre.showroom.service.ISaleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@RequestBody SaleDTO saleDTO) {
        return new ResponseEntity<>(saleService.create(saleDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getSales(
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "dd-MM-yyyy")
            LocalDate date
    ) {
        return new ResponseEntity<>(saleService.getSales(date), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<SaleDTO> getByNumber(@PathVariable Long number) {
        return new ResponseEntity<>(saleService.getById(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<SaleDTO> update(@PathVariable Long number, @RequestBody SaleDTO saleDTO) {
        return new ResponseEntity<>(saleService.update(number, saleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long number) {
        saleService.delete(number);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<SaleDTO>> getByNumberOfClothes(@PathVariable Integer number) {
        return new ResponseEntity<>(saleService.getByClothesNumber(number), HttpStatus.OK);
    }

}

package com.ar.mercadolibre.showroom.controller;

import com.ar.mercadolibre.showroom.dto.SaleDTO;
import com.ar.mercadolibre.showroom.service.ISaleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/sale")
public class SaleController {

    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@Valid @RequestBody SaleDTO saleDTO) {
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
    public ResponseEntity<SaleDTO> getByNumber(
            @PathVariable
            @Min(value = 1, message = "El numero de prenda debe ser mayor a 1")
            Long number
    ) {
        return new ResponseEntity<>(saleService.getById(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<SaleDTO> update(
            @PathVariable
            @Min(value = 1, message = "El numero de prenda debe ser mayor a 1")
            Long number,
            @Valid
            @RequestBody
            SaleDTO saleDTO
    ) {
        return new ResponseEntity<>(saleService.update(number, saleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<HttpStatus> delete(
            @PathVariable
            @Min(value = 1, message = "El numero de prenda debe ser mayor a 1")
            Long number
    ) {
        saleService.delete(number);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<SaleDTO>> getByNumberOfClothes(
            @PathVariable
            @Min(value = 1, message = "El numero de prenda debe ser mayor a 1")
            Integer number
    ) {
        return new ResponseEntity<>(saleService.getByClothesNumber(number), HttpStatus.OK);
    }

}

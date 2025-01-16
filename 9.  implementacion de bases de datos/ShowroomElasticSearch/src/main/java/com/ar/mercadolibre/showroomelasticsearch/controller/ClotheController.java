package com.ar.mercadolibre.showroom.controller;

import com.ar.mercadolibre.showroom.dto.ClotheDTO;
import com.ar.mercadolibre.showroom.service.IClotheService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
@Validated
public class ClotheController {

    private final IClotheService clotheService;

    public ClotheController(IClotheService clotheService) {
        this.clotheService = clotheService;
    }

    @PostMapping
    public ResponseEntity<ClotheDTO> create(@Valid @RequestBody ClotheDTO clotheDTO) {
        return new ResponseEntity<>(clotheService.create(clotheDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClotheDTO>> getAll(
            @RequestParam(required = false) String name) {
        return new ResponseEntity<>(clotheService.getClothes(name), HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ClotheDTO> getById(
            @PathVariable
            @Min(value = 1, message = "El codigo de venta debe ser mayor a 1")
            Long code
    ) {
        return new ResponseEntity<>(clotheService.getById(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public  ResponseEntity<ClotheDTO> update(
            @PathVariable
            @Min(value = 1, message = "El codigo de venta debe ser mayor a 1")
            Long code,
            @Valid
            @RequestBody
            ClotheDTO clotheDTO
    ) {
        return new ResponseEntity<>(clotheService.update(code, clotheDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<HttpStatus> delete(
            @PathVariable
            @Min(value = 1, message = "El codigo de venta debe ser mayor a 1")
            Long code
    ) {
        clotheService.delete(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClotheDTO>> getBySize(
            @PathVariable
            @NotEmpty(message = "Se debe proporcionar un tamaño")
            String size
    ) {
        return new ResponseEntity<>(clotheService.getBySize(size), HttpStatus.OK);
    }
}

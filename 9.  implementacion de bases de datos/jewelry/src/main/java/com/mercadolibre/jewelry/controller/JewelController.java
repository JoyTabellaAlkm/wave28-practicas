package com.mercadolibre.jewelry.controller;

import com.mercadolibre.jewelry.dto.request.JewelRequestDto;
import com.mercadolibre.jewelry.dto.response.JewelResponseDto;
import com.mercadolibre.jewelry.service.IJewelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {
    private final IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping
    public ResponseEntity<JewelResponseDto> save(@RequestBody @Valid JewelRequestDto jewelRequestDto) {
        return new ResponseEntity<>(jewelService.save(jewelRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<JewelResponseDto>> findAll() {
        return new ResponseEntity<>(jewelService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JewelResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(jewelService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JewelResponseDto> update(@PathVariable Long id, @RequestBody @Valid JewelRequestDto jewelRequestDto) {
        return new ResponseEntity<>(jewelService.update(id, jewelRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JewelResponseDto> delete(@PathVariable Long id) {
        return new ResponseEntity<>(jewelService.delete(id), HttpStatus.OK);
    }
    
}

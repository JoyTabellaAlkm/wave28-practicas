package com.mercadolibre.autoinsurance.controller;

import com.mercadolibre.autoinsurance.dto.request.AccidentRequestDto;
import com.mercadolibre.autoinsurance.dto.response.AccidentResponseDto;
import com.mercadolibre.autoinsurance.service.IAccidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accidents")
public class AccidentController {
    private final IAccidentService accidentService;


    public AccidentController(IAccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @PostMapping
    public ResponseEntity<AccidentResponseDto> save(@RequestBody AccidentRequestDto accidentRequestDto) {
        return new ResponseEntity<>(accidentService.save(accidentRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccidentResponseDto>> findAll() {
        return new ResponseEntity<>(accidentService.findAll(), HttpStatus.OK);
    }
}

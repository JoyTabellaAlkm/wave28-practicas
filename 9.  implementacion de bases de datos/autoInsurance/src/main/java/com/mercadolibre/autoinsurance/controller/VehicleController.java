package com.mercadolibre.autoinsurance.controller;

import com.mercadolibre.autoinsurance.dto.request.VehicleRequestDto;
import com.mercadolibre.autoinsurance.dto.response.PatentBrandAndModelResponseDto;
import com.mercadolibre.autoinsurance.dto.response.PatentBrandResponseDto;
import com.mercadolibre.autoinsurance.dto.response.VehicleAccidentResponseDto;
import com.mercadolibre.autoinsurance.dto.response.VehicleResponseDto;
import com.mercadolibre.autoinsurance.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDto> save(@RequestBody VehicleRequestDto vehicleRequestDto) {
        return new ResponseEntity<>(vehicleService.save(vehicleRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> findAll() {
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/patents")
    public ResponseEntity<List<String>> listPatents() {
        return new ResponseEntity<>(vehicleService.listPatents(), HttpStatus.OK);
    }

    @GetMapping("/patents/brand")
    public ResponseEntity<List<PatentBrandResponseDto>> listPatentAndBrandOrderByYear() {
        return new ResponseEntity<>(vehicleService.listPatentAndBrandOrderByYear(), HttpStatus.OK);
    }

    @GetMapping("/patents/year")
    public ResponseEntity<List<String>> listPatentsByNumberOfWheelsAndYearOfManufacture() {
        return new ResponseEntity<>(vehicleService.listPatentsByNumberOfWheelsAndYearOfManufacture(), HttpStatus.OK);
    }

    @GetMapping("/patents/loss")
    public ResponseEntity<List<PatentBrandAndModelResponseDto>> listPatentBrandAndModelByEconomicLoss() {
        return new ResponseEntity<>(vehicleService.listPatentBrandAndModelByEconomicLoss(), HttpStatus.OK);
    }

    @GetMapping("/patents/total-loss")
    public ResponseEntity<List<VehicleAccidentResponseDto>> listVehiclesByEconomicLoss() {
        return new ResponseEntity<>(vehicleService.listVehiclesByEconomicLoss(), HttpStatus.OK);
    }


}

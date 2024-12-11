package com.mercadolibre.ejercicio_global.controller;

import com.mercadolibre.ejercicio_global.service.IVehicleService;
import com.mercadolibre.ejercicio_global.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

	IVehicleService vehicleService;

	public VehicleController(VehicleServiceImpl vehicleService) { this.vehicleService = vehicleService; }

	@GetMapping("/vehicles")
	public ResponseEntity<?> getVehicles() {
		return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
	}

	@GetMapping("/vehicles/color/{color}/year/{year}")
	public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year) {
		return ResponseEntity.ok(vehicleService.searchVehiclesByColorAndYear(color, year));
	}
}

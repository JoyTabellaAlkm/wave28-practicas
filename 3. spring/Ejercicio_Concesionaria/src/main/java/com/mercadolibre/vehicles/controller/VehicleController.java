package com.mercadolibre.vehicles.controller;

import com.mercadolibre.vehicles.dto.request.CreateVehicleDto;
import com.mercadolibre.vehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping
	public ResponseEntity<?> createVehicle(@RequestBody CreateVehicleDto createVehicleDto) {
		return ResponseEntity.ok().body(vehicleService.createVehicle(createVehicleDto));
	}

	@GetMapping
	public ResponseEntity<?> listAllVehicles() {
		return ResponseEntity.ok().body(vehicleService.listAllVehicles());
	}

	@GetMapping("/dates")
	public ResponseEntity<?> listAllVehiclesByDate(@RequestParam("since") LocalDate since, @RequestParam("to") LocalDate to) {
		return ResponseEntity.ok().body(vehicleService.listAllVehiclesByManufacturingDate(since, to));
	}

	@GetMapping("/prices")
	public ResponseEntity<?> listAllVehiclesByDate(@RequestParam("since") int since, @RequestParam("to") int to) {
		return ResponseEntity.ok().body(vehicleService.listAllVehiclesByPrice(since, to));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listAllVehiclesByDate(@PathVariable("id") int id) {
		return ResponseEntity.ok().body(vehicleService.listAllVehiclesById(id));
	}

}

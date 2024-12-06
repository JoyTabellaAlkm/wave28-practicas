package com.bootcamp.concesionariaAutos.controller;

import com.bootcamp.concesionariaAutos.dto.VehiculoDTO;
import com.bootcamp.concesionariaAutos.dto.VehiculoResponseDTO;
import com.bootcamp.concesionariaAutos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @PostMapping("/")
    public VehiculoResponseDTO addVehiculo(VehiculoDTO vehiculo) {
       return vehiculoService.addVehiculo(vehiculo);
    }
}

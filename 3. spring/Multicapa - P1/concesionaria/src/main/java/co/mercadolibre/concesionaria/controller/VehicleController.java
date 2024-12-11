package co.mercadolibre.concesionaria.controller;

import co.mercadolibre.concesionaria.dto.VehicleDTO;
import co.mercadolibre.concesionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/")
public class VehicleController {

    @Autowired
    IVehicleService vs;

    @GetMapping("vehicles/")
    public List<VehicleDTO> getVehicles(){
        return vs.listVehicles();
    }

    @PostMapping("vehicles/")
    public String getVehicles(@RequestBody VehicleDTO vehicleDTO){
        return vs.addVehicle(vehicleDTO);
    }

    @GetMapping("vehicles/dates")
    public List<VehicleDTO> getVehiclesByDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        return vs.listVehiclesByDate(since, to);
    }

    @GetMapping("vehicles/prices")
    public List<VehicleDTO> getVehiclesByPrice(@RequestParam double since, @RequestParam double to){
        return vs.listVehiclesByPrice(since, to);
    }

    @GetMapping("vehicles/{id}")
    public VehicleDTO getVehicle(@PathVariable String id){
        return vs.getVehicle(id);
    }
}

package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }


    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByColorAndYear(
    @PathVariable  String color,
    @PathVariable int year){

    List< VehicleDto> vehiculosDto=vehicleService.findByColorAndYear (color, year);
    if(vehiculosDto.isEmpty()){

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    return new ResponseEntity<>(vehiculosDto,HttpStatus.OK);

    }

    @GetMapping("vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByBrandAndYear(
            @PathVariable String brand,
            @PathVariable int start_year,
            @PathVariable int end_year)
    {
        List<VehicleDto> vehiculosDto=vehicleService.findByBrandAndYear(brand,start_year,end_year);
         if(vehiculosDto.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);

         }
         return new ResponseEntity<>(vehiculosDto,HttpStatus.OK);

    }

 @GetMapping ("vehicles/transmission/{transmission}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByTypeTransmission(
            @PathVariable  String transmission){
        List <VehicleDto> vehiculosDto=vehicleService.findByTypeTransmission(transmission);
        if(vehiculosDto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
         return new ResponseEntity<>(vehiculosDto,HttpStatus.OK);

 }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> getVehiclesByDimensions(
            @RequestParam String weight, // Recibir como String
            @RequestParam String width) { // Recibir como String

        // Extraer y convertir los valores de rango para peso
        String[] weightRange = weight.split("-");
        double min_weight = Double.parseDouble(weightRange[0]);
        double max_weight = Double.parseDouble(weightRange[1]);

        // Extraer y convertir los valores de rango para ancho
        String[] widthRange = width.split("-");
        double min_width = Double.parseDouble(widthRange[0]);
        double max_width = Double.parseDouble(widthRange[1]);

        // Llamar a la lógica de servicio con los valores convertidos
        List<VehicleDto> vehiculosDto = vehicleService.findByWidthAndWeight(min_weight, max_weight, min_width, max_width);

        if (vehiculosDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vehiculosDto, HttpStatus.OK);
    }
 



}

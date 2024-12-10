package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.CREATED);
    }

    /*  Como: Usuario de la API.
      Quiero: Listar vehículos por color y año.
      Para: Filtrar vehículos basados en esas especificaciones.
      Endpoint: GET /vehicles/color/{color}/year/{year}
      Respuestas:
              200 OK: Devuelve una lista de vehículos que cumplen con los criterios.
              404 Not Found: No se encontraron vehículos con esos criterios.
     */
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.searchVehiclesByColorAndYear(color, year), HttpStatus.OK);
    }

   /* Buscar vehículos por marca y rango de años

    Como: Usuario de la API.
    Quiero: Listar vehículos de una marca específica fabricados en un rango de años.
    Para: Realizar búsquedas más detalladas en el inventario.
            Endpoint: GET /vehicles/brand/{brand}/between/{start_year}/{end_year}
    Respuestas:
            200 OK: Devuelve una lista de vehículos que cumplen con los criterios.
            404 Not Found: No se encontraron vehículos con esos criterios.
    */

    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehiclesByBrandAndYearRange(@PathVariable String brand,
                                                            @PathVariable(value = "start_year") int startYear,
                                                            @PathVariable(value = "end_year") int endYear) {

        return new ResponseEntity<>(vehicleService.searchVehiclesByBrandAndYearRange(brand, startYear, endYear), HttpStatus.OK);
    }

 /*   Consultar velocidad promedio por marca

    Como: Usuario de la API.
    Quiero: Conocer la velocidad promedio de vehículos de una marca específica.
    Para: Comparar las prestaciones de diferentes marcas.
    Endpoint: GET /vehicles/average_speed/brand/{brand}
    Respuestas:
            200 OK: Devuelve la velocidad promedio de la marca.
404 Not Found: No se encontraron vehículos de esa marca.
  */

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.getAverageSpeedByBrand(brand), HttpStatus.OK);
    }

    /* Añadir múltiples vehículos

     Como: Usuario de la API.
     Quiero: Registrar varios vehículos al mismo tiempo.
     Para: Facilitar la carga masiva de datos en el inventario.
             Endpoint: POST /vehicles/batch
     Respuestas:
             201 Created: Vehículos creados exitosamente.
 400 Bad Request: Datos de algún vehículo mal formados o incompletos.
             409 Conflict: Algún vehículo tiene un identificador ya existente.
     */
    //@PostMapping("/batch")
   // public ResponseEntity<?> addVehicleBatch(@RequestBody List<VehicleDto> vehiclesDto) {
     //   return new ResponseEntity<>(vehicleService.addVehicleBatch(vehiclesDto), HttpStatus.CREATED);
    //}

    /* Actualizar velocidad máxima de un vehículo

    Como: Usuario de la API.
    Quiero: Modificar la velocidad máxima de un vehículo específico.
    Para: Mantener el inventario actualizado con las características correctas.
    Endpoint: PUT /vehicles/{id}/update_speed
    Respuestas:
            200 OK: Velocidad del vehículo actualizada exitosamente.
        400 Bad Request: Velocidad mal formada o fuera de rango.
        404 Not Found: No se encontró el vehículo.
     */
    @PutMapping("/{id}/update_speed")
        public ResponseEntity<VehicleDto> updateVehicleSpeed(@PathVariable Long id, @RequestParam double newSpeed) {
        return new ResponseEntity<>(vehicleService.updateVehicleSpeed(id, newSpeed), HttpStatus.OK);
    }

   /* Listar vehículos por tipo de combustible

    Como: Usuario de la API.
    Quiero: Obtener una lista de vehículos según el tipo de combustible.
    Para: Realizar búsquedas basadas en la fuente de energía del vehículo.
    Endpoint: GET /vehicles/fuel_type/{type}
    Respuestas:
            200 OK: Devuelve una lista de vehículos que usan ese tipo de combustible.
    404 Not Found: No se encontraron vehículos con ese tipo de combustible.
    */

    @GetMapping("fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuelType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getVehiclesByFuelType(type), HttpStatus.OK);
    }

   /*
   Eliminar un vehículo

    Como: Usuario de la API.
    Quiero: Borrar un vehículo de la concesionaria.
    Para: Mantener el inventario actualizado.
    Endpoint: DELETE /vehicles/{id}
    Respuestas:
            204 No Content: Vehículo eliminado exitosamente.
404 Not Found: No se encontró el vehículo.
    */

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.NO_CONTENT);
    }

    /*Buscar vehículos por tipo de transmisión

    Como: Usuario de la API.
    Quiero: Obtener una lista de vehículos basada en su tipo de transmisión (manual, automática, etc.).
    Para: Filtrar vehículos según mis preferencias de conducción.
            Endpoint: GET /vehicles/transmission/{type}
    Respuestas:
            200 OK: Devuelve una lista de vehículos con ese tipo de transmisión.
            404 Not Found: No se encontraron vehículos con ese tipo de transmisión.

     */
    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> getVehiclesByTransmission(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getVehiclesByTransmission(type), HttpStatus.OK);
    }


   /* Actualizar el tipo de combustible de un vehículo

    Como: Usuario de la API.
    Quiero: Modificar el tipo de combustible de un vehículo específico.
            Para: Mantener el inventario actualizado ante cambios en las características del vehículo.
            Endpoint: PUT /vehicles/{id}/update_fuel
    Respuestas:
            200 OK: Tipo de combustible del vehículo actualizado exitosamente.
400 Bad Request: Tipo de combustible mal formado o no admitido.
            404 Not Found: No se encontró el vehículo.
    */

     @PutMapping("/{id}/update_fuel")
      public ResponseEntity<?> updateVehicleFuel(@PathVariable Long id, @RequestParam String newFuel){
         return new ResponseEntity<>(vehicleService.updateVehicleFuel(id, newFuel), HttpStatus.OK);
    }

   /* Obtener la capacidad promedio de personas por marca

    Como: Usuario de la API.
    Quiero: Conocer la capacidad promedio de personas de los vehículos de una marca específica.
            Para: Comparar la capacidad de diferentes marcas y decidir una compra.
    Endpoint: GET /vehicles/average_capacity/brand/{brand}
    Respuestas:
            200 OK: Devuelve la capacidad promedio de personas de la marca.
404 Not Found: No se encontraron vehículos de esa marca.
    */

    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacityByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.getAverageCapacityByBrand(brand), HttpStatus.OK);
    }

   /* Buscar vehículos por dimensiones

    Como: Usuario de la API.
    Quiero: Listar vehículos basados en un rango de dimensiones (largo, ancho).
    Para: Encontrar vehículos que se adapten a mis necesidades de espacio.
    Endpoint: GET /vehicles/dimensions?length={min_length}-{max_length}&width={min_width}-{max_width}
    Respuestas:
            200 OK: Devuelve una lista de vehículos que cumplen con los criterios de dimensiones.
            404 Not Found: No se encontraron vehículos con esas dimensiones.
    */

    @GetMapping("/dimensions?length={min_length}-{max_length}&width={min_width}-{max_width}")
    public ResponseEntity<?> getVehiclesByDimension(@PathVariable double min_length,
                                                    @PathVariable double max_length,
                                                    @PathVariable double min_width,
                                                    @PathVariable double max_width) {
        return new ResponseEntity<>(vehicleService.getVehiclesByDimension(min_length,
                max_length,
                min_width,
                max_width),
                HttpStatus.OK);
    }

  /*  Listar vehículos por rango de peso

    Como: Usuario de la API.
    Quiero: Listar vehículos basados en un rango de peso.
    Para: Encontrar vehículos que cumplan con mis requisitos de carga o preferencias.
            Endpoint: GET /vehicles/weight?min={weight_min}&max={weight_max}
    Respuestas:
            200 OK: Devuelve una lista de vehículos que están en el rango de peso especificado.
404 Not Found: No se encontraron vehículos en ese rango de peso.

   */

    @GetMapping("/weight?min={weight_min}&max={weight_max}")
    public ResponseEntity<?> getVehiclesByWeight(@PathVariable double weight_min,
                                                 @PathVariable double weight_max) {
        return new ResponseEntity<>(vehicleService.getVehiclesByWeight(weight_min, weight_max), HttpStatus.OK);
    }

    /* Añadir múltiples vehículos

    Como: Usuario de la API.
    Quiero: Registrar varios vehículos al mismo tiempo.
    Para: Facilitar la carga masiva de datos en el inventario.
            Endpoint: POST /vehicles/batch
    Respuestas:
            201 Created: Vehículos creados exitosamente.
400 Bad Request: Datos de algún vehículo mal formados o incompletos.
            409 Conflict: Algún vehículo tiene un identificador ya existente.
     */

    @PostMapping("/batch")
    public ResponseEntity<?> addVehicleBatch(@RequestBody List<VehicleDto> vehiclesDto) {
        return new ResponseEntity<>(vehicleService.addVehicleBatch(vehiclesDto), HttpStatus.CREATED);
    }



}

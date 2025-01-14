package com.mercadolibre.ejercicioseguroautos.controller;

import com.mercadolibre.ejercicioseguroautos.dto.ModeloMarcaPatenteDTO;
import com.mercadolibre.ejercicioseguroautos.dto.PatenteYMarcaDTO;
import com.mercadolibre.ejercicioseguroautos.dto.VehiculoDTO;
import com.mercadolibre.ejercicioseguroautos.dto.VehiculosYTotalDTO;
import com.mercadolibre.ejercicioseguroautos.models.Vehiculo;
import com.mercadolibre.ejercicioseguroautos.repository.IVehiculoRepository;
import com.mercadolibre.ejercicioseguroautos.service.VehiculoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoServiceImpl vehiculoServiceImpl;

    public VehiculoController(VehiculoServiceImpl vehiculoServiceImpl){
        this.vehiculoServiceImpl = vehiculoServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<List<VehiculoDTO>> getAllVehiculos(){
        return ResponseEntity.ok(vehiculoServiceImpl.getAllVehiculos());
    }

    @PostMapping("")
    public ResponseEntity<VehiculoDTO> saveVehiculo(@RequestBody VehiculoDTO vehiculoDTO){
        return ResponseEntity.ok(vehiculoServiceImpl.saveVehiculo(vehiculoDTO));
    }

    // Listar las patentes de todos los vehículos registrados.
    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getPatentes(){
        return ResponseEntity.ok(vehiculoServiceImpl.getPatentes());
    }

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación
    @GetMapping("/ordenados-por-patente-y-marca")
    public ResponseEntity<List<PatenteYMarcaDTO>> getPatenteYMarca(){
        return ResponseEntity.ok(vehiculoServiceImpl.getPatentesMarcas());
    }

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @GetMapping("/patente-por-llantas-y-fecha-actual")
    public ResponseEntity<List<String>> getPatenteByWheelsAndCurrentDate(){
        return ResponseEntity.ok(vehiculoServiceImpl.getPatenteByWheelsAndCurrentDate());
    }

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos
    @GetMapping("/modelo-marca-patente-por-siniestro-mayor-a-10000")
    public ResponseEntity<List<ModeloMarcaPatenteDTO>> getModeloMarcaPatente(){
        return ResponseEntity.ok(vehiculoServiceImpl.getModeloMarcaPatente());
    }

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @GetMapping("/obtener-perdidas-totales-por-incidentes-mayores-a-10000")
    public ResponseEntity<VehiculosYTotalDTO> getTotalIncidentesMayorA10000(){
        return ResponseEntity.ok(vehiculoServiceImpl.getVehiculosYTotalPerdidas());
    }

}

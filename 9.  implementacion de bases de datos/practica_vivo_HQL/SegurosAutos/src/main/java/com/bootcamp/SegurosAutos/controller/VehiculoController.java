package com.bootcamp.SegurosAutos.controller;

import com.bootcamp.SegurosAutos.dto.MessageDto;
import com.bootcamp.SegurosAutos.dto.PatenteMarcaDto;
import com.bootcamp.SegurosAutos.dto.PatentesDto;
import com.bootcamp.SegurosAutos.dto.VehiculoDto;
import com.bootcamp.SegurosAutos.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("")
    public ResponseEntity<MessageDto> post(@RequestBody VehiculoDto vehiculo) {
        vehiculoService.post(vehiculo);
        return new ResponseEntity<>(new MessageDto("Vehiculo creado con exito"), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<VehiculoDto>> getAll() {
        return ResponseEntity.ok(vehiculoService.getAll());
    }

    @GetMapping("/patentes")
    public ResponseEntity<PatentesDto> patentes() {
        return ResponseEntity.ok(vehiculoService.patentes());
    }

    @GetMapping("/patentes_marcas_ordenadas_por_fecha_fabricacion")
    public ResponseEntity<List<PatenteMarcaDto>> patentesMarcasOrdenadasPorFechaFabricacion() {
        return ResponseEntity.ok(vehiculoService.patentesMarcasOrdenadasPorFechaFabricacion());
    }

    @GetMapping("/patentes_marcas_autos_cuatro_ruedas_fabricados_este_año")
    public ResponseEntity<List<PatenteMarcaDto>> patentesMarcasMasDeCuatroRuedasFabricadosEsteAnio() {
        return ResponseEntity.ok(vehiculoService.patentesMarcasMasDeCuatroRuedasFabricadosEsteAnio());
    }
}

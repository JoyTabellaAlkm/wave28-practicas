package com.ejercicio.autos.Controller;

import com.ejercicio.autos.DTO.UsadosDTO;
import com.ejercicio.autos.DTO.VehiculoDTO;
import com.ejercicio.autos.Service.iVehiculoService;
import jakarta.websocket.server.PathParam;
import org.apache.el.parser.AstFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VehiculoController {

    @Autowired
    private iVehiculoService servicio;

    @PostMapping("/vehicles")
    public ResponseEntity<String> agregarVehiculo(@RequestBody VehiculoDTO vehiculo) {
        if (servicio.agregarVehiculo(vehiculo)) {
            return ResponseEntity.ok("Auto agregado correctamente");
        }
        return ResponseEntity.badRequest().body("Error al agregar el auto");

    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<UsadosDTO>> retornarUsados() {
        return ResponseEntity.ok(servicio.retornarUsados());
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<VehiculoDTO>> retornarVehiculosFechas(@RequestParam LocalDate since, @RequestParam LocalDate to) {
        return ResponseEntity.ok(servicio.retornarUsadosFecha(since, to));
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<List<VehiculoDTO>> retornarVehiculosPrecios(@RequestParam double since, @RequestParam double to) {
        return ResponseEntity.ok(servicio.retornarUsadosPrecio(since,to));
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehiculoDTO> get(@PathVariable int id) {
        return ResponseEntity.ok(servicio.buscarVehiculoID(id));
    }
}
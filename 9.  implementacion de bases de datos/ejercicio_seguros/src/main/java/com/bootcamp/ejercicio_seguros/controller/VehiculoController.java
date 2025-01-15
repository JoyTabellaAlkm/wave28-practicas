package com.bootcamp.ejercicio_seguros.controller;

import com.bootcamp.ejercicio_seguros.dto.ListaVehiculoSiniestroDTO;
import com.bootcamp.ejercicio_seguros.dto.VehiculoDTO;
import com.bootcamp.ejercicio_seguros.dto.VehiculoPatenteMarcaDTO;
import com.bootcamp.ejercicio_seguros.dto.VehiculoPatenteMarcaModeloDTO;
import com.bootcamp.ejercicio_seguros.service.impl.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<VehiculoDTO> listarVehiculos() {
        return vehiculoService.listarTodos();
    }

    @GetMapping("/patentes")
    public List<String> listarPatentes() {
        return vehiculoService.listarPatentes();
    }


    @GetMapping("/patentes/ordenados")
    public List<VehiculoPatenteMarcaDTO> listarVehiculosOrdenadosPorAnio() {
        return vehiculoService.listarPatentesMarcasOrdenadasPorAnio();
    }

    @GetMapping("/filtro")
    public List<String> listarPorRuedasYAnio(@RequestParam int ruedas, @RequestParam int anio) {
        return vehiculoService.listarVehiculosPorRuedasYAnio(ruedas, anio);
    }
    @GetMapping("/perdida")
    public List<VehiculoPatenteMarcaModeloDTO> listarVehiculosConPerdidaMayor(@RequestParam int cantidad) {
        return vehiculoService.listarVehiculosConPerdidaMayor(cantidad);
    }
    @GetMapping("/perdida/total")
    public ListaVehiculoSiniestroDTO listarVehiculosConPerdidaTotalMayor(@RequestParam int cantidad) {
        return vehiculoService.listarVehiculosConPerdidaMayorTotalPerdida(cantidad);
    }
}

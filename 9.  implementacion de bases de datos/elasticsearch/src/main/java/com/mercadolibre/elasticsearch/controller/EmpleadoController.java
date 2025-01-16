package com.mercadolibre.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.elasticsearch.dto.CreateEmpleadoDto;
import com.mercadolibre.elasticsearch.entity.Empleado;
import com.mercadolibre.elasticsearch.service.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping
    public Iterable<?> findAll() {
        return empleadoService.findAll();
    }

    @PostMapping
    public Empleado save(@RequestBody CreateEmpleadoDto request) {
        return empleadoService.save(request);
    }

}

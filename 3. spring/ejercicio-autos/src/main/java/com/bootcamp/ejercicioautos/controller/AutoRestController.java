package com.bootcamp.ejercicioautos.controller;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;
import com.bootcamp.ejercicioautos.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/vehicles")
public class AutoRestController {

    @Autowired
    private IAutoService autoService;

    @PostMapping
    public ResponseEntity<?> agregarAuto(@RequestBody PostAutoDto auto) {
        return new ResponseEntity<>(autoService.agregarAuto(auto), HttpStatus.CREATED);
    }
}

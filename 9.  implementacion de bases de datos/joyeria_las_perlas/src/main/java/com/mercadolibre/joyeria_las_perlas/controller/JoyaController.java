package com.mercadolibre.joyeria_las_perlas.controller;

import com.mercadolibre.joyeria_las_perlas.dto.request.JoyaRequestDTO;
import com.mercadolibre.joyeria_las_perlas.dto.response.JoyaDTO;
import com.mercadolibre.joyeria_las_perlas.service.imp.JoyaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Joya")
public class JoyaController {
    @Autowired
    private JoyaServiceImp joyaService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(joyaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        return new ResponseEntity<>(joyaService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.save(joyaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestParam Long id, JoyaRequestDTO joyaRequestDTO){
        return new ResponseEntity<>(joyaService.edit(id, joyaRequestDTO), HttpStatus.OK);
    }

}

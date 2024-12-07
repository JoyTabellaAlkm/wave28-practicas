package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dto.PacienteDTO;
import com.bootcamp.covid19.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteServiceImpl pacienteService;
    @PostMapping("/agregarPaciente")
    public ResponseEntity<?> agregarPaciente(@RequestBody PacienteDTO paciente){
        return ResponseEntity.ok(pacienteService.agregarPaciente(paciente));
    }

    @GetMapping("/obtenerPacienteConSintomas")
    public ResponseEntity<?> obtenerPacienteMayores(){
        if (pacienteService.obtenerPacienteConSintoma().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron pacientes mayores a 60 con síntomas");
        }
        return ResponseEntity.ok(pacienteService.obtenerPacienteConSintoma());
    }

}

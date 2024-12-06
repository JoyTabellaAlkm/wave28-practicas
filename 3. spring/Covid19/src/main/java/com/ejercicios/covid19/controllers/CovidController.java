package com.ejercicios.covid19.controllers;

import com.ejercicios.covid19.DTO.response.PacienteRiesgoDTO;
import com.ejercicios.covid19.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    private IPacienteService sintomaService;

    @GetMapping("/findSymptom")
    public ResponseEntity<?> findSymptom(){
        return ResponseEntity.ok(sintomaService.devolverSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable String name){
        try {
            return ResponseEntity.ok(sintomaService.consultarSintoma(name));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("No hay ese sintoma");
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PacienteRiesgoDTO>> findRiskPerson() {
        List<PacienteRiesgoDTO> algo = sintomaService.devolverPacientesRiesgo();
        System.out.println(algo);
        return ResponseEntity.status(200).body(algo);
    }

}

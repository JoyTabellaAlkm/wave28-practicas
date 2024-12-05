package com.example.covid19.controller;

import com.example.covid19.domain.Symptom;
import com.example.covid19.dto.SymtomDTO;
import com.example.covid19.dto.SymtomIndexDTO;
import com.example.covid19.service.SymtomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/symptoms")
public class SymptomsController {

    @Autowired
    SymtomService symtomService;

    @GetMapping()
    public List<SymtomIndexDTO> findAll() {
        List<Symptom> symptoms = symtomService.findAllSymptom();

        return symptoms.stream()
                .map(s -> new SymtomIndexDTO(s.getCodigo(), s.getNombre(), s.getNivel_de_gravedad()))
                .toList();
    }

    @GetMapping("/findByName")
    public ResponseEntity<SymtomDTO> findByName(@RequestParam String name) {
        Symptom symptom = symtomService.findByName(name);

        if (symptom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new SymtomDTO(symptom.getNivel_de_gravedad()), HttpStatus.OK);
    }
}
